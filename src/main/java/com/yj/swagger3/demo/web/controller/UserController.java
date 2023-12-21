package com.yj.swagger3.demo.web.controller;

import com.yj.swagger3.demo.web.model.User;
import com.yj.swagger3.demo.web.model.UserVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * UserController
 * @author Daily Programmer
 * @since 2020-10-24 16:18
 **/
@Slf4j
@Api(tags = "UserController")
@RestController
@RequestMapping("/user")
public class UserController {

    static List<User> list= new ArrayList<>();
    static Long maxLimit=20L ;
    static {

        for (long i = 0; i < maxLimit; i++) {
            User u=new User()
                    .setId(i)
                    .setUserName(UUID.randomUUID().toString())
                    .setAddress("address-"+i)
                    .setPhone("1001011-"+i);
            list.add(u);

        }
    }

    /**
     * Get a list of user information
     * @return
     */
    @ApiOperation(value = "Get a list of users",notes = "Get all user information",tags ={"Get a list of user information tags"},response = List.class)
    @GetMapping("/getUserList")
    public List<User> getUserList(){

        return list;
    }

    /**
     * Obtain user information based on user ID and address
     * @param userId
     * @param address
     * @return
     */
    @ApiOperation(value = "API for obtaining user information",notes = "Get all user information - a single input parameter",tags ={"API for obtaining user information tags"},response = User.class)
    @GetMapping("/getUser")
    public User getUser(@ApiParam(name = "userId",value = "User Id",required = true) Long userId,
                        @ApiParam(name = "address",value = "User Address",required = true) String address){

       return  list.stream().filter(u->u.getId().equals(userId) && u.getAddress().equals(address))
                     .filter(Objects::nonNull)
                     .findFirst()
                     .orElse(new User())
                ;
    }

    /**
     * Obtain user information based on user ID and address
     * @param userVO
     * @return
     */
    @ApiOperation(value = "API 2 for obtaining user information",notes = "Obtain User Information API 2 - Entity Object Input Parameter",tags ={"API 2 for obtaining user information tags"},response = User.class)
    @PostMapping("/getUser2")
    public User getUser2(@RequestBody UserVO userVO){

        return  list.stream().filter(u->u.getId().equals(userVO.getId())
                                    && u.getAddress().equals(userVO.getAddress()))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(new User())
                ;
    }

    /**
     * Delete User
     * @param userId
     * @return
     */
    @ApiOperation(value = "Delete User Interface",notes = "Delete the userId parameter of the user interface")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "User Id", required = true),
    })
    @PostMapping("/deleteUser")
    public String deleteUser(Long userId){

        list.stream().filter(u->u.getId().equals(userId))
                    .filter(Objects::isNull)
                    .findFirst()
                    .ifPresent(u1->list.removeIf(Objects::isNull))
        ;

        return "success";
    }


    @ApiOperation(value = "Upload file interface",notes = "Upload file interface")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "Uploader")
    })
    @PostMapping(value = "/uploadFile")
    public String uploadFile(@RequestParam("name") String name,@RequestPart("file") MultipartFile file){
        String path = System.getProperty("user.dir");
        String originalFilename = file.getOriginalFilename();
        String filePath=path + File.separator + originalFilename ;
        Optional.ofNullable(file)
                .filter(Objects::nonNull)
                .filter(f->!f.isEmpty())
                .ifPresent(file1 -> {
                    try {
                        file1.transferTo(new File(filePath));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        log.info("name---{}",name);
        return "success";
    }
}
