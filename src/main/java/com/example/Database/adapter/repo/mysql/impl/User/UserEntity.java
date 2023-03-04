package com.example.Database.adapter.repo.mysql.impl.User;

import com.example.Database.adapter.repo.mysql.impl.Account.AccountEntity;
import com.example.Database.adapter.repo.mysql.impl.Address.AddressEntity;
import com.example.Database.adapter.repo.mysql.impl.Course.CourseEntity;
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
    private String email;
    private String city;
    private int age ;
    private boolean active ;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(mappedBy = "userEntity",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<AccountEntity> accounts;
    @ManyToMany(mappedBy = "userEntities",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<CourseEntity> Courses;
}
