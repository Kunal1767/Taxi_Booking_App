package com.taxibooking.taxibooking.entity;

import jakarta.persistence.*;
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
@Table(name = "bookingform")
public class BookingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;

    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only alphabetic characters and spaces")
    private String name;

    @Column(name = "`from`", length = 50, nullable = false)
    @NotBlank(message = "Starting location is required")
    @Size(min = 2, max = 50, message = "Starting location should be between 2 and 50 characters")
    private String from;

    @Column(name = "`to`", length = 50, nullable = false)
    @NotBlank(message = "Destination is required")
    @Size(min = 2, max = 50, message = "Destination should be between 2 and 50 characters")
    private String to;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "time", nullable = false)
    @NotNull(message = "Time is required")
    private LocalTime time;

    @Column(name = "date", nullable = false)
    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Date must be today or in the future")
    private LocalDate date;

    @Column(name = "comfort", length = 20, nullable = false)
    @NotBlank(message = "Comfort type is required")
    @Size(min = 2, max = 20, message = "Comfort type should be between 2 and 20 characters")
    private String comfort;

    @Column(name = "adult", nullable = false)
    @Min(value = 1, message = "There should be at least 1 adult")
    @Max(value = 4, message = "Maximum number of adults is 4")
    private int adult;

    @Column(name = "children", nullable = false)
    @Min(value = 0, message = "Children count cannot be negative")
    @Max(value = 3, message = "Maximum number of children is 3")
    private int children;

    @Column(name = "message", length = 200, nullable = false)
    @NotBlank(message = "Message cannot be blank")
    @Size(max = 200, message = "Message can't exceed 200 characters")
    private String message;

}
