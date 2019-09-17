package com.filip.springboot.workhours.model.user;

import com.filip.springboot.workhours.model.workhours.WorkYear;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * Created by Arpit Khandelwal.
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "user")
public class User {
    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private boolean enabled;

    @DBRef
    private Set<Role> roles;

    //@DBRef
    private List<WorkYear> workYears;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
