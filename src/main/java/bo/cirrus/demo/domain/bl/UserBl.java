package bo.cirrus.demo.domain.bl;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.cirrus.demo.domain.model.AssignedPrivilege;
import bo.cirrus.demo.domain.model.Privilege;
import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.domain.port.in.PrivilegeAssignmentUseCase;
import bo.cirrus.demo.domain.port.in.UserManagementUseCase;
import bo.cirrus.demo.domain.port.out.repository.UserRepository;

@Service
public class UserBl implements UserManagementUseCase, PrivilegeAssignmentUseCase {

    private final UserRepository userRepository;
    private final PrivilegeBl privilegeBl;

    public UserBl(UserRepository userRepository, PrivilegeBl privilegeBl) {
        this.userRepository = userRepository;
        this.privilegeBl = privilegeBl;
    }

    // Helper method to get privileges from assigned privileges
    private List<Privilege> getPrivilegesFromUser(User user) {
        if (user.getAssignedPrivileges() == null) {
            return List.of();
        }
        return user.getAssignedPrivileges().stream()
                .map(AssignedPrivilege::getPrivilege)
                .toList();
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(request.password()); // In a real application, ensure to hash the password
        return userRepository.save(user);
    }

    @Override
    public User findByUsernameOrEmail(String username, String email) {
        User result;
        if (username != null) {
            result = userRepository.findByUsername(username);
        } else if (email != null) {
            result = userRepository.findByEmail(email);
        } else {
            throw new IllegalArgumentException("Either username or email must be provided");
        }
        if (result == null) {
            throw new IllegalArgumentException("User not found");
        }
        return result;
    }

    @Override
    public User assignPrivilegeToUser(UserPrivilegeRequest request) {
        User user = userRepository.findByUsername(request.username());
        if (user == null) {
                throw new IllegalArgumentException("User not found");
        }
                
        Privilege privilege = privilegeBl.findById(request.privilegeId());
        if (privilege == null) {
            throw new IllegalArgumentException("Privilege not found");
        }

        if (getPrivilegesFromUser(user).stream().anyMatch(p -> p.getId().equals(privilege.getId()))) {
            throw new IllegalArgumentException("User already has this privilege assigned");
        }

        // TODO: For now, we'll throw an exception as we need to implement the assignment logic properly
        // This would require creating an AssignedPrivilege entity and adding it to the user
        throw new UnsupportedOperationException("Privilege assignment not yet implemented with new structure");
    }

    @Override
    public User removePrivilegeFromUser(UserPrivilegeRequest request) {
        User user = userRepository.findByUsername(request.username());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Privilege privilege = privilegeBl.findById(request.privilegeId());
        if (privilege == null) {
            throw new IllegalArgumentException("Privilege not found");
        }

        // TODO: For now, we'll throw an exception as we need to implement the removal logic properly
        // This would require removing the AssignedPrivilege entity from the user
        throw new UnsupportedOperationException("Privilege removal not yet implemented with new structure");
    }
}
