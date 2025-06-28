// controller class for handling all the requests
package com.nik.socialmedia.controller;

import com.nik.socialmedia.Model.User;
import com.nik.socialmedia.Service.FileStorageService;
import com.nik.socialmedia.Service.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
public class MainController {

    private final UserRepository userRepository;
    private final FileStorageService fileStorageService;

    public MainController(UserRepository userRepository, FileStorageService fileStorageService) {
        this.userRepository = userRepository;
        this.fileStorageService = fileStorageService;
    }
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        userRepository.findByEmail(email).ifPresent(user -> model.addAttribute("user", user));
        return "profile";
    }
    
    @GetMapping("/editprofile")
    public String editprofile(Model model, @AuthenticationPrincipal OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        userRepository.findByEmail(email).ifPresent(user -> model.addAttribute("user", user));
        return "editprofile";
    }

    @PostMapping("/editprofile")
    public String editprofile(@AuthenticationPrincipal OAuth2User oAuth2User, User user, @RequestParam("profilePicture") MultipartFile profilePicture) {
        String email = oAuth2User.getAttribute("email");
        userRepository.findByEmail(email).ifPresent(existingUser -> {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            if (!profilePicture.isEmpty()) {
                String profilePictureUrl = fileStorageService.storeFile(profilePicture);
                existingUser.setProfilePictureUrl(profilePictureUrl);
            }
            userRepository.save(existingUser);
        });
        return "redirect:/profile";
    }
    
    @GetMapping("/changepassword")
    public String changepassword() {
        return "changepassword";
    }
    
    @GetMapping("/forgotpassword")
    public String forgotpassword() {
        return "forgotpassword";
    }
    
    @GetMapping("/resetpassword")
    public String resetpassword() {
        return "resetpassword";
    }
    
    @GetMapping("/search")
    public String search() {
        return "search";
    }
    
    @GetMapping("/searchresults")
    public String searchresults() {
        return "searchresults";
    }
    
    @GetMapping("/friends")
    public String friends() {
        return "friends";
    }
    
    @GetMapping("/friendprofile")
    public String friendprofile() {
        return "friendprofile";
    }
    
    @GetMapping("/messages")
    public String messages() {
        return "messages";
    }
    
    @GetMapping("/message")
    public String message() {
        return "message";
    }
    
    @GetMapping("/notifications")
    public String notifications() {
        return "notifications";
    }
    
    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }
    
    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
    
    @GetMapping("/404")
    public String error404() {
        return "404";
    }
    
    @GetMapping("/500")
    public String error500() {
        return "500";
    }
    
    @GetMapping("/503")
    public String error503() {
        return "503";
    }
    
    @GetMapping("/504")
    public String error504() {
        return "504";
    }
    
    @GetMapping("/505")
    public String error505() {
        return "505";
    }
}