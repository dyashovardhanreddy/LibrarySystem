# 📚 Library System

## Overview  
This is a **Spring Boot-based Library System API**. The application allows users to **retrieve books** from the library, while **authorized users (Admins)** can **add and delete books**.  

The project implements **JWT authentication**, ensuring secure access where users authenticate once and use their access token for subsequent requests.

---

## Features  
-  **Add a Book** – Admin users can add books to the library.  
-  **Delete a Book (by ID)** – Admin users can remove books from the system.  
-  **Retrieve All Books** – Any authenticated user can list all books.  
-  **Retrieve a Book (by ID)** – Any authenticated user can fetch book details.  
-  **JWT Authentication** – Users authenticate using **username/password** and receive an **access token** for secure API access.  
-  **Refresh Token Support** – Allows users to renew access tokens without re-authenticating.  

---

##  Technologies Used  
###  Backend  
- **Spring Boot** – Framework for building the API.  
- **Spring Security** – Handles authentication & authorization.  
- **Java 17** – Primary programming language.  

### Database  
- **Oracle Database** – Used for data persistence.  

---

## API Documentation  

| **Endpoint** | **Method** | **Access Level** | **Description** |
|-------------|-----------|----------------|----------------|
| `/library/books` | `GET` | Any Authenticated User | Fetch all books. |
| `/library/books/{id}` | `GET` | Any Authenticated User | Retrieve book details by ID. |
| `/library/addBook` | `POST` | Admin Only | Add a new book to the library. |
| `/library/deleteBook/{id}` | `DELETE` | Admin Only | Remove a book by ID. |
| `/library/login` | `POST` | Public | User authentication (returns JWT token). |
| `/library/refresh-token` | `POST` | Public | Refresh expired access tokens. |
| `/library/register` | `POST` | Public | Registers users. |

---

## Authentication & Security  
- **JWT-based authentication** – Users log in to obtain a token and include it in API requests:  
  ```http
  Authorization: Bearer <token>
