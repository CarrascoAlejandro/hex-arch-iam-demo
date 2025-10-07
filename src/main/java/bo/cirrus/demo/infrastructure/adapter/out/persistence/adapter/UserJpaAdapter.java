package bo.cirrus.demo.infrastructure.adapter.out.persistence.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import bo.cirrus.demo.domain.model.User;
import bo.cirrus.demo.domain.port.out.repository.UserRepository;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.entity.UserEntity;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.mapper.UserJpaMapper;
import bo.cirrus.demo.infrastructure.adapter.out.persistence.repository.UserRepositorySQL;

@Component
public class UserJpaAdapter implements UserRepository {

    
    private final UserRepositorySQL userRepositorySQL;
    private final UserJpaMapper userJpaMapper;

    public UserJpaAdapter(
        UserRepositorySQL userRepositorySQL,
        UserJpaMapper userJpaMapper
    ) {
        this.userRepositorySQL = userRepositorySQL;
        this.userJpaMapper = userJpaMapper;
    }


    @Override
    public User save(User user) {
        UserEntity userEntity = userJpaMapper.domainToEntity(user);
        return userJpaMapper.entityToDomain(userRepositorySQL.save(userEntity));
    }

    @Override
    public User findById(Long id) {
        return userJpaMapper.entityToDomain(userRepositorySQL.findByIdWithPrivileges(id).orElse(null));
    }

    @Override
    public User findByUsername(String username) {
        return userJpaMapper.entityToDomain(userRepositorySQL.findByUsernameWithPrivileges(username).orElse(null));
    }

    @Override
    public User findByEmail(String email) {
        return userJpaMapper.entityToDomain(userRepositorySQL.findByEmailWithPrivileges(email).orElse(null));
    }

    @Override
    public List<User> findAll() {
        return userRepositorySQL.findAll().stream()
            .map(userJpaMapper::entityToDomain)
            .toList();
    }
    
}
