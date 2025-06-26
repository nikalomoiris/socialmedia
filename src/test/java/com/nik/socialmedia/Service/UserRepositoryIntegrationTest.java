package com.nik.socialmedia.Service;

import com.nik.socialmedia.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryIntegrationTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void saveAndFindByEmail_shouldPersistAndRetrieveUser() {
        User user = new User();
        user.setEmail("integration@example.com");
        user.setPassword("password");
        user.setUsername("integrationuser");
        userRepository.save(user);

        Optional<User> found = userRepository.findByEmail("integration@example.com");
        assertTrue(found.isPresent());
        assertEquals("integrationuser", found.get().getUsername());
    }
}
