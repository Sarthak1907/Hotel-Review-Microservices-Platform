# Hotel-Review-Microservices-Platform
Developed a scalable and resilient microservices-based Hotel Review Platform.

## User Service: 
Designed and implemented a robust user service to manage user profiles, authentication, and authorization. Utilized Eureka for service discovery and Feign Client for inter-service communication. Integrated with MySQL database for persistent storage of user information.
## Rating Service: 
Developed a rating service to capture and store user ratings for specific hotels. Leveraged MongoDB for flexible data storage and efficient querying of rating data.
## Hotel Service: 
Built a hotel service to manage hotel information, including details, amenities, and location. Employed PostgreSQL database for structured data storage and efficient querying of hotel information.
## API Gateway: 
Implemented an API Gateway to route incoming requests to appropriate microservices, ensuring efficient routing and load balancing.
## Configuration Management: 
Utilized Spring Cloud Config to manage centralized configuration, enabling easy updates and deployment.
## Authentication and Authorization: 
Implemented robust JWT-based authentication and authorization mechanisms to safeguard sensitive user and hotel data.
## Tech Stack: 
Spring Boot, Spring Cloud, Eureka Server, Spring Security, JWT Authentication and Authorization, MySQL, PostgreSQL, MongoDB, Spring Cloud Config, Git, Feign Client, REST API, Spring Cloud Gateway

## How to RUN code

### Prerequisites:

1. IntelliJ IDEA: Ensure you have IntelliJ IDEA installed.
2. JDK: Make sure you have a compatible JDK (Java Development Kit) installed.
3. Project Source Code: Download or clone the project's source code repository.

### Steps to Run the Application:

1. Open the Project:
  - Open IntelliJ IDEA.
  - Click on Open and select the root directory of the project.

2. Build the Project:
  - Maven Project:
    - Ensure the Maven plugin is installed in IntelliJ IDEA.
    - Right-click on the project and select Maven -> Reimport.
    - Right-click again and select Maven -> Build Project.

3. Run the Application:
  - Run Configuration:
    - Go to Run -> Edit Configurations.
    - Click the + button and select Application.
    - Set the Main class to the main class of the application.
    - Configure any necessary VM options or environment variables.
  - Run the Application:
    - Click the Run button or press Shift+F10.

## Author

- [@Sarthak1907](https://github.com/Sarthak1907)
