package com.codecrud.mappercodecrud.infrastructure.repository;

import com.codecrud.mappercodecrud.infrastructure.entities.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
