package com.project.solution.domain.user.domain.model;

import lombok.Getter;

@Getter
public class User {
    //식별자
    private final String email;

    //속성 필드
    private String pwd;

    private User(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public static User createUser(String email, String pwd) {
        return new User(email, pwd);
    }
}
