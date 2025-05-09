package com.project.solution.domain.user.exception;

import com.project.solution.global.error.exception.CustomException;
import com.project.solution.global.error.exception.ErrorCode;

public class UserInvalidValueException extends CustomException {
    public UserInvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
