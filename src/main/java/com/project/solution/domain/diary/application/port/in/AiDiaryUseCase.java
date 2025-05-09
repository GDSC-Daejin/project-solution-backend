package com.project.solution.domain.diary.application.port.in;

import com.project.solution.domain.diary.adapter.dto.DiarySentimentAnalysisResult;
import com.project.solution.domain.diary.application.command.DiarySentimentAnalysisCommand;

public interface AiDiaryUseCase {
    public DiarySentimentAnalysisResult requestSentimentAnalysis(DiarySentimentAnalysisCommand diarySentimentAnalysisCommand);
}
