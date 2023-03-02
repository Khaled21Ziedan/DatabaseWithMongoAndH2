package com.example.Database.adapter.repo.impl.User;

import com.example.Database.adapter.model.Address;
import com.example.Database.adapter.repo.impl.Account.AccountEntity;
import com.example.Database.adapter.repo.impl.Address.AddressEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String city;
    private int age ;
    private boolean active ;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<AccountEntity> accounts;
}
