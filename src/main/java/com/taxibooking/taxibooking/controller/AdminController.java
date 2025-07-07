package com.taxibooking.taxibooking.controller;

import com.taxibooking.taxibooking.model.ContactForm;
import com.taxibooking.taxibooking.service.BookingFormService;
import com.taxibooking.taxibooking.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ContactFormService contactFormService;
    @Autowired
    private BookingFormService bookingFormService;



    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/readAllContacts")
    public String readAllContacts(Model m) {
        m.addAttribute("allcontacts", contactFormService.readAllContactService());
        return "admin/readAllContacts";
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable int id, RedirectAttributes redirectAttributes) {
        contactFormService.deleteContactService(id);
        redirectAttributes.addFlashAttribute("message", "Contact deleted successfully!");
        return "redirect:/admin/readAllContacts";
    }

}
