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

import bo.cirrus.demo.domain.port.in.PrivilegeAssignmentUseCase;
import bo.cirrus.demo.domain.port.in.PrivilegeManagementUseCase;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.AssignPrivilegeRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.CreatePrivilegeRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.GlobalWebResponseDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.PrivilegeWebResponseDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.UserWebResponseDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.mapper.PrivilegeWebMapper;
import bo.cirrus.demo.infrastructure.adapter.in.rest.mapper.UserWebMapper;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    private final PrivilegeManagementUseCase privilegeManagementUseCase;
    private final PrivilegeAssignmentUseCase privilegeAssignmentUseCase;
    private final PrivilegeWebMapper privilegeWebMapper;
    private final UserWebMapper userWebMapper;

    public PrivilegeController(
        PrivilegeManagementUseCase privilegeManagementUseCase,
        PrivilegeAssignmentUseCase privilegeAssignmentUseCase,
        PrivilegeWebMapper privilegeWebMapper,
        UserWebMapper userWebMapper
    ) {
        this.privilegeManagementUseCase = privilegeManagementUseCase;
        this.privilegeAssignmentUseCase = privilegeAssignmentUseCase;
        this.privilegeWebMapper = privilegeWebMapper;
        this.userWebMapper = userWebMapper;
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
    public ResponseEntity<GlobalWebResponseDto<PrivilegeWebResponseDto>> findByNameOrResourceKey(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String resourceKey
    ) {
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

    @PostMapping("/assign")
    public ResponseEntity<GlobalWebResponseDto<UserWebResponseDto>> assignPrivilegeToUser(@RequestBody AssignPrivilegeRequestDto requestDto) {
        var assignment = privilegeWebMapper.webDtoToDomainAssignPrivilegeRequest(requestDto);
        var response = userWebMapper.domainToWebResponseDto(privilegeAssignmentUseCase.assignPrivilegeToUser(assignment));
        return ResponseEntity.ok(new GlobalWebResponseDto<>("PRV-1001", "Privilege assigned to user successfully", response));
    }

    @PostMapping("/remove")
    public ResponseEntity<GlobalWebResponseDto<UserWebResponseDto>> removePrivilegeFromUser(@RequestBody AssignPrivilegeRequestDto requestDto) {
        var assignment = privilegeWebMapper.webDtoToDomainAssignPrivilegeRequest(requestDto);
        var response = userWebMapper.domainToWebResponseDto(privilegeAssignmentUseCase.removePrivilegeFromUser(assignment));
        return ResponseEntity.ok(new GlobalWebResponseDto<>("PRV-1002", "Privilege removed from user successfully", response));
    }

}
