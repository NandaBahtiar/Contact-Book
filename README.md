# Contact Book API

This is a simple RESTful API for a Contact Book application built with Spring Boot. This API allows you to perform basic CRUD (Create, Read, Update, Delete) operations on contacts. this project is a test from maybank
## About The Project

This project provides a backend service for managing a list of contacts. Each contact has a name, email, and phone number. The API is secured, requiring authentication for all endpoints.

### Features

* **Add a new contact:** Create and save a new contact.
* **View all contacts:** Retrieve a list of all saved contacts.
* **View a specific contact:** Fetch a single contact by its ID.
* **Update a contact:** Modify the details of an existing contact.
* **Delete a contact:** Remove a contact from the database.

### Built With

This project is built using the following technologies:

* [Spring Boot](https://spring.io/projects/spring-boot)
* [cite_start][Spring Web](https://docs.spring.io/spring-boot/3.5.0/reference/web/servlet.html) 
* [cite_start][Spring Data JPA](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html#data.sql.jpa-and-spring-data) 
* [cite_start][Spring Security](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-security.html) 
* [cite_start][Maven](https://maven.apache.org/guides/index.html) 
* [PostgreSQL](https://www.postgresql.org/)
* [Lombok](https://projectlombok.org/)

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

* JDK 17 or later
* Maven
* A running PostgreSQL instance

### Installation

1.  **Clone the repo**
    ```sh
    git clone https://github.com/NandaBahtiar/Contact-Book
    ```
2.  **Navigate to the project directory**
    ```sh
    cd Contact-Book
    ```
3.  **Configure the database**
    Open `src/main/resources/application.properties` and update the following properties to match your PostgreSQL setup:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/contac_book
    spring.datasource.username=your_postgres_username
    spring.datasource.password=your_postgres_password
    ```
4.  **Run the application**
    You can run the application using the Spring Boot Maven plugin:
    ```sh
    ./mvnw spring-boot:run
    ```
    The application will start on `http://localhost:8080`.

## API Endpoints

The API provides the following endpoints, all under the base path `/contact`.

### Add Contact

* **Endpoint:** `POST /contact`
* [cite_start]**Description:** Adds a new contact to the database. 
* **Request Body:**
    ```json
    {
      "name": "John Doe",
      "email": "john.doe@example.com",
      "phone": "1234567890"
    }
    ```
* **Response:**
    [cite_start]Returns a common response object with the status code, a success message, and the newly created contact's details. 

### Get All Contacts

* **Endpoint:** `GET /contact`
* [cite_start]**Description:** Retrieves a list of all contacts. 
* **Response:**
    [cite_start]Returns a common response object with the status code, a success message, and a list of all contacts. 

### Get Contact by ID

* **Endpoint:** `GET /contact/{id}`
* **Description:** Retrieves a single contact by its unique ID.
* **Response:**
    Returns a common response object with the status code, a success message, and the requested contact's details. 

### Update Contact

* **Endpoint:** `PUT /contact/{id}`
* [cite_start]**Description:** Updates the details of an existing contact. 
* **Request Body:**
    ```json
    {
      "name": "Jane Doe",
      "email": "jane.doe@example.com",
      "phone": "0987654321"
    }
    ```
* **Response:**
    [cite_start]Returns a common response object with the status code, a success message, and the updated contact's details. 

### Delete Contact

* **Endpoint:** `DELETE /contact/{id}`
* [cite_start]**Description:** Deletes a contact by its ID. 
* **Response:**
    [cite_start]Returns a common response object with the status code and a success message. 

## Security

[cite_start]The application is configured with Spring Security.  [cite_start]By default, all requests to any endpoint must be authenticated.  [cite_start]The security configuration disables CSRF protection to allow for easier testing with tools like Postman. 

## Project Structure

[cite_start]The project follows a standard Maven project structure.
