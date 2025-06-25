# Social Media Spring Boot Project

This is a simple social media web application built with Spring Boot. It demonstrates basic user flows such as login, signup, profile management, messaging, and more, using Spring Boot and Thymeleaf.

## Features
- User authentication (login, signup, password management)
- Profile and friend management
- Messaging system
- Notifications
- Search functionality
- Settings and privacy pages
- Error pages (404, 500, etc.)

## Technologies Used
- Java 17
- Spring Boot 3.5.3
- Spring Web
- Spring Security (OAuth2 Client)
- Thymeleaf
- Maven

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven

### Running the Application
1. Clone the repository:
   ```sh
   git clone https://github.com/nikalomoiris/socialmedia.git
   cd socialmedia
   ```
2. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
3. Open your browser and go to [http://localhost:8080](http://localhost:8080)

### Project Structure
- `src/main/java/com/nik/socialmedia/` - Java source code
- `src/main/resources/templates/` - Thymeleaf HTML templates
- `src/main/resources/application.properties` - Application configuration

## Customization
You can add or modify HTML templates in the `src/main/resources/templates/` directory to change the UI.

## License
This project is for educational/demo purposes.
