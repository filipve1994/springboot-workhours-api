package com.filip.springboot.workhours.dto.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

    @ApiModelProperty(example = "filipve@outlook.com")
    @NotNull(message = "{constraints.NotEmpty.message}")
    private String email;

    @ApiModelProperty(example = "123456")
    @NotNull(message = "{constraints.NotEmpty.message}")
    private String password;
}