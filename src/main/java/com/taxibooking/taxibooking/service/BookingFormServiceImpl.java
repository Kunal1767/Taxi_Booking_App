package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.repository.BookingFormCrud;
import com.taxibooking.taxibooking.entity.BookingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingFormServiceImpl implements BookingFormService{

    @Autowired
    private BookingFormCrud bookingFormCrud;
    @Override
    public BookingForm saveBookingFormService(BookingForm bookingForm) {
            return bookingFormCrud.save(bookingForm);
    }

    @Override
    public List<BookingForm> readAllBookingService() {
        return bookingFormCrud.findAll();
    }

    @Override
    public void deleteBookingService(int id) {
        bookingFormCrud.deleteById(id);
    }
}
