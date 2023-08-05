package com.aditya.qrcodegenerator.Repository;

import com.aditya.qrcodegenerator.entity.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UsersInfo,Long> {
}
