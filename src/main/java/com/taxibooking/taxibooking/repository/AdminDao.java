package com.taxibooking.taxibooking.repository;

import com.taxibooking.taxibooking.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "update admin set username=:newusername,password=:newpassword where username=:oldusername",
            nativeQuery = true)
    public int updateCredentials(@Param("newusername") String newUsername,
                                 @Param("newpassword") String newPassword,
                                 @Param("oldusername") String oldUsername);
}
