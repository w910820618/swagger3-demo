package com.yj.swagger3.demo.web.controller;


import com.yj.swagger3.demo.web.domain.User;
import com.yj.swagger3.demo.web.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * UserController
 *
 * @author Daily Programmer
 * @since 2020-10-24 16:18
 **/
@Slf4j
@Api(tags = "UserController")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // init user list
    private static List<User> userList = new ArrayList<>();

    static {

        for (int i = 0; i < 20; i++) {
            User u = new User();
            u.setId(i);
            u.setUsername(UUID.randomUUID().toString());
            u.setAddress("address-" + i);
            u.setTelephone("1001011-" + i);
            userList.add(u);
        }
    }

    // create user list
    @ApiOperation(value = "Create user list", notes = "Create user list")
    @GetMapping("/createList")
    public void createList() {
        for (User user : userList) {
            userService.addUser(user);
        }
    }


    // create user
    @ApiOperation(value = "Create user", notes = "Create user")
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    // get user by id
    @ApiOperation(value = "Get user by id", notes = "Get user by id")
    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    // get user list
    @ApiOperation(value = "Get user list", notes = "Get user list")
    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.selectAll();
    }

    // update user
    @ApiOperation(value = "Update user", notes = "Update user")
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        userService.updateByPrimaryKey(user);
        return user;
    }

    // delete user by id
    @ApiOperation(value = "Delete user by id", notes = "Delete user by id")
    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteByPrimaryKey(id);
        return "success";
    }

}
