package com.project.solution.domain.user.application.port.out;

import com.project.solution.domain.user.domain.model.User;

public interface SaveUserPort {
    void saveUser(User user);
}
