package com.filip.springboot.workhours.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Arpit Khandelwal.
 */
@Component
public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Returns today's date as java.util.Date object
     *
     * @return today's date as java.util.Date object
     */
    public static Date today() {
        return new Date();
    }

    /**
     * Returns today's date as yyyy-MM-dd format
     *
     * @return today's date as yyyy-MM-dd format
     */
    public static String todayStr() {
        return sdf.format(today());
    }

    /**
     * Returns the formatted String date for the passed java.util.Date object
     *
     * @param date
     * @return
     */
    public static String formattedDate(Date date) {
        return date != null ? sdf.format(date) : todayStr();
    }

    public static boolean checkIfDayIsWeekendDay(LocalDate date) {
//        System.out.println("checkIfDayIsWeekendDay in DateUtils is being used");
//        System.out.println(date.toString());

        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    public static int getAmountOfDaysOfMonth(int month, int year) {

        int number_Of_DaysInMonth = 0;
        String MonthOfName = "Unknown";

        switch (month) {
            case 1:
                MonthOfName = "January";
                number_Of_DaysInMonth = 31;
                break;
            case 2:
                MonthOfName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
                break;
            case 3:
                MonthOfName = "March";
                number_Of_DaysInMonth = 31;
                break;
            case 4:
                MonthOfName = "April";
                number_Of_DaysInMonth = 30;
                break;
            case 5:
                MonthOfName = "May";
                number_Of_DaysInMonth = 31;
                break;
            case 6:
                MonthOfName = "June";
                number_Of_DaysInMonth = 30;
                break;
            case 7:
                MonthOfName = "July";
                number_Of_DaysInMonth = 31;
                break;
            case 8:
                MonthOfName = "August";
                number_Of_DaysInMonth = 31;
                break;
            case 9:
                MonthOfName = "September";
                number_Of_DaysInMonth = 30;
                break;
            case 10:
                MonthOfName = "October";
                number_Of_DaysInMonth = 31;
                break;
            case 11:
                MonthOfName = "November";
                number_Of_DaysInMonth = 30;
                break;
            case 12:
                MonthOfName = "December";
                number_Of_DaysInMonth = 31;
        }
        System.out.print(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days\n");

        return number_Of_DaysInMonth;
    }

    // https://stackoverflow.com/questions/8940438/number-of-days-in-particular-month-of-particular-year
    public static int getDaysOfMonthJava8(YearMonth yearMonth) {
        return yearMonth.lengthOfMonth();
    }

    public static int getWeeksOfMonthJava8(YearMonth yearMonth){
        return 4;
    }

    public static int getListOfWorkDaysOfSpecificMonth(YearMonth yearMonth){
        Month month = yearMonth.getMonth();
        int monthValue = yearMonth.getMonthValue();
        int lengthOfMonth = yearMonth.lengthOfMonth();
        for(int i = 1; i < lengthOfMonth; i++){
            System.out.println(LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), i));
        }

        return 0;
    }

}
