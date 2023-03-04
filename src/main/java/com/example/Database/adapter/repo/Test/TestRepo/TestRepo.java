package com.example.Database.adapter.repo.Test.TestRepo;

import com.example.Database.adapter.model.User;
import com.example.Database.adapter.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class TestRepo implements CommandLineRunner {
    private final UserRepository userRepository;

    public TestRepo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("khaled");
        user.setEmail("khaled@123");
        user.setCity("amman");
        user.setActive(true);
        user.setAge(40);

        userRepository.save(user);
    }
}
