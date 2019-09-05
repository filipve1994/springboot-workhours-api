package com.filip.springboot.workhours.controller.v1.ui;

import com.filip.springboot.workhours.controller.v1.command.AgencyFormCommand;
import com.filip.springboot.workhours.controller.v1.command.BusFormCommand;
import com.filip.springboot.workhours.controller.v1.command.PasswordFormCommand;
import com.filip.springboot.workhours.controller.v1.command.ProfileFormCommand;
import com.filip.springboot.workhours.controller.v1.command.TripFormCommand;
import com.filip.springboot.workhours.controller.v1.command.WorkdayFormCommand;
import com.filip.springboot.workhours.dto.model.bus.AgencyDto;
import com.filip.springboot.workhours.dto.model.bus.BusDto;
import com.filip.springboot.workhours.dto.model.bus.StopDto;
import com.filip.springboot.workhours.dto.model.bus.TripDto;
import com.filip.springboot.workhours.dto.model.user.UserDto;
import com.filip.springboot.workhours.model.workhours.Workday;
import com.filip.springboot.workhours.repository.workhours.WorkDayRepository;
import com.filip.springboot.workhours.service.BusReservationService;
import com.filip.springboot.workhours.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Arpit Khandelwal.
 */
@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private BusReservationService busReservationService;

    @GetMapping(value = "/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", userDto);
        modelAndView.addObject("userName", userDto.getFullName());

        //-----------------------------------


        modelAndView.addObject("standardDate", new Date());
        modelAndView.addObject("localDateTime", LocalDateTime.now());
        modelAndView.addObject("localDate", LocalDate.now());
        modelAndView.addObject("timestamp", Instant.now());

        //-----------------------------------

        Workday workday = createWorkday("1", LocalDate.of(2019, 9, 2), LocalTime.of(8, 28, 0), LocalTime.of(17, 22, 0), 8.4);
        Workday workday2 = createWorkday("2", LocalDate.of(2019, 9, 3), LocalTime.of(7, 28, 0), LocalTime.of(16, 22, 0), 8);
        List<Workday> workdays = Arrays.asList(workday, workday2);

        System.out.println("workday : " + workday.toString());
        System.out.println("workday.getTotalAmountOfHoursWorkedToday : " + workday.getTotalAmountOfHoursWorkedToday());
        System.out.println("workday.getMinimumHourToWorkTo : " + workday.getMinimumHourToWorkTo());
        System.out.println("workday.getMaximumHourToWorkTo : " + workday.getMaximumHourToWorkTo());
        System.out.println("workday.getWorkedHoursDecimal : " + workday.getWorkedHoursDecimal());
        System.out.println("workday.getEightyFiveProcentOfWorkedHoursDecimal : " + workday.getEightyFiveProcentOfWorkedHoursDecimal());
        System.out.println("workday.getFifteenProcentOfWorkedHoursDecimal : " + workday.getFifteenProcentOfWorkedHoursDecimal());

        modelAndView.addObject("workday", workday);
        modelAndView.addObject("workdays", workdays);


        return modelAndView;
    }

    @GetMapping(value = "/agency")
    public ModelAndView agencyDetails() {
        ModelAndView modelAndView = new ModelAndView("agency");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        AgencyFormCommand agencyFormCommand = new AgencyFormCommand()
                .setAgencyName(agencyDto.getName())
                .setAgencyDetails(agencyDto.getDetails());
        modelAndView.addObject("agencyFormData", agencyFormCommand);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/agency")
    public ModelAndView updateAgency(@Valid @ModelAttribute("agencyFormData") AgencyFormCommand agencyFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("agency");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("userName", userDto.getFullName());
        if (!bindingResult.hasErrors()) {
            if (agencyDto != null) {
                agencyDto.setName(agencyFormCommand.getAgencyName())
                        .setDetails(agencyFormCommand.getAgencyDetails());
                busReservationService.updateAgency(agencyDto, null);
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/bus")
    public ModelAndView busDetails() {
        ModelAndView modelAndView = new ModelAndView("bus");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("busFormData", new BusFormCommand());
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/bus")
    public ModelAndView addNewBus(@Valid @ModelAttribute("busFormData") BusFormCommand busFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("bus");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        modelAndView.addObject("userName", userDto.getFullName());
        modelAndView.addObject("agency", agencyDto);
        if (!bindingResult.hasErrors()) {
            try {
                BusDto busDto = new BusDto()
                        .setCode(busFormCommand.getCode())
                        .setCapacity(busFormCommand.getCapacity())
                        .setMake(busFormCommand.getMake());
                AgencyDto updatedAgencyDto = busReservationService.updateAgency(agencyDto, busDto);
                modelAndView.addObject("agency", updatedAgencyDto);
                modelAndView.addObject("busFormData", new BusFormCommand());
            } catch (Exception ex) {
                bindingResult.rejectValue("code", "error.busFormCommand", ex.getMessage());
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/trip")
    public ModelAndView tripDetails() {
        ModelAndView modelAndView = new ModelAndView("trip");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        Set<StopDto> stops = busReservationService.getAllStops();
        List<TripDto> trips = busReservationService.getAgencyTrips(agencyDto.getCode());
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("stops", stops);
        modelAndView.addObject("trips", trips);
        modelAndView.addObject("tripFormData", new TripFormCommand());
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/trip")
    public ModelAndView addNewTrip(@Valid @ModelAttribute("tripFormData") TripFormCommand tripFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("trip");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        Set<StopDto> stops = busReservationService.getAllStops();
        List<TripDto> trips = busReservationService.getAgencyTrips(agencyDto.getCode());

        modelAndView.addObject("stops", stops);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("userName", userDto.getFullName());
        modelAndView.addObject("trips", trips);

        if (!bindingResult.hasErrors()) {
            try {
                TripDto tripDto = new TripDto()
                        .setSourceStopCode(tripFormCommand.getSourceStop())
                        .setDestinationStopCode(tripFormCommand.getDestinationStop())
                        .setBusCode(tripFormCommand.getBusCode())
                        .setJourneyTime(tripFormCommand.getTripDuration())
                        .setFare(tripFormCommand.getTripFare())
                        .setAgencyCode(agencyDto.getCode());
                busReservationService.addTrip(tripDto);

                trips = busReservationService.getAgencyTrips(agencyDto.getCode());
                modelAndView.addObject("trips", trips);
                modelAndView.addObject("tripFormData", new TripFormCommand());
            } catch (Exception ex) {
                bindingResult.rejectValue("sourceStop", "error.tripFormData", ex.getMessage());
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/profile")
    public ModelAndView getUserProfile() {
        ModelAndView modelAndView = new ModelAndView("profile");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        ProfileFormCommand profileFormCommand = new ProfileFormCommand()
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setMobileNumber(userDto.getMobileNumber());
        PasswordFormCommand passwordFormCommand = new PasswordFormCommand()
                .setEmail(userDto.getEmail())
                .setPassword(userDto.getPassword());
        modelAndView.addObject("profileForm", profileFormCommand);
        modelAndView.addObject("passwordForm", passwordFormCommand);
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/profile")
    public ModelAndView updateProfile(@Valid @ModelAttribute("profileForm") ProfileFormCommand profileFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("profile");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        PasswordFormCommand passwordFormCommand = new PasswordFormCommand()
                .setEmail(userDto.getEmail())
                .setPassword(userDto.getPassword());
        modelAndView.addObject("passwordForm", passwordFormCommand);
        modelAndView.addObject("userName", userDto.getFullName());
        if (!bindingResult.hasErrors()) {
            userDto.setFirstName(profileFormCommand.getFirstName())
                    .setLastName(profileFormCommand.getLastName())
                    .setMobileNumber(profileFormCommand.getMobileNumber());
            userService.updateProfile(userDto);
            modelAndView.addObject("userName", userDto.getFullName());
        }
        return modelAndView;
    }

    @PostMapping(value = "/password")
    public ModelAndView changePassword(@Valid @ModelAttribute("passwordForm") PasswordFormCommand passwordFormCommand, BindingResult bindingResult) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("profile");
            ProfileFormCommand profileFormCommand = new ProfileFormCommand()
                    .setFirstName(userDto.getFirstName())
                    .setLastName(userDto.getLastName())
                    .setMobileNumber(userDto.getMobileNumber());
            modelAndView.addObject("profileForm", profileFormCommand);
            modelAndView.addObject("userName", userDto.getFullName());
            return modelAndView;
        } else {
            userService.changePassword(userDto, passwordFormCommand.getPassword());
            return new ModelAndView("login");
        }
    }

    @GetMapping(value = "/workmonth")
    public ModelAndView getWorkMonth() {
        ModelAndView modelAndView = new ModelAndView("workmonth");

        modelAndView.addObject("standardDate", new Date());
        modelAndView.addObject("localDateTime", LocalDateTime.now());
        modelAndView.addObject("localDate", LocalDate.now());
        modelAndView.addObject("timestamp", Instant.now());

        //-----------------------------------

        Workday workday = createWorkday("1", LocalDate.of(2019, 9, 2), LocalTime.of(8, 28, 0), LocalTime.of(17, 22, 0), 8.4);
        Workday workday2 = createWorkday("2", LocalDate.of(2019, 9, 3), LocalTime.of(7, 28, 0), LocalTime.of(16, 22, 0), 8);
        List<Workday> workdays = Arrays.asList(workday, workday2);
        List<Workday> workdays2 = workDayRepository.findAll();



        System.out.println("workday : " + workday.toString());
        System.out.println("workday.getTotalAmountOfHoursWorkedToday : " + workday.getTotalAmountOfHoursWorkedToday());
        System.out.println("workday.getMinimumHourToWorkTo : " + workday.getMinimumHourToWorkTo());
        System.out.println("workday.getMaximumHourToWorkTo : " + workday.getMaximumHourToWorkTo());
        System.out.println("workday.getWorkedHoursDecimal : " + workday.getWorkedHoursDecimal());
        System.out.println("workday.getEightyFiveProcentOfWorkedHoursDecimal : " + workday.getEightyFiveProcentOfWorkedHoursDecimal());
        System.out.println("workday.getFifteenProcentOfWorkedHoursDecimal : " + workday.getFifteenProcentOfWorkedHoursDecimal());

        modelAndView.addObject("workday", workday);
        modelAndView.addObject("workdays", workdays);
        modelAndView.addObject("workdays2", workdays2);

        WorkdayFormCommand workdayFormCommand = new WorkdayFormCommand();
        workdayFormCommand.setWorkdayList(workdays2);
        logger.info(workdayFormCommand.toString());


        modelAndView.addObject("form", workdayFormCommand);

        return modelAndView;
    }

    @Autowired
    private WorkDayRepository workDayRepository;

    @PostMapping(value = "/workmonth/edit/{id}")
    public String updateWorkMonth(@PathVariable("id") String id, @Valid Workday workday, BindingResult bindingResult) {
        //ModelAndView modelAndView = new ModelAndView("workmonth");

        logger.info("updateWorkMonth controller : => id : " + id + " - workday from form : " + workday);
        logger.info("updateWorkMonth controller : => id : " + id + " - workday from form : " + workday.toString());

        logger.info("Hour arrived from form input : " + workday.getHourArrived());
        logger.info("Hour left from form input : " + workday.getHourLeft());
        logger.info("bruto werkuren from form input : " + workday.getBrutoWorkedHours());

        Workday ww = workDayRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        logger.info("old workday : " + ww.toString());

        ww.setHourArrived(workday.getHourArrived());
        ww.setHourLeft(workday.getHourLeft());
        ww.setBrutoWorkedHours(workday.getBrutoWorkedHours());

        logger.info("updated old workday : " + ww.toString());

        workDayRepository.save(ww);

        //ww.setHourArrived()

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDto userDto = userService.findUserByEmail(auth.getName());
//        PasswordFormCommand passwordFormCommand = new PasswordFormCommand()
//                .setEmail(userDto.getEmail())
//                .setPassword(userDto.getPassword());
//        modelAndView.addObject("passwordForm", passwordFormCommand);
//        modelAndView.addObject("userName", userDto.getFullName());
        if (!bindingResult.hasErrors()) {
//            userDto.setFirstName(profileFormCommand.getFirstName())
//                    .setLastName(profileFormCommand.getLastName())
//                    .setMobileNumber(profileFormCommand.getMobileNumber());
            //userService.updateProfile(userDto);
            //modelAndView.addObject("userName", userDto.getFullName());
        }
        // return modelAndView;

        return "redirect:/workmonth";
    }

    @PostMapping(value = "/workmonth/save/")
    public String updateWorkMonthPostSave(@ModelAttribute WorkdayFormCommand form, Model model) {
        logger.info("updateWorkMonthPostSave");

        List<Workday> workdayListFromForm = form.getWorkdayList();
        for (Workday ww : workdayListFromForm) {
        //List<WorkdayDto> workdayListFromForm = form.getWorkdayList();
//        for (WorkdayDto ww : workdayListFromForm) {
            logger.info("from FORM list objects");

            logger.info(ww.toString());
            logger.info("id : " + ww.getId());

            Workday workday2 = workDayRepository.findByIdQuery(ww.getId());
            if (workday2 == null) {
                logger.info("workday2 is null");
            } else {
                logger.info("workday2 is NOT null");
            }

            Workday workday = workDayRepository.findById(ww.getId()).orElseThrow(IllegalArgumentException::new);
            workday.setHourArrived(ww.getHourArrived());
            workday.setHourLeft(ww.getHourLeft());
            workday.setBrutoWorkedHours(ww.getBrutoWorkedHours());

            workDayRepository.save(workday);
        }

        // workDayRepository.saveAll(form.getWorkdayList());

        return "redirect:/workmonth";
    }

    private Workday createWorkday(
            String id,
            LocalDate date,
            LocalTime hourArrived,
            LocalTime hourLeft,
            double brutoWorkedHours) {
        Workday workday = new Workday();
        workday.setId(id);
        workday.setDate(date);
        workday.setHourArrived(hourArrived);
        workday.setHourLeft(hourLeft);

        //workday.setTotalAmountOfHoursWorkedToday)
        //workday.setMinimumHourToWorkTo()
        //workday.setMaximumHourToWorkTo();

        workday.setBrutoWorkedHours(brutoWorkedHours);

        //workday.setWorkedHoursDecimal();
        //workday.setEightyFiveProcentOfWorkedHoursDecimal()
        //workday.setFifteenProcentOfWorkedHoursDecimal()
        //workday.setHoursToWorkEachDay()
        //workday.setMiddayBreak()
        //workday.setVacationDayOrNot()

        return workday;
    }


}
