package com.filip.springboot.workhours.model.workhours;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Filip Vanden Eynde.
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "workday")
public class Workday {

    @Id
    private String id;

    private String date;

    private String hourArrived;

    private String hourLeft;

    private String totalAmountOfHoursWorkedToday;

    private String minimumHourToWorkTo;

    private String maximumHourToWorkTo;

    private String brutoWorkedHours;

    private double workedHoursDecimal;

    private double eightyFiveProcentOfWorkedHoursDecimal;

    private double fifteenProcentOfWorkedHoursDecimal;

    private int hoursToWorkEachDay;

}
