package com.project.solution.domain.diary.adapter.dto;

import com.project.solution.infra.gemini.dto.GeminiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DiarySentimentAnalysisResult {
    private List<GeminiResponse.Candidate> candidates;

    @Data
    public static class Candidate {
        private GeminiResponse.Content content;
        //private String finishReason;
    }

    @Data
    public static class Content {
        private List<GeminiResponse.Parts> parts;
        //private String role;

    }

    @Data
    public static class Parts {
        private String text;
    }
}
