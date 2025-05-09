package com.project.solution.domain.user.adapter.in.web.api;

import com.project.solution.domain.user.application.command.UserSignUpCommand;
import com.project.solution.domain.user.application.port.in.UserUseCase;
import com.project.solution.domain.user.adapter.dto.UserSignUpRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApi {

    private final UserUseCase userUseCase;

    @Autowired
    public UserApi(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/user/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserSignUpRequest userSignUpRequest) {
        UserSignUpCommand userSignUpCommand = UserSignUpCommand.builder()
                .email(userSignUpRequest.getEmail())
                .pwd(userSignUpRequest.getPwd())
                .build();
        return userUseCase.signUp(userSignUpCommand);
    }

    @GetMapping("/user/find-email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        return userUseCase.findUserByEmail(email);
    }

}
