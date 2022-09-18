package com.techelevator.service;

import com.techelevator.dao.UserRepository;
import com.techelevator.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepo;

    public User findByUserId(long userId) {
        return userRepo.findById(userId);
    }

    public User findByUsername(String username) throws UsernameNotFoundException{
        try {
            return userRepo.findByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User '" + username + "' was not found.");
        }
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    /* We recreated the create user and create account methods using JPA repository's save */

    public boolean create(String username, String password, String role) {
        User newUser = new User();
        String password_hash = new BCryptPasswordEncoder().encode(password);
        newUser.setUsername(username);
        newUser.setPassword(password_hash);
        newUser.setRole(role);
        newUser.setActivated(true);
        try {
    /* Using saveAndFlush allowed us to get updated information more immediately,
    without pulling from the repository again */
            userRepo.saveAndFlush(newUser);
        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
            return false;
        }
        return true;
    }
}
