package bo.cirrus.demo.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.PrivilegeEntity;

public interface PrivilegeRepositorySQL extends JpaRepository<PrivilegeEntity, Long> {
    boolean existsByName(String name);
    boolean existsByResourceKey(String resourceKey);
    PrivilegeEntity findByNameOrResourceKey(String name, String resourceKey);
    
}
