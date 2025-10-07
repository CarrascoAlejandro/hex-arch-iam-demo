package bo.cirrus.demo.infrastructure.adapter.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.AssignedPrivilegeEntity;

public interface AssignedPrivilegeRepositorySQL extends JpaRepository<AssignedPrivilegeEntity, Long> {
    
    @Modifying
    @Query("DELETE FROM AssignedPrivilegeEntity ap WHERE ap.user.id = :userId AND ap.privilege.id = :privilegeId")
    void deleteByUserIdAndPrivilegeId(@Param("userId") Long userId, @Param("privilegeId") Long privilegeId);
    
    @Query("SELECT ap FROM AssignedPrivilegeEntity ap WHERE ap.user.id = :userId")
    List<AssignedPrivilegeEntity> findByUserId(@Param("userId") Long userId);
    
    @Query("SELECT COUNT(ap) > 0 FROM AssignedPrivilegeEntity ap WHERE ap.user.id = :userId AND ap.privilege.id = :privilegeId")
    boolean existsByUserIdAndPrivilegeId(@Param("userId") Long userId, @Param("privilegeId") Long privilegeId);
}