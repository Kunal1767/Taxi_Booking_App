package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.dao.BookingFormCrud;
import com.taxibooking.taxibooking.model.BookingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingFormServiceImpl implements BookingFormService{

    @Autowired
    private BookingFormCrud bookingFormCrud;
    @Override
    public BookingForm saveBookingFormService(BookingForm bookingForm) {
            return bookingFormCrud.save(bookingForm);
    }
}
