package com.project.solution.domain.diary.application.port.out;

import com.project.solution.infra.gemini.dto.GeminiResponse;

public interface GeminiRequestPort {
    public GeminiResponse rqGeminiText(String text);
    public GeminiResponse rqGeminiTextWithImage(String text, String mimeType, String data);
}
