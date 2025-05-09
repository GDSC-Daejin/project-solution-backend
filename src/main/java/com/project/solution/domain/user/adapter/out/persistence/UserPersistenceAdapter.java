package com.project.solution.domain.user.adapter.out.persistence;

import com.project.solution.domain.user.application.port.out.ExistsUserPort;
import com.project.solution.domain.user.application.port.out.SaveUserPort;
import com.project.solution.domain.user.domain.model.User;
import com.project.solution.domain.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserPersistenceAdapter implements SaveUserPort, ExistsUserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserPersistenceAdapter(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
