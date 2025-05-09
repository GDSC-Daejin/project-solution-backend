package com.project.solution.domain.user.adapter.dto;

import com.project.solution.domain.user.domain.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSignUpRequest {

    @NotBlank(message = "이메일 값이 비어있습니다.")
    private String email;

    @NotBlank(message = "비밀번호 값이 비어있습니다.")
    private String pwd;
}
