package bo.cirrus.demo.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.domain.port.in.UserManagementUseCase.CreateUserRequest;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.CreateUserRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.UserWebResponseDto;

@Mapper
public interface UserWebMapper {

    UserWebMapper INSTANCE = Mappers.getMapper(UserWebMapper.class);

    CreateUserRequest webDtoToDomainCreateUserRequest(CreateUserRequestDto dto);

    UserWebResponseDto domainToWebResponseDto(User user);
}
