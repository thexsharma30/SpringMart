# E-Commerce-Application

- The E-Commerce Application is built using Java and Spring Boot, with security, scalability, and ease of maintenance. The backend uses Spring Data JPA to interact with a MySQL database, making it easy to manage and store important entities such as users, products, categories and more. User authentication is handled by JWT, providing secure and reliable means of REST APIs.

- The APIs are well-documented and easily accessible through Swagger UI, making it simple for developers to test and understand the various endpoints. Overall, this project provides secure Rest APIs to create a scalable platform for businesses to sell their products to customers.

# Features
## Admin:-
- Login
- Users
- Address
- Categories
- Products

## User:-
- Registration & Login
- Fetch categories and products based on category
- Adding & deleting products to cart
- Managing cart and products quantity

# Security
- The API is secured using JSON Web Tokens (JWT). To access the API, you will need to obtain a JWT by authenticating with the /login endpoint. The JWT should then be passed in the Authorize option available in the Swagger-ui.

  ### Example:
  - Authorization: <your_jwt>

# Technologies:
- Java 17 or above
- Spring Boot 3.0
- Maven
- MySQL
- Spring Data JPA
- Spring Security
- JSON Web Tokens (JWT)
- Postman
- Swagger UI

# Running the app
1. Clone the repository: git clone https://github.com/thexsharma30/SpringMart.git
2. Import the project into STS:
  - Click File > Import...
  - Select Maven > Existing Maven Projects and click Next
  - Browse to the project directory and click Finish
3. Update the values in application.properties with your MySQL database connection details.
4. Run the app: Right-click the project in the Package Explorer and click Run As > Spring Boot App.

# API documentation
- API documentation is available via Swagger UI at http://localhost:8081/swagger-ui/index.html

# ER-Diagram
![Screenshot 2024-08-27 201815](https://github.com/user-attachments/assets/2e3bc3e9-989e-4497-a2ae-4e155341802a)

# Swagger-ui
![image](https://github.com/user-attachments/assets/302aa352-5490-44d9-bf14-7fcc2e67b4b1)

# API Controllers
![image](https://github.com/user-attachments/assets/e9dcf394-396e-4c34-9be1-bce711303307)

![image](https://github.com/user-attachments/assets/0f0f36be-da6d-4c12-a5c1-ea58332aa2b1)

![image](https://github.com/user-attachments/assets/2e92fd08-0032-4a68-bea9-f0f3ae96569f)

![image](https://github.com/user-attachments/assets/5f57885c-6fec-4121-a501-a56ee321dcbe)

![image](https://github.com/user-attachments/assets/35cb4734-a6b3-49ec-a526-9f72469b8c47)

![image](https://github.com/user-attachments/assets/41ab213b-893e-47a8-a66f-644df8263f1d)

![image](https://github.com/user-attachments/assets/821ea705-f282-4196-b91d-55c409b6ff50)


## ✏️Design - Back-end
### Back-end Technology Stack
- **Java** served as the **back-end programming language** for the web application, while the **Spring Boot framework** was employed to **facilitate its development and operation**.
- **Spring Boot** was utilised to **create user models**, which were subsequently employed to **store employee information in the database**. The user models were established using the **Jakarta Persistence import** and **annotations**, including **@Entity, @Id, and @GeneratedValue**. This approach **facilitated the maintenance of the REST API**, making it more manageable and easier to maintain in the long run.
- **MySQL Workbench and DataGrip** were employed to **store employee information**. The **back-end**, developed with **Spring Boot**, was **configured to connect with the database**, while the **front-end**, built with **React**, was responsible for **retrieving and displaying** this information.
- **Spring Boot** was additionally utilised to **create custom exceptions**, specifically designed for **handling scenarios where the user ID was not found or encountered other exceptional conditions**.

## 6. Original Creator:

Author: Amar Sharma
 
Github Project Name: E-Commerce Backend Application (SpringMart)


Date: 4 July, 2024









