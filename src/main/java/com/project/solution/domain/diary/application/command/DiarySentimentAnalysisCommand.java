package com.project.solution.domain.diary.application.command;

import com.project.solution.domain.diary.adapter.dto.request.DiaryRequestSentimentAnalysis;
import com.project.solution.domain.diary.exception.DiaryInvalidValueException;
import com.project.solution.global.error.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiarySentimentAnalysisCommand {
    private final String diaryText;

    public DiarySentimentAnalysisCommand(String diaryText) {
        if (diaryText == null || diaryText.trim().isEmpty()) {
            throw new DiaryInvalidValueException(ErrorCode.INVALID_INPUT_VALUE);
        }
        this.diaryText = diaryText;
    }
}
