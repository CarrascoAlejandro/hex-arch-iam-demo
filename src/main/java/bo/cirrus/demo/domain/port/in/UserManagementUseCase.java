package bo.cirrus.demo.domain.port.in;

import bo.cirrus.demo.domain.model.User;

public interface UserManagementUseCase {
    
    User createUser(CreateUserRequest request);

    User findByUsernameOrEmail(String username, String email);

    record CreateUserRequest(String username, String email, String password) { }
}
