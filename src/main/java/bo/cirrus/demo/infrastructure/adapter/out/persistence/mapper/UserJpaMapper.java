package bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;

import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.UserEntity;

import org.mapstruct.Mapping;

@Mapper
public interface UserJpaMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserEntity domainToEntity(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User entityToDomain(UserEntity entity);
}
