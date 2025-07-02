package com.taxibooking.taxibooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BookingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive(message = "ID must be a positive number")
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only alphabetic characters and spaces")
    private String name;

    @NotBlank(message = "Starting location is required")
    @Size(min = 2, max = 50, message = "Starting location should be between 2 and 50 characters")
    @Column(name = "`from`") // escape reserved keyword
    private String from;

    @NotBlank(message = "Destination is required")
    @Size(min = 2, max = 50, message = "Destination should be between 2 and 50 characters")
    @Column(name = "`to`") // escape reserved keyword
    private String to;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Time is required")
    private LocalTime time;

    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Date must be today or in the future")
    private LocalDate date;

    @NotBlank(message = "Comfort type is required")
    @Size(min = 2, max = 20, message = "Comfort type should be between 2 and 20 characters")
    private String comfort;

    @Min(value = 1, message = "There should be at least 1 adult")
    @Max(value = 4, message = "Maximum number of adults is 4")
    private int adult;

    @Min(value = 0, message = "Children count cannot be negative")
    @Max(value = 3, message = "Maximum number of children is 3")
    private int children;

    @NotBlank(message = "Message cannot be blank")
    @Size(max = 200, message = "Message can't exceed 200 characters")
    private String message;


}
