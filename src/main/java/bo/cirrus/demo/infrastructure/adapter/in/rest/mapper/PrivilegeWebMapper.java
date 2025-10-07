package bo.cirrus.demo.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import bo.cirrus.demo.domain.model.Privilege;
import bo.cirrus.demo.domain.port.in.PrivilegeManagementUseCase;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.CreatePrivilegeRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.PrivilegeWebResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrivilegeWebMapper {

    PrivilegeWebResponseDto toWebResponseDto(Privilege privilege);

    PrivilegeManagementUseCase.CreatePrivilegeRequest webDtoToDomainCreatePrivilegeRequest(CreatePrivilegeRequestDto dto);
}
