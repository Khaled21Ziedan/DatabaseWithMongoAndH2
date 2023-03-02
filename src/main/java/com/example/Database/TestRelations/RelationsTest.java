package com.example.Database.TestRelations;

import com.example.Database.adapter.model.Account;
import com.example.Database.adapter.model.Address;
import com.example.Database.adapter.repo.UserRepository;
import com.example.Database.adapter.model.User;
import com.example.Database.adapter.repo.impl.Account.AccountEntity;
import com.example.Database.adapter.repo.impl.Address.AddressEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class RelationsTest implements CommandLineRunner {
    private final UserRepository userRepository;

    public RelationsTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<AccountEntity> accountEntities = new ArrayList<>();
        accountEntities.add(AccountEntity.builder().iban("553666").build());
        accountEntities.add(AccountEntity.builder().iban("454434").build());

        AddressEntity addressEntity = AddressEntity.builder().location("amman").build();

        User user = User.builder()
                .name("ahmad")
                .age(20).email("a@a")
                .active(true)
                .city("Amman")
                .build();
        user.setAccountEntities(accountEntities);
        user.setAddress(addressEntity);
        long savedUserId1 = userRepository.save(user);
        System.out.println(userRepository.getById(savedUserId1)+"get by id\n");
    }
}
