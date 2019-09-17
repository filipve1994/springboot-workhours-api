package com.filip.springboot.workhours.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSignupRequest {

    @ApiModelProperty(example = "filipve@outlook.com")
    @NotEmpty(message = "{email.notempty}")
    private String email;

    @ApiModelProperty(example = "123456")
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String password;

    @ApiModelProperty(example = "Filip")
    @NotEmpty(message = "{firstname.notempty}")
    private String firstName;

    @ApiModelProperty(example = "Vanden Eynde")
    @NotEmpty(message = "{lastname.notempty}")
    private String lastName;

    @ApiModelProperty(example = "0477123456")
    private String mobileNumber;
}
