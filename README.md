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
1. Clone the repository: git clone https://github.com/ishrivasayush/E-Commerce-Application.git
2. Import the project into STS:
  - Click File > Import...
  - Select Maven > Existing Maven Projects and click Next
  - Browse to the project directory and click Finish
3. Update the values in application.properties with your MySQL database connection details.
4. Run the app: Right-click the project in the Package Explorer and click Run As > Spring Boot App.

# API documentation
- API documentation is available via Swagger UI at http://localhost:8081/swagger-ui/index.html

# ER-Diagram

![Screenshot (1034)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/37feec02-9c87-4701-ab15-5915f43f496d)

# Swagger-ui
![Screenshot (1025)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/e055603e-4232-41d2-8efe-72bc186fae97)

# API Controllers
![Screenshot (1026)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/ad7ac662-2020-4f6c-8520-b6f160e1a445)

![Screenshot (1027)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/87bce782-e590-4512-94d1-dd51a824b1f4)

![Screenshot (1028)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/11f148a9-a342-44b5-827a-969a566cf81f)

![Screenshot (1029)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/4a55c099-9f6f-477a-afd4-f1340da9bf78)

![Screenshot (1030)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/6e9c1499-0a1e-4923-944f-974da1903243)

![Screenshot (1031)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/7e0a5ad8-6da6-4865-823a-6a69da453203)

![Screenshot (1032)](https://github.com/ishrivasayush/E-Commerce-Application/assets/103355440/99fd7760-e8d5-4bc4-84c5-7d71684a25ea)


## ✏️Design - Back-end
### Back-end Technology Stack
- **Java** served as the **back-end programming language** for the web application, while the **Spring Boot framework** was employed to **facilitate its development and operation**.
- **Spring Boot** was utilised to **create user models**, which were subsequently employed to **store employee information in the database**. The user models were established using the **Jakarta Persistence import** and **annotations**, including **@Entity, @Id, and @GeneratedValue**. This approach **facilitated the maintenance of the REST API**, making it more manageable and easier to maintain in the long run.
- **MySQL Workbench and DataGrip** were employed to **store employee information**. The **back-end**, developed with **Spring Boot**, was **configured to connect with the database**, while the **front-end**, built with **React**, was responsible for **retrieving and displaying** this information.
- **Spring Boot** was additionally utilised to **create custom exceptions**, specifically designed for **handling scenarios where the user ID was not found or encountered other exceptional conditions**.

## 6. Original Creator:

Author: Ayush Shrivastava
 
Github Project Name: E-Commerce Backend Application


Date: 4 Feb, 2023









