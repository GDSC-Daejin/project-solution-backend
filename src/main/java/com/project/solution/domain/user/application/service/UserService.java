package com.project.solution.domain.user.application.service;

import com.project.solution.domain.user.application.command.UserSignUpCommand;
import com.project.solution.domain.user.application.port.in.UserUseCase;
import com.project.solution.domain.user.application.port.out.ExistsUserPort;
import com.project.solution.domain.user.application.port.out.SaveUserPort;
import com.project.solution.domain.user.domain.model.User;
import com.project.solution.domain.user.mapper.UserMapper;
import com.project.solution.global.common.response.ResponseDto;
import com.project.solution.infra.gemini.GeminiClient;
import com.project.solution.infra.gemini.enums.AIPrompt;
import com.project.solution.infra.gemini.enums.GeminiMimeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Primary
public class UserService implements UserUseCase {

    private final GeminiClient geminiClient;
    private final SaveUserPort saveUserPort;
    private final ExistsUserPort existsUserPort;
    private final UserMapper userMapper;

    @Autowired
    public UserService(GeminiClient geminiClient, SaveUserPort saveUserPort, ExistsUserPort existsUserPort, UserMapper userMapper) {
        this.geminiClient = geminiClient;
        this.saveUserPort = saveUserPort;
        this.existsUserPort = existsUserPort;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<?> aiTest() {
        return ResponseEntity.ok().body(ResponseDto.response(HttpStatus.OK, "Ai Test", geminiClient.rqGeminiText(AIPrompt.SENTIMENT_ANALYSIS.getPrompt()+"오늘 하루가 너무 지치고 힘들었어.")));
    }

    @Override
    public ResponseEntity<?> aiImageTest() {
        String mimeType = GeminiMimeType.PNG.getValue(); //아무거나 상관 없음
        String data = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAoHBwgHBgoICAgLCgoLDhgQDg0NDh0VFhEYIx8lJCIfIiEmKzcvJik0KSEiMEExNDk7Pj4+JS5ESUM8SDc9Pjv/2wBDAQoLCw4NDhwQEBw7KCIoOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozv/wAARCAAKAAoDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD3+iiigD//2Q==";
        return ResponseEntity.ok().body(ResponseDto.response(HttpStatus.OK, "Ai Image Test", geminiClient.rqGeminiTextWithImage("안녕하세요", mimeType, data)));
    }

    @Override
    public ResponseEntity<?> signUp(UserSignUpCommand userSignUpCommand) {
        User user = userMapper.signUpCommandToDomain(userSignUpCommand);
        saveUserPort.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDto.response(HttpStatus.OK, "회원가입 성공", null));
    }

    @Override
    public ResponseEntity<?> findUserByEmail(String email) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDto.response(HttpStatus.OK, "이메일 중복 검사", existsUserPort.existsByEmail(email)));
    }
}
