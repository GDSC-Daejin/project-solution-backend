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
    │   │   │   │   │   ├── 📂 dto
    │   │   │   │   │   ├── 📂 in/web/api
    │   │   │   │   │   └── 📂 out/persistence
    │   │   │   │   ├── 📂 application
    │   │   │   │   │   ├── 📂 port
    │   │   │   │   │   │   ├── 📂 in
    │   │   │   │   │   │   └── 📂 out
    │   │   │   │   │   └── 📂 service
    │   │   │   │   ├── 📂 domain
    │   │   │   │   ├── 📂 exception
    │   │   │   │   └── 📂 mapper
    │   │   │   ├── 📂 diary
    │   │   │   │   ├── 📂 adapter
    │   │   │   │   │   ├── 📂 dto
    │   │   │   │   │   │   ├── 📄 DiarySentimentAnalysisResult.java
    │   │   │   │   │   │   ├── 📂 request
    │   │   │   │   │   │   │   └── 📄 DiaryRequestSentimentAnalysis.java
    │   │   │   │   │   │   └── 📂 response
    │   │   │   │   │   ├── 📂 in/web/api
    │   │   │   │   │   │   └── 📄 DiaryApi.java
    │   │   │   │   │   └── 📂 out/persistence
    │   │   │   │   ├── 📂 application
    │   │   │   │   │   ├── 📂 command
    │   │   │   │   │   │   └── 📄 DiarySentimentAnalysisCommand.java
    │   │   │   │   │   ├── 📂 port
    │   │   │   │   │   │   ├── 📂 in
    │   │   │   │   │   │   │   ├── 📄 AiDiaryUseCase.java
    │   │   │   │   │   │   │   └── 📄 UserDiaryUseCase.java
    │   │   │   │   │   │   └── 📂 out
    │   │   │   │   │   │       └── 📄 GeminiRequestPort.java
    │   │   │   │   │   └── 📂 service
    │   │   │   │   │       ├── 📄 AiDiaryService.java
    │   │   │   │   │       └── 📄 UserDiaryService.java
    │   │   │   │   ├── 📂 domain
    │   │   │   │   │   ├── 📂 entity
    │   │   │   │   │   └── 📂 model
    │   │   │   │   │       └── 📄 diary.java
    │   │   │   │   ├── 📂 exception
    │   │   │   │   │   └── 📄 DiaryInvalidValueException.java
    │   │   │   │   └── 📂 mapper
    │   │   │   │       └── 📄 DiaryMapper.java
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
    │   │   │       │   ├── 📂 command
    │   │   │       │   │   └── 📄 UserSignUpCommand.java
    │   │   │       │   ├── 📂 port
    │   │   │       │   │   ├── 📂 in
    │   │   │       │   │   │   └── 📄 UserUseCase.java
    │   │   │       │   │   └── 📂 out
    │   │   │       │   │       ├── 📄 ExistsUserPort.java
    │   │   │       │   │       └── 📄 SaveUserPort.java
    │   │   │       │   └── 📂 service
    │   │   │       │       └── 📄 UserService.java
    │   │   │       ├── 📂 domain
    │   │   │       │   ├── 📂 entity
    │   │   │       │   │   └── 📄 UserEntity.java
    │   │   │       │   └── 📂 model
    │   │   │       │       └── 📄 User.java
    │   │   │       ├── 📂 exception
    │   │   │       │   └── 📄 UserInvalidValueException.java
    │   │   │       └── 📂 mapper
    │   │   │           └── 📄 UserMapper.java
    │   │   ├── 📂 global
    │   │   │   ├── 📂 common
    │   │   │   │   ├── 📂 filter
    │   │   │   │   ├── 📂 request
    │   │   │   │   └── 📂 response
    │   │   │   │       └── 📄 ResponseDto.java
    │   │   │   ├── 📂 config
    │   │   │   │   ├── 📄 MultipartJackson2HttpMessageConverter.java
    │   │   │   │   ├── 📄 RestTemplateConfig.java
    │   │   │   │   ├── 📄 SwaggerConfig.java
    │   │   │   │   └── 📄 WebConfig.java
    │   │   │   ├── 📂 error/exception
    │   │   │   │   ├── 📄 CustomException.java
    │   │   │   │   ├── 📄 ErrorCode.java
    │   │   │   │   └── 📄 GlobalExceptionHandler.java
    │   │   │   ├── 📂 security
    │   │   │   │   ├── 📂 config
    │   │   │   │   ├── 📂 filter
    │   │   │   │   └── 📂 util
    │   │   │   └── 📂 util
    │   │   └── 📂 infra/gemini
    │   │       ├── 📄 GeminiClient.java
    │   │       ├── 📂 dto
    │   │       │   ├── 📄 GeminiRequest.java
    │   │       │   └── 📄 GeminiResponse.java
    │   │       └── 📂 enums
    │   │           ├── 📄 AIPrompt.java
    │   │           ├── 📄 GeminiMimeType.java
    │   │           └── 📄 GeminiModel.java
    │   └── 📂 resources
    │       ├── 📄 application.properties
    │       ├── 📄 application.properties.sample
    │       └── 📂 static
    │           ├── 📂 data
    │           └── 📂 images
    └── 📂 test/java/com/project/solution
        └── 📄 SolutionApplicationTests.java
