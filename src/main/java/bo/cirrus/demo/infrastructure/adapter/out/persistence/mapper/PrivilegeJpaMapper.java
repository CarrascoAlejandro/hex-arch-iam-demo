package bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import bo.cirrus.demo.domain.model.Privilege;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.PrivilegeEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrivilegeJpaMapper {

    
    PrivilegeEntity domainToEntity(Privilege privilege);

    Privilege entityToDomain(PrivilegeEntity privilegeEntity);
    
}
