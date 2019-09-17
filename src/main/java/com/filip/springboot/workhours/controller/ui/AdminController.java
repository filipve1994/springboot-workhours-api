package com.filip.springboot.workhours.controller.ui;


import org.springframework.stereotype.Controller;

/**
 * Created by Arpit Khandelwal.
 */

@Controller
public class AdminController {

//    @Autowired
//    private UserService userService;
//

//
//    @PostMapping(value = "/signup")
//    public ModelAndView createNewAdmin(@Valid @ModelAttribute("adminSignupFormData") AdminSignupFormCommand adminSignupFormCommand, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView("signup");
//        if (bindingResult.hasErrors()) {
//            return modelAndView;
//        } else {
//            try {
//                UserDto newUser = registerAdmin(adminSignupFormCommand);
//            } catch (Exception exception) {
//                bindingResult.rejectValue("email", "error.adminSignupFormCommand", exception.getMessage());
//                return modelAndView;
//            }
//        }
//        return new ModelAndView("login");
//    }
//
//    /**
//     * Register a new user in the database
//     *
//     * @param adminSignupRequest
//     * @return
//     */
//    private UserDto registerAdmin(@Valid AdminSignupFormCommand adminSignupRequest) {
//        UserDto userDto = new UserDto()
//                .setEmail(adminSignupRequest.getEmail())
//                .setPassword(adminSignupRequest.getPassword())
//                .setFirstName(adminSignupRequest.getFirstName())
//                .setLastName(adminSignupRequest.getLastName())
//                .setMobileNumber(adminSignupRequest.getMobileNumber())
//                .setAdmin(true);
//        UserDto admin = userService.signup(userDto); //register the admin
//        return admin;
//    }
}
