package com.nik.socialmedia.controller;

import com.nik.socialmedia.Model.User;
import com.nik.socialmedia.Service.FileStorageService;
import com.nik.socialmedia.Service.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MainControllerTest {

    private MainController mainController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private FileStorageService fileStorageService;

    @Mock
    private Model model;

    @Mock
    private OAuth2User oAuth2User;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mainController = new MainController(userRepository, fileStorageService);
    }

    @Test
    void home_returnsIndex() {
        assertEquals("index", mainController.home());
    }

    @Test
    void login_returnsLogin() {
        assertEquals("login", mainController.login());
    }

    @Test
    void profile_returnsProfile() {
        when(oAuth2User.getAttribute("email")).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(new User()));

        assertEquals("profile", mainController.profile(model, oAuth2User));
    }

    @Test
    void editprofile_returnsEditprofile() {
        when(oAuth2User.getAttribute("email")).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(new User()));

        assertEquals("editprofile", mainController.editprofile(model, oAuth2User));
    }

    @Test
    void editprofile_post_redirectsToProfile() {
        when(oAuth2User.getAttribute("email")).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(new User()));

        assertEquals("redirect:/profile", mainController.editprofile(oAuth2User, new User(), mock(MultipartFile.class)));
    }

    @Test
    void changepassword_returnsChangepassword() {
        assertEquals("changepassword", mainController.changepassword());
    }

    @Test
    void forgotpassword_returnsForgotpassword() {
        assertEquals("forgotpassword", mainController.forgotpassword());
    }

    @Test
    void resetpassword_returnsResetpassword() {
        assertEquals("resetpassword", mainController.resetpassword());
    }

    @Test
    void search_returnsSearch() {
        assertEquals("search", mainController.search());
    }

    @Test
    void searchresults_returnsSearchresults() {
        assertEquals("searchresults", mainController.searchresults());
    }

    @Test
    void friends_returnsFriends() {
        assertEquals("friends", mainController.friends());
    }
}
