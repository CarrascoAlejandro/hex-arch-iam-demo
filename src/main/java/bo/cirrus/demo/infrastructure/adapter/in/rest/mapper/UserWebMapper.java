package bo.cirrus.demo.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.domain.port.in.UserManagementUseCase.CreateUserRequest;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.CreateUserRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.UserWebResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserWebMapper {

    CreateUserRequest webDtoToDomainCreateUserRequest(CreateUserRequestDto dto);

    UserWebResponseDto domainToWebResponseDto(User user);
}
