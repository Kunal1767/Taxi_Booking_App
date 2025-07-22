package com.taxibooking.taxibooking.repository;

import com.taxibooking.taxibooking.entity.ServiceForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceFormCrud extends JpaRepository<ServiceForm,Integer> {
}
