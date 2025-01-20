package com.nik.socialmedia.Service;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nik.socialmedia.Model.User;

@Repository
public class UserRepository {

    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    public User save(User user) {
        return null;
    }

}
