package com.example.Database.adapter.repo.mysql.impl.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPASpringImpl extends JpaRepository<UserEntity,Long> {
    Page<UserEntity> findByName(String name , Pageable pageable);
    @Query("select u from UserEntity u where u.email = ?1")
    Optional<UserEntity> searchByEmail(String email);
}
