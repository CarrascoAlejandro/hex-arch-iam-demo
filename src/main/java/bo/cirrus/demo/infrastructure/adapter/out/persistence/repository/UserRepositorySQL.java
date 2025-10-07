package bo.cirrus.demo.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.UserEntity;

public interface UserRepositorySQL extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    
    @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.assignedPrivileges ap LEFT JOIN FETCH ap.privilege WHERE u.id = :id")
    Optional<UserEntity> findByIdWithPrivileges(@Param("id") Long id);
    
    @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.assignedPrivileges ap LEFT JOIN FETCH ap.privilege WHERE u.username = :username")
    Optional<UserEntity> findByUsernameWithPrivileges(@Param("username") String username);
    
    @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.assignedPrivileges ap LEFT JOIN FETCH ap.privilege WHERE u.email = :email")
    Optional<UserEntity> findByEmailWithPrivileges(@Param("email") String email);
}
