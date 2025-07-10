package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.repository.ContactFormCrud;
import com.taxibooking.taxibooking.entity.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactFormServiceImpl implements ContactFormService {

    private ContactFormCrud contactFormCrud;

    @Autowired
    public void setContactFormCrud(ContactFormCrud contactFormCrud) {
        this.contactFormCrud = contactFormCrud;
    }

    @Override
    public ContactForm saveContactForm(ContactForm contactForm) {
        return contactFormCrud.save(contactForm); // ✅ instance method call
    }

    @Override
    public List<ContactForm> readAllContactService() {
        return contactFormCrud.findAll(); // ✅ instance method call
    }

    @Override
    public void deleteContactService(int id) {
        contactFormCrud.deleteById(id);
    }
}
