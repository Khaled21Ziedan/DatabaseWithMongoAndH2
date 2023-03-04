package com.example.Database.adapter.repo.mysql.impl.User;

import com.example.Database.adapter.model.Address;
import com.example.Database.adapter.repo.UserRepository;
import com.example.Database.adapter.model.User;
import com.example.Database.adapter.repo.mysql.impl.Address.AddressEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Profile("User-JPA")
public class UserRepositoryJPAimpl implements UserRepository {
    private final UserRepositoryJPASpringImpl userRepositoryJPASpring;

    public UserRepositoryJPAimpl(UserRepositoryJPASpringImpl userRepositoryJPASpring) {
        this.userRepositoryJPASpring = userRepositoryJPASpring;
    }

    @Override
    public long save(User user) {
        UserEntity userEntity = toUserEntity(user);
        UserEntity savedUser = userRepositoryJPASpring.save(userEntity);
        return savedUser.getId();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepositoryJPASpring.findById(id).map(toModel());
    }

    @Override
    public List<User> findAll() {
        return userRepositoryJPASpring.findAll().stream().map(toModel()).collect(Collectors.toList());
    }

    @Override
    public Page<User> loadUser(Pageable pageable) {
        return userRepositoryJPASpring.findAll(pageable).map(toModel());
    }

    @Override
    public Page<User> searchUserByName(String name, Pageable pageable) {
        return userRepositoryJPASpring
                .findByName(name, pageable)
                .map(toModel());
    }

    @Override
    public void removeUser(Long id) {
         userRepositoryJPASpring.deleteById(id);
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
                .address(toAddressEntity(user.getAddress()))
                .build();
    }

    private Function<UserEntity, User> toModel() {
        return userEntity -> User.builder()
                .age(userEntity.getAge())
                .active(userEntity.isActive())
                .city(userEntity.getCity())
                .email(userEntity.getEmail())
                .id(userEntity.getId())
                .name(userEntity.getName())
                .build();
    }
    private AddressEntity toAddressEntity(Address address){
        return AddressEntity.builder().location(address.getLocation()).build();
    }
}
