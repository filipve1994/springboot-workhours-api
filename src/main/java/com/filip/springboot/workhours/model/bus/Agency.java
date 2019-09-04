package com.filip.springboot.workhours.model.bus;

import com.filip.springboot.workhours.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Created by Arpit Khandelwal.
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "agency")
public class Agency {
    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String code;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String name;

    private String details;

    @DBRef(lazy = true)
    private User owner;

    @DBRef(lazy = true)
    private Set<Bus> buses;
}
