package com.aditya.qrcodegenerator.service;

import com.aditya.qrcodegenerator.Repository.UserRepo;
import com.aditya.qrcodegenerator.entity.UsersInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    @Override
    public List<UsersInfo> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UsersInfo saveUserInfo(UsersInfo userData) {
        return userRepo.save(userData);
    }

    @Override
    public UsersInfo findUserByID(Long id) {
        return userRepo.findById(id).orElseThrow( ()-> new RuntimeException("UserNotFound"));
    }
}
