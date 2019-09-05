package com.filip.springboot.workhours.model.workhours;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "workmonth")
public class WorkMonth {

    @Id
    private String id;

    @DBRef(lazy = true)
    private Set<WorkWeek> workdays;

}
