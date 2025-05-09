package com.project.solution.infra.gemini.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeminiModel {
    GEMINI_15_PRO("gemini-1.5-pro", "일반 모델"),
    GEMINI_20_FLASH("gemini-2.0-flash", "일반 모델"),
    GEMINI_25_PRO_PREVIEW("gemini-2.5-pro-preview-03-25", "이미지 검색도 가능. 유료"),
    GEMINI_15_FLASH("gemini-1.5-flash", "1.5 플래시 모델");

    private final String modelId;
    private final String description;
}
