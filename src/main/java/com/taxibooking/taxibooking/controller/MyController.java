package com.taxibooking.taxibooking.controller;

import com.taxibooking.taxibooking.entity.BookingForm;
import com.taxibooking.taxibooking.entity.ContactForm;
import com.taxibooking.taxibooking.entity.ServiceForm;
import com.taxibooking.taxibooking.service.BookingFormService;
import com.taxibooking.taxibooking.service.ContactFormService;
import com.taxibooking.taxibooking.service.ServiceFormService;
import com.taxibooking.taxibooking.service.ServiceFormServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ContactFormService contactFormService;
    @Autowired
    private BookingFormService bookingFormService;
    @Autowired
    private ServiceFormService serviceFormService;


    @GetMapping(path = {"/", "/home", "/index", "/welcome"})
    public String welcomeView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        m.addAttribute("bookingForm" , new BookingForm());
        return "index";
    }

    @GetMapping("about")
    public String aboutView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "about";
    }

    @GetMapping("cars")
    public String carsView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        return "cars";
    }

    @GetMapping("services")
    public String servicesView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        List<ServiceForm> allServices = serviceFormService.readAllService();
        m.addAttribute("allServices", allServices);
        return "services";
    }

    @GetMapping("contacts")
    public String contactView(HttpServletRequest req, Model m) {
        String requestURI = req.getRequestURI();
        m.addAttribute("mycurrentpage", requestURI);
        m.addAttribute("contactForm", new ContactForm());
        return "contacts";
    }


    @PostMapping("contactform")
    public String contactform(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            m.addAttribute("bindingResult", bindingResult); // Optional
            return "contacts";
        }
        ContactForm saveContactForm =  contactFormService.saveContactForm(contactForm);
        if(saveContactForm != null) {
            redirectAttributes.addFlashAttribute("Message", "Contact form submitted successfully!");
        }else{
            redirectAttributes.addFlashAttribute("Message", "Something went wrong. Please try again.");
        }

        return "redirect:/contacts";
    }
    @PostMapping("/bookingform")
    public String bookingform(
            @Valid @ModelAttribute BookingForm bookingForm,
            BindingResult bindingResult,
            Model m,
            RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            m.addAttribute("bindingResult", bindingResult);
            return "index";
        }

        if (bookingForm.getAdult() + bookingForm.getChildren() > 4) {
            m.addAttribute("message", "The total number of adults and children cannot exceed 4.");
            return "index";
        }

        BookingForm  saveBookingFormService =  bookingFormService.saveBookingFormService(bookingForm);
        if(saveBookingFormService != null) {
            redirectAttributes.addFlashAttribute("message", "Booking form submitted successfully!");
        }else{
            redirectAttributes.addFlashAttribute("message", "Something went wrong. Please try again.");
        }
        return "redirect:/index";

    }
    @GetMapping("/login")
    public String adminloginView(HttpServletRequest request, Model m) {
        ServletContext servletContext = request.getServletContext();
        Object Attribute = servletContext.getAttribute("logout");
        if (Attribute instanceof Boolean) {
            m.addAttribute("logout", Attribute);
            servletContext.removeAttribute("logout");
        }
        return "adminlogin";
    }


}
