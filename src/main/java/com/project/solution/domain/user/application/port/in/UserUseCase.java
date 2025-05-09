package com.project.solution.domain.user.application.port.in;
import com.project.solution.domain.user.adapter.dto.UserSignUpRequest;
import com.project.solution.domain.user.application.command.UserSignUpCommand;
import org.springframework.http.ResponseEntity;

public interface UserUseCase {
    public ResponseEntity<?> aiTest();
    public ResponseEntity<?> aiImageTest();
    public ResponseEntity<?> signUp(UserSignUpCommand userSignUpCommand);
    public ResponseEntity<?> findUserByEmail(String email);
}
