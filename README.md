# Student Management System

A web-based Student Management System built using **Java, Spring Boot, Spring MVC, Spring Data JPA, Thymeleaf, and MySQL**.

This project demonstrates how to build a complete CRUD-based web application using a layered architecture.

## Features

- Add new students
- View all students
- Update student details
- Delete students
- Search students by name
- Filter students by branch
- Filter students by academic year
- Pagination for student records
- MySQL database integration
- Server-side rendering using Thymeleaf

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Hibernate**
- **Thymeleaf**
- **HTML5**
- **CSS3**
- **MySQL**
- **Maven**
- **Git & GitHub**

## Architecture

The application follows a layered architecture:

```text
Browser
   |
   v
Controller
   |
   v
Service
   |
   v
Repository
   |
   v
MySQL

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── student/
│   │           ├── model/
│   │           │   └── Student.java
│   │           ├── repository/
│   │           │   └── StudentRepository.java
│   │           ├── service/
│   │           │   ├── StudentService.java
│   │           │   └── StudentServiceImpl.java
│   │           └── rest/
│   │               └── StudentController.java
│   │
│   └── resources/
│       ├── templates/
│       │   ├── home.html
│       │   ├── student-form.html
│       │   ├── student-list.html
│       │   └── update-student.html
│       │
│       └── application.properties
│
└── test/

```
## Learning Outcomes

This project helped me gain practical experience with:

- Building web applications using Spring Boot
- Implementing MVC architecture
- Dependency Injection and layered architecture
- CRUD operations using Spring Data JPA
- Database interaction using Hibernate and MySQL
- Custom repository queries
- Server-side rendering with Thymeleaf
- Searching, filtering, and pagination
- Managing a Maven-based project
- Using Git and GitHub for version control

## Future Improvements

- Spring Security authentication and authorization
- Role-based access control
- REST API integration
- Advanced filtering and sorting
- Improved validation and exception handling
- Unit and integration testing
- Cloud deployment

## Author

**Jatin Chugh**
