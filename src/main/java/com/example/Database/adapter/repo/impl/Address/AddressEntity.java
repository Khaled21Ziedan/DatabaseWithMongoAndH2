package com.example.Database.adapter.repo.impl.Address;

import com.example.Database.adapter.model.User;
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
public class AddressEntity {

    @Id
    @GeneratedValue
    private long id;
    private String location;

}