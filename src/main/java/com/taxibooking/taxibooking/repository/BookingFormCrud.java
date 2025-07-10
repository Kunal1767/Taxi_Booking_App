package com.taxibooking.taxibooking.repository;

import com.taxibooking.taxibooking.entity.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFormCrud extends JpaRepository<BookingForm,Integer>{

}