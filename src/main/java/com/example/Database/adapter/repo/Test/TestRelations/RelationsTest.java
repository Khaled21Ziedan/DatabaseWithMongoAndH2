package com.example.Database.adapter.repo.Test.TestRelations;

import com.example.Database.adapter.repo.UserRepository;
import com.example.Database.adapter.model.User;
import com.example.Database.adapter.repo.mysql.impl.Account.AccountEntity;
import com.example.Database.adapter.repo.mysql.impl.Account.AccountRepository;
import com.example.Database.adapter.repo.mysql.impl.Address.AddressEntity;
import com.example.Database.adapter.repo.mysql.impl.Course.CourseEntity;
import com.example.Database.adapter.repo.mysql.impl.Course.CourseRepository;
import com.example.Database.adapter.repo.mysql.impl.User.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class RelationsTest implements CommandLineRunner {
    private final CourseRepository courseRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public RelationsTest(CourseRepository courseRepository, AccountRepository accountRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();

        user1.setName("khaled");
        user1.setAge(34);
        user1.setActive(true);
        user1.setEmail("khaled@12345");
        user1.setCity("amman");

        User user2 = new User();

        user2.setName("khaled");
        user2.setAge(34);
        user2.setActive(true);
        user2.setEmail("khaled@12345");
        user2.setCity("irbid");

        UserEntity userEntity1 = toUserEntity(user1);
        UserEntity userEntity2 = toUserEntity(user2);

        CourseEntity course1 = new CourseEntity();
        course1.setName("math");
        course1.setUserEntities(Arrays.asList(userEntity1,userEntity2));

        CourseEntity course2 = new CourseEntity();
        course2.setName("physics");
        course2.setUserEntities(Arrays.asList(userEntity1,userEntity2));

        userEntity1.setCourses(Arrays.asList(course1,course2));
        userEntity2.setCourses(Arrays.asList(course1,course2));

        userEntity1.setAddress(AddressEntity.builder().location("amman").build());
        userEntity2.setAddress(AddressEntity.builder().location("irbid").build());

        AccountEntity acc1 = new AccountEntity();
        acc1.setIban("45");
        acc1.setUserEntity(userEntity1);

        AccountEntity acc2 = new AccountEntity();
        acc2.setIban("34");
        acc2.setUserEntity(userEntity1);

        AccountEntity acc3 = new AccountEntity();
        acc3.setIban("72");
        acc3.setUserEntity(userEntity2);

        AccountEntity acc4 = new AccountEntity();
        acc4.setIban("91");
        acc4.setUserEntity(userEntity2);

        userEntity1.setAccounts(Arrays.asList(acc1,acc2));
        userEntity2.setAccounts(Arrays.asList(acc3,acc4));

        courseRepository.save(course1);
        courseRepository.save(course2);

        accountRepository.save(Arrays.asList(acc1,acc2));
        accountRepository.save(Arrays.asList(acc3,acc4));

    }
    private UserEntity toUserEntity(User user) {
        return UserEntity
                .builder()
                .active(user.isActive())
                .age(user.getAge())
                .city(user.getCity())
                .email(user.getEmail())
                .name(user.getName())
                .id(user.getId())
                .build();
    }
}
