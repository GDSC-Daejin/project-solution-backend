package com.project.solution.domain.diary.exception;

import com.project.solution.global.error.exception.CustomException;
import com.project.solution.global.error.exception.ErrorCode;

public class DiaryInvalidValueException extends CustomException {
    public DiaryInvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
