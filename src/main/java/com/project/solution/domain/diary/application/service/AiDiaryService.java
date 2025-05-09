package com.project.solution.domain.diary.application.service;

import com.project.solution.domain.diary.adapter.dto.DiarySentimentAnalysisResult;
import com.project.solution.domain.diary.application.command.DiarySentimentAnalysisCommand;
import com.project.solution.domain.diary.application.port.in.AiDiaryUseCase;
import com.project.solution.domain.diary.application.port.out.GeminiRequestPort;
import com.project.solution.domain.diary.exception.DiaryInvalidValueException;
import com.project.solution.domain.diary.mapper.DiaryMapper;
import com.project.solution.global.error.exception.ErrorCode;
import com.project.solution.infra.gemini.dto.GeminiResponse;
import com.project.solution.infra.gemini.enums.AIPrompt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AiDiaryService implements AiDiaryUseCase {

    private final GeminiRequestPort geminiRequestPort;
    private final DiaryMapper diaryMapper;

    @Autowired
    public AiDiaryService(GeminiRequestPort geminiRequestPort, DiaryMapper diaryMapper) {
        this.geminiRequestPort = geminiRequestPort;
        this.diaryMapper = diaryMapper;
    }

    @Override //ai 감정분석 요청 api
    public DiarySentimentAnalysisResult requestSentimentAnalysis(DiarySentimentAnalysisCommand diarySentimentAnalysisCommand) {
        if (diarySentimentAnalysisCommand.getDiaryText() == null ||
                diarySentimentAnalysisCommand.getDiaryText().trim().isEmpty()) {
            throw new DiaryInvalidValueException(ErrorCode.INVALID_INPUT_VALUE);
        } else { //이부분 현재는 command값을 그대로 인프라스트럭쳐 쪽으로 보내고 있는데 나중에 도메인으로 변환시킨다음 보내야함
            GeminiResponse geminiResponse = geminiRequestPort.rqGeminiText(AIPrompt.SENTIMENT_ANALYSIS.getPrompt() + diarySentimentAnalysisCommand.getDiaryText());
            return diaryMapper.GeminiResponseToSentimentResult(geminiResponse);
        }
    }
}
