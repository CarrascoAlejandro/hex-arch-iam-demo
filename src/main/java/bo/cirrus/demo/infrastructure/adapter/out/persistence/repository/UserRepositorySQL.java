package bo.cirrus.demo.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.UserEntity;

public interface UserRepositorySQL extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
}
