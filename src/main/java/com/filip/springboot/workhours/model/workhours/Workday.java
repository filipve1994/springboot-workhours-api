package com.filip.springboot.workhours.model.workhours;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filip.springboot.workhours.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Filip Vanden Eynde.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "workday")
public class Workday {

    private static final Logger logger = LoggerFactory.getLogger(Workday.class);

    @Id
    private String id;

    @JsonFormat(timezone = "Europe/Brussels", pattern = "EEEE dd MMM yyyy")
    private LocalDate date;

    @JsonFormat(timezone = "Europe/Brussels", pattern = "HH:mm")
    private LocalTime hourArrived;

    private LocalTime hourLeft;

    private LocalTime totalAmountOfHoursWorkedToday;

    public LocalTime getTotalAmountOfHoursWorkedToday() {

        if (DateUtils.checkIfDayIsWeekendDay(getDate())) {
            logger.info("getDate() : " + getDate() + " is weekend day");
            return LocalTime.of(0, 0, 0);
        } else {

            if (getHourArrived().isBefore(getHourLeft())) {
                Duration between = Duration.between(getHourArrived(), getHourLeft());
                long seconds = between.getSeconds();

                int p1 = (int) (seconds % 60);
                int p2 = (int) (seconds / 60);
                int p3 = p2 % 60;

                p2 = p2 / 60;

                return LocalTime.of(p2, p3, p1);
            } else {
                return LocalTime.of(0, 0, 0);
            }
        }

    }

    public void setTotalAmountOfHoursWorkedToday() {

        if (DateUtils.checkIfDayIsWeekendDay(getDate())) {

            logger.info("getDate() : " + getDate() + " is weekend day");

            this.totalAmountOfHoursWorkedToday = LocalTime.of(0, 0, 0);

        } else {
            if (getHourArrived().isBefore(getHourLeft())) {
                Duration between = Duration.between(getHourArrived(), getHourLeft());
                long seconds = between.getSeconds();

                int p1 = (int) (seconds % 60);
                int p2 = (int) (seconds / 60);
                int p3 = p2 % 60;

                p2 = p2 / 60;

                this.totalAmountOfHoursWorkedToday = LocalTime.of(p2, p3, p1);

            } else {
                this.totalAmountOfHoursWorkedToday = LocalTime.of(0, 0, 0);
            }
        }
    }

    private LocalTime minimumHourToWorkTo;

    public LocalTime getMinimumHourToWorkTo() {
        //return minimumHourToWorkTo;

        if (DateUtils.checkIfDayIsWeekendDay(getDate())) {

            logger.info("getDate() : " + getDate() + " is weekend day");
            return LocalTime.of(0, 0, 0);

        }

        LocalTime newTime = getHourArrived().plusHours(8);
        return newTime.plusMinutes(30);
    }

    public void setMinimumHourToWorkTo() {
        if (DateUtils.checkIfDayIsWeekendDay(getDate())) {

            logger.info("getDate() : " + getDate() + " is weekend day");

            this.minimumHourToWorkTo = LocalTime.of(0, 0, 0);


        }


        LocalTime newTime = getHourArrived().plusHours(8);
        this.minimumHourToWorkTo = newTime.plusMinutes(30);

    }

    private LocalTime maximumHourToWorkTo;

    public LocalTime getMaximumHourToWorkTo() {
        //return maximumHourToWorkTo;

        if (DateUtils.checkIfDayIsWeekendDay(getDate())) {

            logger.info("getDate() : " + getDate() + " is weekend day");

            return LocalTime.of(0, 0, 0);

        }

        LocalTime newTime = getHourArrived().plusHours(9);
        return newTime.plusMinutes(30);

    }

    public void setMaximumHourToWorkTo() {

        if (DateUtils.checkIfDayIsWeekendDay(getDate())) {

            logger.info("getDate() : " + getDate() + " is weekend day");

            this.maximumHourToWorkTo = LocalTime.of(0, 0, 0);

        }

        LocalTime newTime = getHourArrived().plusHours(9);
        this.maximumHourToWorkTo = newTime.plusMinutes(30);

    }


    private double brutoWorkedHours;

    public void setBrutoWorkedHours(double brutoWorkedHours) {
        this.brutoWorkedHours = brutoWorkedHours;
    }

    private double workedHoursDecimal;

    public double getWorkedHoursDecimal() {
        //return workedHoursDecimal;
        if (getBrutoWorkedHours() > 9) {
            return 9;
        } else {
            return getBrutoWorkedHours();
        }
    }

    public void setWorkedHoursDecimal() {
        if (getBrutoWorkedHours() > 9) {
            this.workedHoursDecimal = 9;
        } else {
            this.workedHoursDecimal = getBrutoWorkedHours();
        }
    }

    private double eightyFiveProcentOfWorkedHoursDecimal;

    public double getEightyFiveProcentOfWorkedHoursDecimal() {
        //return eightyFiveProcentOfWorkedHoursDecimal;
        return getWorkedHoursDecimal() * 0.85;
    }

    public void setEightyFiveProcentOfWorkedHoursDecimal() {
        //this.eightyFiveProcentOfWorkedHoursDecimal = eightyFiveProcentOfWorkedHoursDecimal;
        this.eightyFiveProcentOfWorkedHoursDecimal = getWorkedHoursDecimal() * 0.85;
    }

    private double fifteenProcentOfWorkedHoursDecimal;

    public double getFifteenProcentOfWorkedHoursDecimal() {
        //return fifteenProcentOfWorkedHoursDecimal;
        return getWorkedHoursDecimal() * 0.15;
    }

    public void setFifteenProcentOfWorkedHoursDecimal() {
        //this.fifteenProcentOfWorkedHoursDecimal = fifteenProcentOfWorkedHoursDecimal;
        this.fifteenProcentOfWorkedHoursDecimal = getWorkedHoursDecimal() * 0.15;
    }

    @Transient
    private LocalTime hoursToWorkEachDay = LocalTime.of(8, 0, 0);

    @Transient
    private LocalTime middayBreak = LocalTime.of(0, 30, 0);

    private boolean vacationDayOrNot = false;

}
