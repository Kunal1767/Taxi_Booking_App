package com.taxibooking.taxibooking.dao;

import com.taxibooking.taxibooking.model.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFormCrud extends JpaRepository<BookingForm,Integer>{

}