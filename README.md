# 🚖 Taxi Booking System - Spring Boot Application

A simple and efficient **Taxi Booking System** built using **Spring Boot**, designed to collect ride booking details through a web form. The system validates user input and restricts booking based on business rules (like the maximum number of passengers allowed per booking).

---

## 📌 Features

- User-friendly **booking form** with real-time validation
- Input validation using **Jakarta Bean Validation (JSR-380)**
- Dynamic form handling with **Thymeleaf**
- Restriction: Maximum 4 passengers (Adults + Children)
- Feedback mechanism for both success and validation errors
- Uses **MySQL** database for persistent storage
- Built with **Spring Boot**, **Spring MVC**, **Spring Data JPA**, and **Thymeleaf**

---

## 🛠️ Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **Spring MVC**
- **Spring Validation (JSR-380)**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL**
- **Maven**

---

## 🧾 Booking Form Details

The form collects the following fields:

- Name
- From (Pickup location)
- To (Drop location)
- Email
- Time
- Date
- Comfort (Cheap / Standard / Lux)
- Adults (1-4)
- Children (0-3)
- Message

---

## 🚦 Business Rules

- Total number of passengers (Adults + Children) **must not exceed 4**
- All fields are validated using annotations like `@NotBlank`, `@Email`, `@Size`, `@Pattern`, etc.
- `Date` must be today or in the future
- Message length is restricted to 200 characters

---

## 🧑‍💻 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/Taxi_Booking-_App.git
cd Taxi_Booking-_App
