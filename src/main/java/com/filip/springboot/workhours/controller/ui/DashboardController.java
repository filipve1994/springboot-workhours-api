package com.filip.springboot.workhours.controller.ui;

import com.filip.springboot.workhours.controller.command.PasswordFormCommand;
import com.filip.springboot.workhours.controller.command.ProfileFormCommand;
import com.filip.springboot.workhours.controller.command.WorkdayFormCommand;
import com.filip.springboot.workhours.dto.model.user.UserDto;
import com.filip.springboot.workhours.model.workhours.WorkMonth;
import com.filip.springboot.workhours.model.workhours.Workday;
import com.filip.springboot.workhours.repository.workhours.WorkDayRepository;
import com.filip.springboot.workhours.repository.workhours.WorkMonthRepository;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Arpit Khandelwal.
 */
@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

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

    @GetMapping(value = "/works/workmonth/{month}")
    public ModelAndView getWorkMonth2(@PathVariable("month") String month) {
        logger.info("workmonth2 : month => " + month);

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

        WorkMonth workMonth = workMonthRepository.findByIdQuery("10");

        modelAndView.addObject("workday", workday);
        modelAndView.addObject("workdays", workdays);
        modelAndView.addObject("workdays2", workdays2);
        modelAndView.addObject("workMonth", workMonth);

        WorkdayFormCommand workdayFormCommand = new WorkdayFormCommand();
        workdayFormCommand.setWorkdayList(workdays2);

        WorkdayFormCommand workdayFormCommand2 = new WorkdayFormCommand();
        workdayFormCommand2.setWorkdayList(workMonth.getWorkdays());

        modelAndView.addObject("form", workdayFormCommand);
        modelAndView.addObject("form2", workdayFormCommand2);

        return modelAndView;
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

        WorkMonth workMonth = workMonthRepository.findByIdQuery("10");

        modelAndView.addObject("workday", workday);
        modelAndView.addObject("workdays", workdays);
        modelAndView.addObject("workdays2", workdays2);
        modelAndView.addObject("workMonth", workMonth);

        WorkdayFormCommand workdayFormCommand = new WorkdayFormCommand();
        workdayFormCommand.setWorkdayList(workdays2);

        WorkdayFormCommand workdayFormCommand2 = new WorkdayFormCommand();
        workdayFormCommand2.setWorkdayList(workMonth.getWorkdays());

        modelAndView.addObject("form", workdayFormCommand);
        modelAndView.addObject("form2", workdayFormCommand2);

        return modelAndView;
    }

    @Autowired
    private WorkDayRepository workDayRepository;

    @Autowired
    private WorkMonthRepository workMonthRepository;

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
            logger.info("from FORM list objects");

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

    @PostMapping(value = "/workmonth/save2/{id}")
    public String updateWorkMonthPostSave2(@ModelAttribute WorkdayFormCommand form2, @PathVariable("id") String id, Model model) {
        logger.info("updateWorkMonthPostSave2");

        WorkMonth byIdQuery = workMonthRepository.findByIdQuery(id);
        List<Workday> workdays = byIdQuery.getWorkdays();
        logger.info("workdays from oktober : " + workdays.size());

        List<Workday> workdayListFromForm = form2.getWorkdayList();

        List<Workday> updatedWorkdays = new ArrayList<>();

        for (Workday ww : workdayListFromForm) {
            logger.info("from FORM2 list objects");

            logger.info("id : " + ww.getId());

            //for (Workday workday : workdays) {
            for (int i = 0; i < workdays.size(); i++) {
                Workday workday = workdays.get(i);
                logger.info("second for loop : workday.getId : " + workday.getId() + " - workdayfromfrom.getId : " + ww.getId());
                logger.info("workday.getId().equals(ww.getId()) : " + workday.getId().equals(ww.getId()));

                if (workday.getId().equals(ww.getId())) {
                    workday.setHourArrived(ww.getHourArrived());
                    workday.setHourLeft(ww.getHourLeft());
                    workday.setBrutoWorkedHours(ww.getBrutoWorkedHours());

//                    workDayRepository.save(workday);

                    updatedWorkdays.add(workday);

                    workdays.remove(i);

                    break;
                }
            }

        }

        byIdQuery.setWorkdays(updatedWorkdays);

        workMonthRepository.save(byIdQuery);

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
