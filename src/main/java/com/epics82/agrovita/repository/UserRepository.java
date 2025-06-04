package com.epics82.agrovita.repository;

import com.epics82.agrovita.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username); //  Spring Data JPA will generate the query for you
}
