package com.nik.socialmedia.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
    private final MainController mainController = new MainController();

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
        assertEquals("profile", mainController.profile());
    }

    @Test
    void editprofile_returnsEditprofile() {
        assertEquals("editprofile", mainController.editprofile());
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
