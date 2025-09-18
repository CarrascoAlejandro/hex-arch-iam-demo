package bo.cirrus.demo.domain.port.out.repository;

import java.util.List;

import bo.cirrus.demo.domain.model.Privilege;

public interface PrivilegeRepository {

    Privilege save(Privilege privilege);
    Privilege findById(Long id);
    Privilege findByName(String name);
    Privilege findByResourceKey(String resourceKey);
    List<Privilege> findAll();
}
