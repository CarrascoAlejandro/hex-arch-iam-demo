package bo.cirrus.demo.domain.bl;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.cirrus.demo.domain.model.Privilege;
import bo.cirrus.demo.domain.port.in.PrivilegeManagementUseCase;

@Service
public class PrivilegeBl implements PrivilegeManagementUseCase {

    @Override
    public Privilege createPrivilege(CreatePrivilegeRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPrivilege'");
    }

    @Override
    public Privilege findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Privilege findByNameOrResourceKey(String name, String resourceKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNameOrResourceKey'");
    }

    @Override
    public List<Privilege> listAllPrivileges() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllPrivileges'");
    }
}
