package com.project.solution.infra.gemini;

import com.project.solution.domain.diary.application.port.out.GeminiRequestPort;
import com.project.solution.infra.gemini.dto.GeminiRequest;
import com.project.solution.infra.gemini.dto.GeminiResponse;
import com.project.solution.infra.gemini.enums.AIPrompt;
import com.project.solution.infra.gemini.enums.GeminiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeminiClient implements GeminiRequestPort {

    @Value("${gemini.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public GeminiClient (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public GeminiResponse rqGeminiText(String text) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/" + GeminiModel.GEMINI_20_FLASH.getModelId() + ":generateContent?key="
                + apiKey;
        GeminiRequest geminiReqDto = new GeminiRequest(text);
        GeminiResponse geminiResDto = restTemplate.postForObject(url, geminiReqDto, GeminiResponse.class);
        return geminiResDto;
    }

    @Override
    public GeminiResponse rqGeminiTextWithImage(String text, String mimeType, String data){
        String url = "https://generativelanguage.googleapis.com/v1beta/models/" + GeminiModel.GEMINI_20_FLASH.getModelId() + ":generateContent?key="
                + apiKey;

        GeminiRequest geminiReqDto = new GeminiRequest(text, mimeType, data);
        GeminiResponse geminiResDto = restTemplate.postForObject(url, geminiReqDto, GeminiResponse.class);
        return geminiResDto;
    }

}
