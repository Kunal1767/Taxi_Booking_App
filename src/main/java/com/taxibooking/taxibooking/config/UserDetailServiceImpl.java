package com.taxibooking.taxibooking.config;

import com.taxibooking.taxibooking.repository.AdminDao;
import com.taxibooking.taxibooking.entity.Admin;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminDao adminDao;

    @PostConstruct
    public void init(){
       long count = adminDao.count();
       if(count==0){
           Admin admin = new Admin();
           admin.setUsername("admin");
           admin.setPassword(passwordEncoder.encode("admin123"));
           adminDao.save(admin);
       }

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        select id, username, password from admin where username = ?;
        Optional<Admin> byUsername = adminDao.findByUsername(username);
        Admin admin= byUsername.orElseThrow(() -> new UsernameNotFoundException("User not found with username: "));
        return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();
    }
}
