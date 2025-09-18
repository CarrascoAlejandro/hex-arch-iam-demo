package bo.cirrus.demo.domain.port.out.repository;

import java.util.List;

import bo.cirrus.demo.domain.model.User;

public interface UserRepository {

    User save(User user);
    User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}
