package com.example.Database.adapter.model;

import com.example.Database.adapter.repo.mysql.impl.User.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private long id ;
    private String iban;
    private User userEntity;
}
