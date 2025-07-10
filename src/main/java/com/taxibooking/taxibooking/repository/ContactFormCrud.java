package com.taxibooking.taxibooking.repository;

import com.taxibooking.taxibooking.entity.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer> {

}
