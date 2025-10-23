package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.response.ResponseStatus;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public User signup(String name, String email, String phoneNumber, String password) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if(existingUser.isPresent()) {
            // User already exists
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(encoder.encode(password));
        return userRepository.save(user);
    }

    public ResponseStatus login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()) {
            return ResponseStatus.FAILURE;
        }

        User user = optionalUser.get();
        if(encoder.matches(password, user.getPassword())) {
            return ResponseStatus.SUCCESS;
        } else {
            return ResponseStatus.FAILURE;
        }
    }
}
