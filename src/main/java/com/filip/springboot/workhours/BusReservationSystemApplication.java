package com.filip.springboot.workhours;

import com.filip.springboot.workhours.model.bus.Agency;
import com.filip.springboot.workhours.model.bus.Bus;
import com.filip.springboot.workhours.model.bus.Stop;
import com.filip.springboot.workhours.model.bus.Trip;
import com.filip.springboot.workhours.model.bus.TripSchedule;
import com.filip.springboot.workhours.model.user.Role;
import com.filip.springboot.workhours.model.user.User;
import com.filip.springboot.workhours.model.workhours.WorkMonth;
import com.filip.springboot.workhours.model.workhours.WorkWeek;
import com.filip.springboot.workhours.model.workhours.Workday;
import com.filip.springboot.workhours.repository.bus.AgencyRepository;
import com.filip.springboot.workhours.repository.bus.BusRepository;
import com.filip.springboot.workhours.repository.bus.StopRepository;
import com.filip.springboot.workhours.repository.bus.TripRepository;
import com.filip.springboot.workhours.repository.bus.TripScheduleRepository;
import com.filip.springboot.workhours.repository.user.RoleRepository;
import com.filip.springboot.workhours.repository.user.UserRepository;
import com.filip.springboot.workhours.repository.workhours.WorkDayRepository;
import com.filip.springboot.workhours.repository.workhours.WorkMonthRepository;
import com.filip.springboot.workhours.repository.workhours.WorkWeekRepository;
import com.filip.springboot.workhours.util.DateUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

@SpringBootApplication
public class BusReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusReservationSystemApplication.class, args);
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Brussels"));
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository,
                           StopRepository stopRepository, AgencyRepository agencyRepository,
                           BusRepository busRepository, TripRepository tripRepository,
                           TripScheduleRepository tripScheduleRepository,
                           WorkDayRepository workDayRepository,
                           WorkWeekRepository workWeekRepository,
                           WorkMonthRepository workMonthRepository) {
        return args -> {
            //Create Admin and Passenger Roles
            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setRole("ADMIN");
                roleRepository.save(adminRole);
            }

            Role userRole = roleRepository.findByRole("PASSENGER");
            if (userRole == null) {
                userRole = new Role();
                userRole.setRole("PASSENGER");
                roleRepository.save(userRole);
            }

            //Create an Admin user
            User admin = userRepository.findByEmail("admin.agencya@gmail.com");
            if (admin == null) {
                admin = new User()
                        .setEmail("admin.agencya@gmail.com")
                        .setPassword("$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO") // "123456"
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setMobileNumber("9425094250")
                        .setRoles(new HashSet<>(Arrays.asList(adminRole)));
                userRepository.save(admin);
            }

            //Create four stops
            Stop stopA = stopRepository.findByCode("STPA");
            if (stopA == null) {
                stopA = new Stop()
                        .setName("Stop A")
                        .setDetail("Near hills")
                        .setCode("STPA");
                stopRepository.save(stopA);
            }

            Stop stopB = stopRepository.findByCode("STPB");
            if (stopB == null) {
                stopB = new Stop()
                        .setName("Stop B")
                        .setDetail("Near river")
                        .setCode("STPB");
                stopRepository.save(stopB);
            }

            Stop stopC = stopRepository.findByCode("STPC");
            if (stopC == null) {
                stopC = new Stop()
                        .setName("Stop C")
                        .setDetail("Near desert")
                        .setCode("STPC");
                stopRepository.save(stopC);
            }

            Stop stopD = stopRepository.findByCode("STPD");
            if (stopD == null) {
                stopD = new Stop()
                        .setName("Stop D")
                        .setDetail("Near lake")
                        .setCode("STPD");
                stopRepository.save(stopD);
            }

            //Create an Agency
            Agency agencyA = agencyRepository.findByCode("AGENCYA");
            if (agencyA == null) {
                agencyA = new Agency()
                        .setName("Green Mile Agency")
                        .setCode("AGENCYA")
                        .setDetails("Reaching desitnations with ease")
                        .setOwner(admin);
                agencyRepository.save(agencyA);
            }

            //Create a bus
            Bus busA = busRepository.findByCode("AGENCYA-1");
            if (busA == null) {
                busA = new Bus()
                        .setCode("AGENCYA-1")
                        .setAgency(agencyA)
                        .setCapacity(60);
                busRepository.save(busA);
            }

            //Add busA to set of buses owned by Agency 'AGENCYA'
            if (agencyA.getBuses() == null) {
                Set<Bus> buses = new HashSet<>();
                agencyA.setBuses(buses);
                agencyA.getBuses().add(busA);
                agencyRepository.save(agencyA);
            }

            //Create a Trip
            Trip trip = tripRepository.findBySourceStopAndDestStopAndBus(stopA, stopB, busA);
            if (trip == null) {
                trip = new Trip()
                        .setSourceStop(stopA)
                        .setDestStop(stopB)
                        .setBus(busA)
                        .setAgency(agencyA)
                        .setFare(100)
                        .setJourneyTime(60);
                tripRepository.save(trip);
            }

            //Create a trip schedule
            TripSchedule tripSchedule = tripScheduleRepository.findByTripDetailAndTripDate(trip, DateUtils.todayStr());
            if (tripSchedule == null) {
                tripSchedule = new TripSchedule()
                        .setTripDetail(trip)
                        .setTripDate(DateUtils.todayStr())
                        .setAvailableSeats(trip.getBus().getCapacity());
                tripScheduleRepository.save(tripSchedule);
            }

            createSampleWorkdays(workDayRepository);


            List<Workday> workdays = workDayRepository.findAll();
            for (Workday ww : workdays) {
                System.out.println(ww.toString());
            }

            createSampleWorkWeeks(workWeekRepository, workDayRepository);

            createSampleWorkMonths(workMonthRepository, workWeekRepository);

        };


    }

    private void createSampleWorkdays(WorkDayRepository workDayRepository) {
        //zondag 1 september 2019
        Workday workday1 = workDayRepository.findByIdQuery("1");
        if (workday1 == null) {
            System.out.println("workday1 is null");
            workday1 = createWorkday(
                    "1",
                    LocalDate.of(2019, 9, 1),
                    LocalTime.of(0, 0, 0),
                    LocalTime.of(0, 0, 0),
                    0);
            workDayRepository.save(workday1);
        } else {
            System.out.println("workday1 is not null");
        }

        Workday workday2 = workDayRepository.findByIdQuery("2");
        if (workday2 == null) {
            System.out.println("workday2 is null");
            workday2 = createWorkday(
                    "2",
                    LocalDate.of(2019, 9, 2),
                    LocalTime.of(8, 28, 0),
                    LocalTime.of(17, 22, 0),
                    8.4);
            workDayRepository.save(workday2);
        } else {
            System.out.println("workday2 is not null");
        }

        Workday workday3 = workDayRepository.findByIdQuery("3");
        if (workday3 == null) {
            System.out.println("workday3 is null");
            workday3 = createWorkday(
                    "3",
                    LocalDate.of(2019, 9, 3),
                    LocalTime.of(8, 17, 0),
                    LocalTime.of(17, 21, 0),
                    8.55);
            workDayRepository.save(workday3);
        } else {
            System.out.println("workday3 is not null");
        }

        Workday workday4 = workDayRepository.findByIdQuery("4");
        if (workday4 == null) {
            System.out.println("workday4 is null");
            workday4 = createWorkday(
                    "4",
                    LocalDate.of(2019, 9, 4),
                    LocalTime.of(7, 6, 0),
                    LocalTime.of(16, 23, 0),
                    8.77);
            workDayRepository.save(workday4);
        } else {
            System.out.println("workday4 is not null");
        }

        Workday workday5 = workDayRepository.findByIdQuery("5");
        if (workday5 == null) {
            System.out.println("workday5 is null");
            workday5 = createWorkday(
                    "5",
                    LocalDate.of(2019, 9, 5),
                    LocalTime.of(8, 40, 0),
                    LocalTime.of(17, 21, 0),
                    8.19);
            workDayRepository.save(workday5);
        } else {
            System.out.println("workday5 is not null");
        }

        Workday workday6 = workDayRepository.findByIdQuery("6");
        if (workday6 == null) {
            System.out.println("workday6 is null");
            workday6 = createWorkday(
                    "6",
                    LocalDate.of(2019, 9, 6),
                    LocalTime.of(8, 4, 0),
                    LocalTime.of(0, 0, 0),
                    0);
            workDayRepository.save(workday6);
        } else {
            System.out.println("workday6 is not null");
        }

        Workday workday7 = workDayRepository.findByIdQuery("7");
        if (workday7 == null) {
            System.out.println("workday7 is null");
            workday7 = createWorkday(
                    "7",
                    LocalDate.of(2019, 9, 7),
                    LocalTime.of(0, 0, 0),
                    LocalTime.of(0, 0, 0),
                    0);
            workDayRepository.save(workday7);
        } else {
            System.out.println("workday7 is not null");
        }

        Workday workday8 = workDayRepository.findByIdQuery("8");
        if (workday8 == null) {
            System.out.println("workday8 is null");
            workday8 = createWorkday(
                    "8",
                    LocalDate.of(2019, 9, 8),
                    LocalTime.of(0, 0, 0),
                    LocalTime.of(0, 0, 0),
                    0);
            workDayRepository.save(workday8);
        } else {
            System.out.println("workday8 is not null");
        }
    }

    private void createSampleWorkWeeks(WorkWeekRepository workWeekRepository, WorkDayRepository workDayRepository) {

        //zondag 1 september 2019
        Workday workday1 = workDayRepository.findByIdQuery("1");

        List<Workday> workdays = workDayRepository.findAll();

        WorkWeek workWeek1 = workWeekRepository.findByIdQuery("1");

        if (workWeek1 == null) {
            System.out.println("workWeek1 is null");
            workWeek1 = createWorkWeek("1", workdays);
            workWeekRepository.save(workWeek1);
        } else {
            System.out.println("workWeek1 is not null");
        }


    }

    private void createSampleWorkMonths(WorkMonthRepository workMonthRepository, WorkWeekRepository workWeekRepository) {

        //zondag 1 september 2019
        WorkWeek workWeek1 = workWeekRepository.findByIdQuery("1");

        List<WorkWeek> workWeeks = workWeekRepository.findAll();

        WorkMonth workMonth1 = workMonthRepository.findByIdQuery("1");

        if (workMonth1 == null) {
            System.out.println("workMonth1 is null");
            workMonth1 = createWorkMonth("1", workWeeks);
            workMonthRepository.save(workMonth1);
        } else {
            System.out.println("workMonth1 is not null");
        }


    }

    private WorkMonth createWorkMonth(String id, List<WorkWeek> workWeeks) {
        WorkMonth workMonth = new WorkMonth();
        workMonth.setId(id);
        workMonth.setWorkweeks(workWeeks);

        return workMonth;
    }

    private WorkWeek createWorkWeek(String id, List<Workday> workdays) {

        WorkWeek workWeek = new WorkWeek();
        workWeek.setId(id);
        workWeek.setWorkdays(workdays);

        return workWeek;

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

        //

        workday.setTotalAmountOfHoursWorkedToday();
        workday.setMinimumHourToWorkTo();
        workday.setMaximumHourToWorkTo();

        //

        workday.setBrutoWorkedHours(brutoWorkedHours);

        //

        workday.setWorkedHoursDecimal();
        workday.setEightyFiveProcentOfWorkedHoursDecimal();
        workday.setFifteenProcentOfWorkedHoursDecimal();
        //workday.setHoursToWorkEachDay();
        //workday.setMiddayBreak();
        //workday.setVacationDayOrNot();

        //

        return workday;
    }
}
