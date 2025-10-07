package bo.cirrus.demo.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.domain.port.in.UserManagementUseCase.CreateUserRequest;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.CreateUserRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.UserWebResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = AssignedPrivilegeWebMapper.class)
public interface UserWebMapper {

    CreateUserRequest webDtoToDomainCreateUserRequest(CreateUserRequestDto dto);

    @Mapping(source = "assignedPrivileges", target = "assignedPrivileges")
    UserWebResponseDto domainToWebResponseDto(User user);
}
