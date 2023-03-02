package com.example.Database.adapter.model;

import com.example.Database.adapter.repo.impl.Account.AccountEntity;
import com.example.Database.adapter.repo.impl.Address.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String city;
    private int age ;
    private boolean active ;
    private AddressEntity address;
    private List<AccountEntity> accountEntities;

}
