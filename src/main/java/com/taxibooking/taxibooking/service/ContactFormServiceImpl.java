package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.dao.ContactFormCrud;
import com.taxibooking.taxibooking.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
