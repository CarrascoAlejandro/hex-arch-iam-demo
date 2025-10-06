package bo.cirrus.demo.infrastructure.adapter.in.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bo.cirrus.demo.domain.port.in.PrivilegeManagementUseCase;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.CreatePrivilegeRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.GlobalWebResponseDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.PrivilegeWebResponseDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.mapper.PrivilegeWebMapper;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    private final PrivilegeManagementUseCase privilegeManagementUseCase;
    private final PrivilegeWebMapper privilegeWebMapper;

    public PrivilegeController(
        PrivilegeManagementUseCase privilegeManagementUseCase, 
        PrivilegeWebMapper privilegeWebMapper
    ) {
        this.privilegeManagementUseCase = privilegeManagementUseCase;
        this.privilegeWebMapper = privilegeWebMapper;
    }

    @PostMapping
    public ResponseEntity<GlobalWebResponseDto<PrivilegeWebResponseDto>> createPrivilege(@RequestBody CreatePrivilegeRequestDto requestDto) {
        PrivilegeManagementUseCase.CreatePrivilegeRequest request = privilegeWebMapper.webDtoToDomainCreatePrivilegeRequest(requestDto);
        var privilege = privilegeManagementUseCase.createPrivilege(request);
        var responseDto = privilegeWebMapper.toWebResponseDto(privilege);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GlobalWebResponseDto<>("PRV-1000", "Privilege created successfully", responseDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalWebResponseDto<PrivilegeWebResponseDto>> findById(@PathVariable Long id) {
        var privilege = privilegeManagementUseCase.findById(id);
        var responseDto = privilegeWebMapper.toWebResponseDto(privilege);
        return ResponseEntity.ok(new GlobalWebResponseDto<>("PRV-1000", null, responseDto));
    }

    @GetMapping()
    public ResponseEntity<GlobalWebResponseDto<PrivilegeWebResponseDto>> findByNameOrResourceKey(@RequestParam String name, @RequestParam String resourceKey) {
        var privilege = privilegeManagementUseCase.findByNameOrResourceKey(name, resourceKey);
        var responseDto = privilegeWebMapper.toWebResponseDto(privilege);
        return ResponseEntity.ok(new GlobalWebResponseDto<>("PRV-1000", null, responseDto));
    }

    @GetMapping("/list")
    public ResponseEntity<GlobalWebResponseDto<java.util.List<PrivilegeWebResponseDto>>> listAllPrivileges() {
        var privileges = privilegeManagementUseCase.listAllPrivileges();
        var responseDtos = privileges.stream()
                .map(privilegeWebMapper::toWebResponseDto)
                .toList();
        return ResponseEntity.ok(new GlobalWebResponseDto<>("PRV-1000", null, responseDtos));
    }

}
