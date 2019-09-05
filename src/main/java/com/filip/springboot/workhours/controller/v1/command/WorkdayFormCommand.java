package com.filip.springboot.workhours.controller.v1.command;

import com.filip.springboot.workhours.model.workhours.Workday;
import lombok.ToString;

import java.util.List;

/**
 * Created by Filip Vanden Eynde.
 */
@ToString
////@Getter
////@Setter
//@NoArgsConstructor
//@Accessors(chain = true)
public class WorkdayFormCommand {

    private List<Workday> workdayList;

    public WorkdayFormCommand() {
    }

    public WorkdayFormCommand(List<Workday> workdayList) {
        this.workdayList = workdayList;
    }

    public void addWorkday(Workday workday){
        this.workdayList.add(workday);
    }

    public List<Workday> getWorkdayList() {
        return workdayList;
    }

    public void setWorkdayList(List<Workday> workdayList) {
        this.workdayList = workdayList;
    }

//    private List<WorkdayDto> workdayList;
//
//    public WorkdayFormCommand() {
//    }
//
//    public WorkdayFormCommand(List<WorkdayDto> workdayList) {
//        this.workdayList = workdayList;
//    }
//
//    public void addWorkday(WorkdayDto workday){
//        this.workdayList.add(workday);
//    }
//
//    public List<WorkdayDto> getWorkdayList() {
//        return workdayList;
//    }
//
//    public void setWorkdayList(List<WorkdayDto> workdayList) {
//        this.workdayList = workdayList;
//    }


    //    private LocalTime hourArrived;
//
//    private LocalTime hourLeft;
//
//    private double brutoWorkedHours;

}
