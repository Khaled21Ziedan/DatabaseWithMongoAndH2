package com.example.Database.adapter.repo.impl.User;

import com.example.Database.adapter.repo.impl.User.UserRepositoryJPASpringImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRepo implements CommandLineRunner {
    private final UserRepositoryJPASpringImpl userRepositoryJPASpring;

    public TestRepo(UserRepositoryJPASpringImpl userRepositoryJPASpring) {
        this.userRepositoryJPASpring = userRepositoryJPASpring;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("search by email ");
        System.out.println(userRepositoryJPASpring.searchByEmail("a@a"));
    }
}
