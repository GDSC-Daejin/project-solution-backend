# project-solution-backend

GDG on Campus Solution Challenge 2025 백엔드 서버 입니다.

## 기술 스택

- Spring Boot
- Spring JPA
- MySQL
- Swagger
- Postman
- Git
- AWS

## 팀원
### Backend Developers
<div align="center">

| <img src="https://github.com/user-attachments/assets/6e521cc2-58d7-47d9-9740-3e1e654f17f2" width="150" height="150" alt="Junpyo"/> |
|:---:|
| **Junpyo** |
</div>

## Project Structure

```bash
📂 solution-project
├── 📄 README.md
├── 📄 build.gradle
├── 📄 settings.gradle
└── 📂 src
    ├── 📂 main
    │   ├── 📂 java/com/project/solution
    │   │   ├── 📄 SolutionApplication.java
    │   │   ├── 📂 domain
    │   │   │   ├── 📂 chatbot
    │   │   │   │   ├── 📂 adapter
    │   │   │   │   ├── 📂 application
    │   │   │   │   │   ├── 📂 port
    │   │   │   │   │   └── 📂 service
    │   │   │   │   └── 📂 domain
    │   │   │   ├── 📂 diary
    │   │   │   │   ├── 📂 adapter
    │   │   │   │   │   ├── 📂 dto
    │   │   │   │   │   │   ├── 📄 DiarySentimentAnalysisResult.java
    │   │   │   │   │   │   └── 📂 request
    │   │   │   │   │   └── 📂 in/web/api
    │   │   │   │   │       └── 📄 DiaryApi.java
    │   │   │   │   ├── 📂 application
    │   │   │   │   │   ├── 📂 command
    │   │   │   │   │   │   └── 📄 DiarySentimentAnalysisCommand.java
    │   │   │   │   │   ├── 📂 port/in
    │   │   │   │   │   │   ├── 📄 AiDiaryUseCase.java
    │   │   │   │   │   │   └── 📄 UserDiaryUseCase.java
    │   │   │   │   │   └── 📂 service
    │   │   │   │   │       ├── 📄 AiDiaryService.java
    │   │   │   │   │       └── 📄 UserDiaryService.java
    │   │   │   │   └── 📂 domain/model
    │   │   │   │       └── 📄 diary.java
    │   │   │   └── 📂 user
    │   │   │       ├── 📂 adapter
    │   │   │       │   ├── 📂 dto
    │   │   │       │   │   ├── 📄 UserResponse.java
    │   │   │       │   │   └── 📄 UserSignUpRequest.java
    │   │   │       │   ├── 📂 in/web/api
    │   │   │       │   │   └── 📄 UserApi.java
    │   │   │       │   └── 📂 out/persistence
    │   │   │       │       ├── 📄 UserPersistenceAdapter.java
    │   │   │       │       └── 📄 UserRepository.java
    │   │   │       ├── 📂 application
    │   │   │       │   ├── 📂 service
    │   │   │       │   │   └── 📄 UserService.java
    │   │   │       │   └── 📂 port/in
    │   │   │       │       └── 📄 UserUseCase.java
    │   │   │       └── 📂 domain
    │   │   │           ├── 📂 entity
    │   │   │           │   └── 📄 UserEntity.java
    │   │   │           └── 📂 model
    │   │   │               └── 📄 User.java
    │   │   ├── 📂 global
    │   │   │   ├── 📂 common/response
    │   │   │   │   └── 📄 ResponseDto.java
    │   │   │   ├── 📂 config
    │   │   │   │   ├── 📄 RestTemplateConfig.java
    │   │   │   │   └── 📄 SwaggerConfig.java
    │   │   │   └── 📂 error/exception
    │   │   │       ├── 📄 CustomException.java
    │   │   │       ├── 📄 ErrorCode.java
    │   │   │       └── 📄 GlobalExceptionHandler.java
    │   │   └── 📂 infra/gemini
    │   │       ├── 📄 GeminiClient.java
    │   │       ├── 📂 dto
    │   │       │   ├── 📄 GeminiRequest.java
    │   │       │   └── 📄 GeminiResponse.java
    │   │       └── 📂 enums
    │   │           ├── 📄 AIPrompt.java
    │   │           └── 📄 GeminiModel.java
    │   └── 📂 resources
    │       └── 📄 application.properties
    └── 📂 test
        └── 📂 java/com/project/solution
            └── 📄 SolutionApplicationTests.java
