package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.entity.Admin;
import com.taxibooking.taxibooking.repository.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminCredientialsServiceImpl implements AdminCredentialsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminDao adminDao;

    @Override
    public String checkAdminCredentials(String oldUsername, String oldPassword) {
        Optional<Admin> byUsername= adminDao.findByUsername(oldUsername);
        if(byUsername.isPresent()) {
            Admin admin = byUsername.get();
            if (passwordEncoder.matches(oldPassword, admin.getPassword())) {
                return "Success";
            } else {
                return "wrong old credientials";
            }
        }
        return "wrong old credentials";
    }

    @Override
    public String updateAdminCredentials(String newUsername, String newPassword, String oldUsername) {
       int updatecredential= adminDao.updateCredentials(newUsername,passwordEncoder.encode(newPassword),oldUsername);
        if(updatecredential==1){
            return "Credentials updated successfully";
        }

        return "failed to update credentials";
    }
}
