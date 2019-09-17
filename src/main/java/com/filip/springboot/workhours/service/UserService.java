package com.filip.springboot.workhours.service;

import com.filip.springboot.workhours.controller.request.UserSignupRequest;
import com.filip.springboot.workhours.dto.model.user.UserDto;

/**
 * Created by Arpit Khandelwal.
 */
public interface UserService {
    /**
     * Register a new user
     *
     * @param userDto
     * @return
     */
    UserDto signup(UserDto userDto);

    /**
     * Register a new user in the database
     *
     * @param userSignupRequest
     * @return
     */
    UserDto registerUser(UserSignupRequest userSignupRequest, boolean isAdmin);

    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    UserDto findUserByEmail(String email);

    /**
     * Update profile of the user
     *
     * @param userDto
     * @return
     */
    UserDto updateProfile(UserDto userDto);

    /**
     * Update password
     *
     * @param newPassword
     * @return
     */
    UserDto changePassword(UserDto userDto, String newPassword);
}
