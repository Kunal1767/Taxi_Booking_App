package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.model.ContactForm;

import java.util.List;

public interface ContactFormService {
    public ContactForm saveContactForm(ContactForm contactForm);
    public List<ContactForm> readAllContactService();
    public void deleteContactService(int id);
}
