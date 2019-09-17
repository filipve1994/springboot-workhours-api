package com.filip.springboot.workhours.controller.command;

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

}
