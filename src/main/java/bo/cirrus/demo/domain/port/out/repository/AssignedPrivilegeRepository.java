package bo.cirrus.demo.domain.port.out.repository;

import java.util.List;

import bo.cirrus.demo.domain.model.AssignedPrivilege;

public interface AssignedPrivilegeRepository {
    
    AssignedPrivilege save(AssignedPrivilege assignedPrivilege);
    AssignedPrivilege saveWithUserId(AssignedPrivilege assignedPrivilege, Long userId);
    void deleteByUserIdAndPrivilegeId(Long userId, Long privilegeId);
    List<AssignedPrivilege> findByUserId(Long userId);
    boolean existsByUserIdAndPrivilegeId(Long userId, Long privilegeId);
}