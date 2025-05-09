package com.project.solution.domain.user.application.command;

import com.project.solution.domain.user.exception.UserInvalidValueException;
import com.project.solution.global.error.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSignUpCommand {

    private final String email;

    private final String pwd;

    public UserSignUpCommand(String email, String pwd) {
        if (email == null || email.trim().isEmpty()){
            throw new UserInvalidValueException(ErrorCode.INVALID_INPUT_VALUE);
        }
        if (pwd == null || pwd.trim().isEmpty()){
            throw new UserInvalidValueException(ErrorCode.INVALID_INPUT_VALUE);
        }
        this.email = email;
        this.pwd = pwd;
    }
}
