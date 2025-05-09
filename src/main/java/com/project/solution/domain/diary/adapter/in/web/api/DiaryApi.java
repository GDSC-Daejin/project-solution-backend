package com.project.solution.domain.diary.adapter.in.web.api;

import com.project.solution.domain.diary.adapter.dto.DiarySentimentAnalysisResult;
import com.project.solution.domain.diary.adapter.dto.request.DiaryRequestSentimentAnalysis;
import com.project.solution.domain.diary.application.command.DiarySentimentAnalysisCommand;
import com.project.solution.domain.diary.application.port.in.AiDiaryUseCase;
import com.project.solution.domain.diary.mapper.DiaryMapper;
import com.project.solution.global.common.response.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
public class DiaryApi {

    private final AiDiaryUseCase aiDiaryUseCase;
    private final DiaryMapper diaryMapper;

    @Autowired
    public DiaryApi(AiDiaryUseCase aiDiaryUseCase, DiaryMapper diaryMapper) {
        this.aiDiaryUseCase = aiDiaryUseCase;
        this.diaryMapper = diaryMapper;
    }

    @PostMapping("/sentiment-analysis")
    public ResponseEntity<?> sentimentAnalysis(@RequestBody DiaryRequestSentimentAnalysis diaryRequestSentimentAnalysis) {
        DiarySentimentAnalysisCommand diarySentimentAnalysisCommand = diaryMapper.DiaryRequestSentimentAnalysisToCommand(diaryRequestSentimentAnalysis);
        DiarySentimentAnalysisResult diarySentimentAnalysisResult = aiDiaryUseCase.requestSentimentAnalysis(diarySentimentAnalysisCommand);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDto.response(HttpStatus.OK, "감정 분석 완료", diarySentimentAnalysisResult));
    }



}
