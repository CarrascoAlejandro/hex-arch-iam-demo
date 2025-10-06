package bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;

import bo.cirrus.demo.domain.model.Privilege;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.PrivilegeEntity;

@Mapper
public interface PrivilegeJpaMapper {

    
    PrivilegeEntity domainToEntity(Privilege privilege);

    Privilege entityToDomain(PrivilegeEntity privilegeEntity);
    
}
