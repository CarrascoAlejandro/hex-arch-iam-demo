package bo.cirrus.demo.infrastructure.adapter.out.persistence.adapter;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bo.cirrus.demo.domain.model.AssignedPrivilege;
import bo.cirrus.demo.domain.port.out.repository.AssignedPrivilegeRepository;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.AssignedPrivilegeEntity;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.UserEntity;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper.AssignedPrivilegeJpaMapper;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.repository.AssignedPrivilegeRepositorySQL;

@Component
public class AssignedPrivilegeJpaAdapter implements AssignedPrivilegeRepository {

    private final AssignedPrivilegeRepositorySQL assignedPrivilegeRepositorySQL;
    private final AssignedPrivilegeJpaMapper assignedPrivilegeJpaMapper;

    public AssignedPrivilegeJpaAdapter(
        AssignedPrivilegeRepositorySQL assignedPrivilegeRepositorySQL,
        AssignedPrivilegeJpaMapper assignedPrivilegeJpaMapper
    ) {
        this.assignedPrivilegeRepositorySQL = assignedPrivilegeRepositorySQL;
        this.assignedPrivilegeJpaMapper = assignedPrivilegeJpaMapper;
    }

    @Override
    public AssignedPrivilege save(AssignedPrivilege assignedPrivilege) {
        AssignedPrivilegeEntity entity = assignedPrivilegeJpaMapper.domainToEntity(assignedPrivilege);
        AssignedPrivilegeEntity savedEntity = assignedPrivilegeRepositorySQL.save(entity);
        return assignedPrivilegeJpaMapper.entityToDomain(savedEntity);
    }
    
    @Override
    public AssignedPrivilege saveWithUserId(AssignedPrivilege assignedPrivilege, Long userId) {
        AssignedPrivilegeEntity entity = assignedPrivilegeJpaMapper.domainToEntity(assignedPrivilege);
        
        // Set the user reference
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        entity.setUser(userEntity);
        
        AssignedPrivilegeEntity savedEntity = assignedPrivilegeRepositorySQL.save(entity);
        return assignedPrivilegeJpaMapper.entityToDomain(savedEntity);
    }

    @Override
    @Transactional
    public void deleteByUserIdAndPrivilegeId(Long userId, Long privilegeId) {
        assignedPrivilegeRepositorySQL.deleteByUserIdAndPrivilegeId(userId, privilegeId);
    }

    @Override
    public List<AssignedPrivilege> findByUserId(Long userId) {
        List<AssignedPrivilegeEntity> entities = assignedPrivilegeRepositorySQL.findByUserId(userId);
        return entities.stream()
            .map(assignedPrivilegeJpaMapper::entityToDomain)
            .toList();
    }

    @Override
    public boolean existsByUserIdAndPrivilegeId(Long userId, Long privilegeId) {
        return assignedPrivilegeRepositorySQL.existsByUserIdAndPrivilegeId(userId, privilegeId);
    }
}