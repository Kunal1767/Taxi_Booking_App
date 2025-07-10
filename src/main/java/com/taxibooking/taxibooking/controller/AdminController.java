package com.taxibooking.taxibooking.controller;

import com.taxibooking.taxibooking.entity.BookingForm;
import com.taxibooking.taxibooking.service.AdminCredentialsService;
import com.taxibooking.taxibooking.service.BookingFormService;
import com.taxibooking.taxibooking.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ContactFormService contactFormService;
    @Autowired
    private BookingFormService bookingFormService;

    @Autowired
    private AdminCredentialsService adminCredentialsService;

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
    @GetMapping("/readAllBookings")
    public String readAllBookings(Model m) {
    List<BookingForm> allBookings = bookingFormService.readAllBookingService();
        m.addAttribute("allBookings", allBookings);
        return "admin/readAllBooking";
    }
    @GetMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable int id, RedirectAttributes redirectAttributes) {
        bookingFormService.deleteBookingService(id);
        redirectAttributes.addFlashAttribute("message", "Booking deleted successfully!");
        return "redirect:/admin/readAllBookings";
    }
    @GetMapping("/changeCredentials")
    public String changeCredentialsView() {
        return "admin/changecredentials";
    }
    @PostMapping("/changeCredentials")
    public String changeCredentials(
            @RequestParam("oldusername") String oldusername,
            @RequestParam("oldpassword") String oldpassword,
            @RequestParam("newusername") String newusername,
            @RequestParam("newpassword") String newpassword,
            RedirectAttributes redirectAttributes) {
        String result=   adminCredentialsService.checkAdminCredentials(oldusername, oldpassword);
        System.out.println(result);
        if(result.equals("Success")) {
            result =adminCredentialsService.updateAdminCredentials(newusername, newpassword, oldusername);
            redirectAttributes.addFlashAttribute("message", result);

        } else {
            redirectAttributes.addFlashAttribute("message",    result);    }
        return "redirect:/admin/dashboard";
    }

}
