package com.project.solution.infra.gemini.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeminiResponse {
    private List<Candidate> candidates;

    @Data
    public static class Candidate {
        private Content content;
        //private String finishReason;
    }

    @Data
    public static class Content {
        private List<Parts> parts;
        //private String role;

    }

    @Data
    public static class Parts {
        private String text;
    }
}