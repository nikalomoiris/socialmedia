package com.nik.socialmedia.Service;

import com.nik.socialmedia.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomOAuth2UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private OAuth2UserRequest userRequest;
    @Mock
    private OAuth2User oAuth2User;
    @InjectMocks
    private CustomOAuth2UserService customOAuth2UserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customOAuth2UserService = new CustomOAuth2UserService(userRepository);
    }

    @Test
    void loadUser_existingUser_returnsOAuth2User() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("email", "test@example.com");
        when(oAuth2User.getAttributes()).thenReturn(attributes);
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(new User()));
        CustomOAuth2UserService service = spy(customOAuth2UserService);
        doReturn(oAuth2User).when(service).loadUser(userRequest);
        OAuth2User result = service.loadUser(userRequest);
        assertNotNull(result);
    }

    @Test
    void loadUser_newUser_savesAndReturnsOAuth2User() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("email", "new@example.com");
        when(oAuth2User.getAttributes()).thenReturn(attributes);
        when(userRepository.findByEmail("new@example.com")).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(new User());
        CustomOAuth2UserService service = spy(customOAuth2UserService);
        doReturn(oAuth2User).when(service).loadUser(userRequest);
        OAuth2User result = service.loadUser(userRequest);
        assertNotNull(result);
    }
}
