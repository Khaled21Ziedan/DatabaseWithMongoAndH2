package com.example.Database.service;

import com.example.Database.adapter.repo.UserRepository;
import com.example.Database.adapter.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> loadUserById(Long id) {
        return userRepository.getById(id);
    }

    public Page<User> loadAll(Pageable pageable) {
        return userRepository.loadUser(pageable);
    }
    public Page<User> loadAllByName(String name , Pageable pageable) {
        return userRepository.searchUserByName(name,pageable);
    }

    public void remove(Long id) {
        userRepository.removeUser(id);
    }
}
