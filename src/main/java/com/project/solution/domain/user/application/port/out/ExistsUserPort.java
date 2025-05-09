package com.project.solution.domain.user.application.port.out;

public interface ExistsUserPort {
    boolean existsByEmail(String email);
}
