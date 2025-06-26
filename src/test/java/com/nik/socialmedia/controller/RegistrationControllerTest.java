package com.nik.socialmedia.controller;

import com.nik.socialmedia.Model.User;
import com.nik.socialmedia.Service.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RegistrationControllerTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private Model model;
    @InjectMocks
    private RegistrationController registrationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registrationController = new RegistrationController(userRepository, passwordEncoder);
    }

    @Test
    void showSignupForm_shouldAddUserToModelAndReturnSignup() {
        String view = registrationController.showSignupForm(model);
        verify(model).addAttribute(eq("user"), any(User.class));
        assertEquals("signup", view);
    }

    @Test
    void registerUser_shouldEncodePasswordAndSaveUserAndRedirect() {
        User user = new User();
        user.setPassword("plain");
        when(passwordEncoder.encode("plain")).thenReturn("encoded");
        String view = registrationController.registerUser(user, model);
        assertEquals("encoded", user.getPassword());
        verify(userRepository).save(user);
        assertEquals("redirect:/login", view);
    }
}
