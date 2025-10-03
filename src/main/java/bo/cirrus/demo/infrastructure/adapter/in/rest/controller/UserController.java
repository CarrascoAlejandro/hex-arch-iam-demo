package bo.cirrus.demo.infrastructure.adapter.in.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.domain.port.in.UserManagementUseCase;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.CreateUserRequestDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.GlobalWebResponseDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.dto.UserWebResponseDto;
import bo.cirrus.demo.infrastructure.adapter.in.rest.mapper.UserWebMapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserManagementUseCase userManagementUseCase;
    private final UserWebMapper userWebMapper;

    public UserController(
        UserManagementUseCase userManagementUseCase,
        UserWebMapper userWebMapper
    ) {
        this.userManagementUseCase = userManagementUseCase;
        this.userWebMapper = userWebMapper;
    }

    @PostMapping()
    public GlobalWebResponseDto<UserWebResponseDto> createUser(@RequestBody CreateUserRequestDto dto) {
        UserManagementUseCase.CreateUserRequest request = userWebMapper.webDtoToDomainCreateUserRequest(dto);
        User user = userManagementUseCase.createUser(request);
        UserWebResponseDto userResponse = userWebMapper.domainToWebResponseDto(user);
        return new GlobalWebResponseDto<>("200", null, userResponse);
    }

    @GetMapping()
    public GlobalWebResponseDto<UserWebResponseDto> findByUsernameOrEmail(@RequestParam String username, @RequestParam String email) {
        User user = userManagementUseCase.findByUsernameOrEmail(username, email);
        UserWebResponseDto userResponse = userWebMapper.domainToWebResponseDto(user);
        return new GlobalWebResponseDto<>("200", null, userResponse);
    }
    
}
