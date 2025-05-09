package com.project.solution.domain.user.mapper;

import com.project.solution.domain.user.application.command.UserSignUpCommand;
import com.project.solution.domain.user.domain.entity.UserEntity;
import com.project.solution.domain.user.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User signUpCommandToDomain(UserSignUpCommand userSignUpCommand) {
        return User.createUser(userSignUpCommand.getEmail(), userSignUpCommand.getPwd());
    }



    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .email(user.getEmail())
                .pwd(user.getPwd())
                .build();
    }
}
