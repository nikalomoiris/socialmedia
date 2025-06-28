# Social Media Spring Boot Project

This is a simple social media web application built with Spring Boot. It demonstrates basic user flows such as login, signup, profile management, messaging, and more, using Spring Boot and Thymeleaf.

## Features
- User authentication (login, signup, password management)
- User profile with profile picture support
- Edit profile page for updating user information and profile picture
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
- `src/main/java/com/nik/socialmedia/` - Java source code (includes `FileStorageService`)
- `src/main/resources/templates/` - Thymeleaf HTML templates
- `src/main/resources/application.properties` - Application configuration
- `uploads/` - Directory for uploaded profile pictures

## Customization
You can add or modify HTML templates in the `src/main/resources/templates/` directory to change the UI.

## License
This project is for educational/demo purposes.
