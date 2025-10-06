package bo.cirrus.demo.domain.bl;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.cirrus.demo.domain.model.Privilege;
import bo.cirrus.demo.domain.port.in.PrivilegeManagementUseCase;
import bo.cirrus.demo.domain.port.out.repository.PrivilegeRepository;

@Service
public class PrivilegeBl implements PrivilegeManagementUseCase {

    private final PrivilegeRepository privilegeRepository;

    public PrivilegeBl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Privilege createPrivilege(CreatePrivilegeRequest request) {
        Privilege privilege = new Privilege();
        privilege.setName(request.name());
        privilege.setResourceKey(request.resourceKey());
        return privilegeRepository.save(privilege);
    }

    @Override
    public Privilege findById(Long id) {
        return privilegeRepository.findById(id);
    }

    @Override
    public Privilege findByNameOrResourceKey(String name, String resourceKey) {
        Privilege result;
        if (name != null) {
            result = privilegeRepository.findByName(name);
        } else if (resourceKey != null) {
            result = privilegeRepository.findByResourceKey(resourceKey);
        } else {
            throw new IllegalArgumentException("Either name or resourceKey must be provided");
        }
        if (result == null) {
            throw new IllegalArgumentException("Privilege not found");
        }
        return result;
    }

    @Override
    public List<Privilege> listAllPrivileges() {
        return privilegeRepository.findAll();
    }
}
