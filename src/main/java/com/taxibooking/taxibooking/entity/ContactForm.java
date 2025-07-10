package com.taxibooking.taxibooking.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contactform")
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 50 characters")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    @Column(length = 50)
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    @NotEmpty(message = "Phone number cannot be empty")
    @Column(length = 10)
    private String phone;


    @NotEmpty(message = "Message cannot be empty")
    @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters")
    @Column(length = 500)
    private String message;


}
