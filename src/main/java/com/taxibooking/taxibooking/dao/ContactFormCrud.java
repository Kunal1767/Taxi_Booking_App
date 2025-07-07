package com.taxibooking.taxibooking.dao;

import com.taxibooking.taxibooking.model.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer> {

}
