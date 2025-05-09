package com.project.solution.infra.gemini.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeminiMimeType {
    JPEG("image/jpeg"),
    JPG("image/jpeg"),
    PNG("image/png"),
    WEBP("image/webp"),
    HEIC("image/heic"),
    HEIF("image/heif"),
    GIF("image/gif"),
    SVG("image/svg+xml"),
    TIFF("image/tiff"),
    TIF("image/tiff"),
    BMP("image/bmp"),
    ICO("image/x-icon"),
    AVIF("image/avif"),
    APNG("image/apng");

    private final String value;
}
