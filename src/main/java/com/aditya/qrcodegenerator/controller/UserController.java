package com.aditya.qrcodegenerator.controller;

import com.aditya.qrcodegenerator.entity.UsersInfo;
import com.aditya.qrcodegenerator.service.UserService;
import com.aditya.qrcodegenerator.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<UsersInfo> fetchAllUsers() throws IOException, WriterException {
        List<UsersInfo> userList = userService.getAllUsers();
        if( userList.size()>0){
            for (UsersInfo users :userList){
                QRCodeGenerator.generateQRCode(users);
            }
        }

        return userList;
    }

    @PostMapping("/saveUser")
    public UsersInfo saveUser(@RequestBody UsersInfo userDataRequest){
        return userService.saveUserInfo(userDataRequest);

    }
    @GetMapping("/getUser")
    public UsersInfo getUserByID(@RequestParam("id") Long id){
        return userService.findUserByID(id);
    }
}
