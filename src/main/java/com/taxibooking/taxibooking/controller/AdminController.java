package com.taxibooking.taxibooking.controller;

import com.taxibooking.taxibooking.entity.BookingForm;
import com.taxibooking.taxibooking.entity.ServiceForm;
import com.taxibooking.taxibooking.service.AdminCredentialsService;
import com.taxibooking.taxibooking.service.BookingFormService;
import com.taxibooking.taxibooking.service.ContactFormService;
import com.taxibooking.taxibooking.service.ServiceFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    @Autowired
    private ServiceFormService serviceFormService;


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

    @GetMapping("/addService")
    public String addServiceView() {
        return "admin/addService";
    }
    @InitBinder
    public void stopBinding(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("image");
    }
    @PostMapping("/addService")
    public String addService(@ModelAttribute ServiceForm serviceForm,@RequestParam("image") MultipartFile multipartFile,RedirectAttributes redirectAttributes) {
        String originalFilename = multipartFile.getOriginalFilename();
        serviceForm.setImage(originalFilename);
        try {
            ServiceForm service = serviceFormService.addService(serviceForm, multipartFile);
            if (service != null) {
                redirectAttributes.addFlashAttribute("msg", "Service added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Failed to add service. Please try again.");
            }
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "Error occurred while adding service: " + e.getMessage());
        }
        return "redirect:/admin/addService";
    }

}
