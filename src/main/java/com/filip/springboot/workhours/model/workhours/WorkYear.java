package com.filip.springboot.workhours.model.workhours;

import com.filip.springboot.workhours.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "workyear")
public class WorkYear {

    @Id
    private String id;

    private int year;

    @DBRef(lazy = true)
    private User owner;

    //@DBRef(lazy = true)
    private List<WorkMonth> workmonths;

}
