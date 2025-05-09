package com.project.solution.global.error.exception;

import com.project.solution.domain.diary.exception.DiaryInvalidValueException;
import com.project.solution.domain.user.exception.UserInvalidValueException;
import com.project.solution.global.common.response.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserInvalidValueException.class)
    public ResponseEntity<?> UserInvalidValueException(UserInvalidValueException e) {
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(ResponseDto.response(e.getErrorCode().getHttpStatus(), e.getMessage(), null));
    }

    @ExceptionHandler(DiaryInvalidValueException.class)
    public ResponseEntity<?> DiaryInvalidValueException(DiaryInvalidValueException e) {
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(ResponseDto.response(e.getErrorCode().getHttpStatus(), e.getMessage(), null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //@Valid 예외 처리
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus())
                .body(ResponseDto.response(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus(), ErrorCode.INVALID_INPUT_VALUE.getMessage(), null));
    }
}
