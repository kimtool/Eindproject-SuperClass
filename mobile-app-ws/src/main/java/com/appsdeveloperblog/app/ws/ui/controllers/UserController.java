package com.appsdeveloperblog.app.ws.ui.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

// this registers this class as a rest controller and makes It able to receive http-requests 
@RestController
// this annotation is responsible for operations that have to do with the users: create new user, update user etc
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    // Autowire the UserService interface
    @Autowired
    UserService userService;

    @GetMapping(path="{id}")
    public UserRest getUser(@PathVariable String id) {
    	
    	UserRest returnValue = new UserRest();
    	
    	return returnValue;
    }

    // @RequestBody UserDetailsRequestModel userDetails: with this set in the
    // parameter, this method converts incoming json into a java object

    @PostMapping
    // UserRest is the return value in this method. Because the UserRest class will return back details
    // to the client.
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        // instantiating a new object of UserRest
        // creating a return value of the UserRest datatype. This is the information that is going
        // to be returned
        UserRest returnValue = new UserRest();

        // instantiating a new object of UserDto and populate this object with information that is
        // received from the request body and for that the BeanUtils class is used/imported, which copies the
        // given property value of the given source bean/object(userDetails) into the target bean/object(userDto)
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        // here the instance of UserDto 'userDto' which is created in the UI level, is passed to the service layer
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        // return back details to the client via the UserRest class
        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}