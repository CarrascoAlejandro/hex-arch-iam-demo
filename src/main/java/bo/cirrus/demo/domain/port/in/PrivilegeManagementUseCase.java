package bo.cirrus.demo.domain.port.in;

import java.util.List;

import bo.cirrus.demo.domain.model.Privilege;

public interface PrivilegeManagementUseCase {
    
    Privilege createPrivilege(CreatePrivilegeRequest request);

    Privilege findById(Long id);

    Privilege findByNameOrResourceKey(String name, String resourceKey);

    List<Privilege> listAllPrivileges();

    record CreatePrivilegeRequest(String name, String resourceKey) { }
}
