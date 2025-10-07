package bo.cirrus.demo.infrastructure.adapter.out.persistence.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import bo.cirrus.demo.domain.model.Privilege;
import bo.cirrus.demo.domain.port.out.repository.PrivilegeRepository;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.PrivilegeEntity;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper.PrivilegeJpaMapper;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.repository.PrivilegeRepositorySQL;

@Component
public class PrivilegeJpaAdapter implements PrivilegeRepository {

    private final PrivilegeRepositorySQL privilegeRepositorySQL;
    private final PrivilegeJpaMapper privilegeJpaMapper;

    public PrivilegeJpaAdapter(PrivilegeRepositorySQL privilegeRepositorySQL, PrivilegeJpaMapper privilegeJpaMapper) {
        this.privilegeRepositorySQL = privilegeRepositorySQL;
        this.privilegeJpaMapper = privilegeJpaMapper;
    }

    @Override
    public Privilege save(Privilege privilege) {
        PrivilegeEntity privilegeEntity = privilegeJpaMapper.domainToEntity(privilege);
        PrivilegeEntity savedEntity = privilegeRepositorySQL.save(privilegeEntity);
        return privilegeJpaMapper.entityToDomain(savedEntity);
    }

    @Override
    public Privilege findById(Long id) {
        PrivilegeEntity entity = privilegeRepositorySQL.findById(id).orElse(null);
        return privilegeJpaMapper.entityToDomain(entity);
    }

    @Override
    public Privilege findByName(String name) {
        PrivilegeEntity entity = privilegeRepositorySQL.findByName(name).orElse(null);
        return privilegeJpaMapper.entityToDomain(entity);
    }

    @Override
    public Privilege findByResourceKey(String resourceKey) {
        PrivilegeEntity entity = privilegeRepositorySQL.findByResourceKey(resourceKey).orElse(null);
        return privilegeJpaMapper.entityToDomain(entity);
    }

    @Override
    public List<Privilege> findAll() {
        List<PrivilegeEntity> entities = privilegeRepositorySQL.findAll();
        return entities.stream()
            .map(privilegeJpaMapper::entityToDomain)
            .toList();
    }
    
}
