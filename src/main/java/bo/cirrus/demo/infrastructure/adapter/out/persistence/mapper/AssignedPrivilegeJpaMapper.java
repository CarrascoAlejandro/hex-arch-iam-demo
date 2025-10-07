package bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import bo.cirrus.demo.domain.model.AssignedPrivilege;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.AssignedPrivilegeEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PrivilegeJpaMapper.class)
public interface AssignedPrivilegeJpaMapper {

    @Mapping(source = "privilege", target = "privilege")
    AssignedPrivilege entityToDomain(AssignedPrivilegeEntity entity);

    @Mapping(source = "privilege", target = "privilege")
    @Mapping(target = "user", ignore = true)
    AssignedPrivilegeEntity domainToEntity(AssignedPrivilege domain);
}