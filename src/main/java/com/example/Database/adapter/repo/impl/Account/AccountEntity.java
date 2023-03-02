package com.example.Database.adapter.repo.impl.Account;

import com.example.Database.adapter.repo.impl.User.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountEntity {
    @Id
    @GeneratedValue
    private Long id ;
    private String iban;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
