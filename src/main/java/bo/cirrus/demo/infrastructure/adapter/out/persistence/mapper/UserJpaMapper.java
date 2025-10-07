package bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.UserEntity;

import org.mapstruct.Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = AssignedPrivilegeJpaMapper.class)
public interface UserJpaMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(target = "assignedPrivileges", ignore = true)
    UserEntity domainToEntity(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "assignedPrivileges", target = "assignedPrivileges")
    User entityToDomain(UserEntity entity);
}
