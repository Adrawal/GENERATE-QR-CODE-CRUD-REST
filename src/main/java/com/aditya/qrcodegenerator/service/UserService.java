package com.aditya.qrcodegenerator.service;

import com.aditya.qrcodegenerator.entity.UsersInfo;

import java.util.List;

public interface UserService {

    public List<UsersInfo> getAllUsers();

    public UsersInfo saveUserInfo(UsersInfo userData);

    public UsersInfo findUserByID(Long id);

}
