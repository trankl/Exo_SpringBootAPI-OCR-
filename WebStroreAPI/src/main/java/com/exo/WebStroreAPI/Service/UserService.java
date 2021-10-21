package com.exo.WebStroreAPI.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exo.WebStroreAPI.Model.User;
import com.exo.WebStroreAPI.Repository.UserRepository;

import lombok.Data;


@Data
@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final int id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final int id) {
    	userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
