package com.filip.springboot.workhours.controller.api;

import com.filip.springboot.workhours.model.user.User;
import com.filip.springboot.workhours.model.workhours.WorkYear;
import com.filip.springboot.workhours.repository.ProductRepository;
import com.filip.springboot.workhours.repository.user.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class WorkhoursController {

    private static final Logger logger = LoggerFactory.getLogger(WorkhoursController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/workyears")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity workyears(@ApiParam(hidden = true, readOnly = true) Authentication authentication) {
        logger.info("WorkhoursController class");

        String authnameemail = authentication.getName();
        User byEmail = userRepository.findByEmail(authnameemail);
        List<WorkYear> workYears = byEmail.getWorkYears();

        return ResponseEntity.ok(workYears);
    }

    @GetMapping(value = "/workyears/{year}")
    //@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity getworkyearofuser(Authentication authentication, @PathVariable("year") String year) {
        logger.info("WorkhoursController class - year : " + year);

        String authnameemail = authentication.getName();
        User byEmail = userRepository.findByEmail(authnameemail);
        List<WorkYear> workYears = byEmail.getWorkYears();

        return ResponseEntity.ok(workYears);
    }


}
