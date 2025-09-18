package bo.cirrus.demo.domain.port.in;

import bo.cirrus.demo.domain.model.User;

public interface PrivilegeAssignmentUseCase {
    
    User assignPrivilegeToUser(UserPrivilegeRequest request);
    User removePrivilegeFromUser(UserPrivilegeRequest request);

    record UserPrivilegeRequest(String username, Long privilegeId) { }
}
