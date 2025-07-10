package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.entity.BookingForm;

import java.util.List;

public interface BookingFormService {
    BookingForm saveBookingFormService(BookingForm bookingForm);
    public List<BookingForm> readAllBookingService();
     void deleteBookingService(int id);

}
