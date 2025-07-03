package com.taxibooking.taxibooking.dao;

import com.taxibooking.taxibooking.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String username);
}
