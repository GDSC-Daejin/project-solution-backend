package com.project.solution.domain.diary.mapper;

import com.project.solution.domain.diary.adapter.dto.DiarySentimentAnalysisResult;
import com.project.solution.domain.diary.adapter.dto.request.DiaryRequestSentimentAnalysis;
import com.project.solution.domain.diary.application.command.DiarySentimentAnalysisCommand;
import com.project.solution.infra.gemini.dto.GeminiResponse;
import org.springframework.stereotype.Component;

@Component
public class DiaryMapper {
    public DiarySentimentAnalysisResult GeminiResponseToSentimentResult(GeminiResponse geminiResponse) {
        DiarySentimentAnalysisResult diarySentimentAnalysisResult = new DiarySentimentAnalysisResult(geminiResponse.getCandidates());
        return diarySentimentAnalysisResult;
    }

    public DiarySentimentAnalysisCommand DiaryRequestSentimentAnalysisToCommand(DiaryRequestSentimentAnalysis diaryRequestSentimentAnalysis) {
        return DiarySentimentAnalysisCommand.builder()
                .diaryText(diaryRequestSentimentAnalysis.getDiaryText())
                .build();
    }

}
