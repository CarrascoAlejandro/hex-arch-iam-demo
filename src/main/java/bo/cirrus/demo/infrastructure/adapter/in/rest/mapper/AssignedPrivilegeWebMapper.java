package bo.cirrus.demo.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import bo.cirrus.demo.domain.model.AssignedPrivilege;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.AssignedPrivilegeWebResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PrivilegeWebMapper.class)
public interface AssignedPrivilegeWebMapper {

    @Mapping(source = "privilege", target = "privilege")
    AssignedPrivilegeWebResponseDto domainToWebResponseDto(AssignedPrivilege assignedPrivilege);
}