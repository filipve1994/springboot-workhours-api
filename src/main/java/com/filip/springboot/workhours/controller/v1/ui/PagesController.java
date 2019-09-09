package com.filip.springboot.workhours.controller.v1.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PagesController {

    private static final Logger logger = LoggerFactory.getLogger(PagesController.class);

    @GetMapping(value = "/workyear")
    public ModelAndView getWorkMonth() {
        ModelAndView modelAndView = new ModelAndView("workyear");

        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        modelAndView.addObject("months", months);

        return modelAndView;
    }


}
