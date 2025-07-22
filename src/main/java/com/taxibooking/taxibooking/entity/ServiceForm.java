package com.taxibooking.taxibooking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "service")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ServiceForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String image;
    private String title;
    private String description;

}
