package com.nik.socialmedia.Service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.nik.socialmedia.Model.User;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    
    private final UserRepository userRepository;
    
    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        
        Map<String, Object> attributes = oAuth2User.getAttributes();
        
        String email = (String) attributes.get("email");
        
        Optional<User> userOptional = userRepository.findByEmail(email);
        
        User user;
        
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            user = new User();
            user.setEmail(email);
        }

        String name = (String) attributes.get("name");
        if (name != null) {
            String[] nameParts = name.split(" ");
            if (nameParts.length > 0) {
                user.setFirstName(nameParts[0]);
            }
            if (nameParts.length > 1) {
                user.setLastName(nameParts[1]);
            }
        }

        String pictureUrl = (String) attributes.get("picture");
        if (pictureUrl == null) {
            pictureUrl = (String) attributes.get("avatar_url");
        }
        if (pictureUrl == null) {
            pictureUrl = (String) attributes.get("picture_url");
        }
        user.setProfilePictureUrl(pictureUrl);
        user = userRepository.save(user);
        
        return oAuth2User;
    }
    
}
