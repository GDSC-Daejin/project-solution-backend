package com.project.solution.domain.user.domain.entity;

import com.project.solution.domain.user.adapter.dto.UserResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "유저")
public class UserEntity {

    @Id
    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String pwd;

    public UserResponse toResponseDto() {
        return UserResponse.builder()
                .email(email)
                .build();
    }

}
