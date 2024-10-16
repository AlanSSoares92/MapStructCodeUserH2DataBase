package com.codecrud.mappercodecrud.infrastructure.repository;

import com.codecrud.mappercodecrud.infrastructure.entities.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UserEntity, Long> {

  public String findById(UserEntity id);

    void deleteById(Long id);
}
