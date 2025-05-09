package com.project.solution.infra.gemini.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GeminiRequest {  // Gemini API 요청을 위한 DTO 클래스 정의

    private List<Content> contents;
    public GeminiRequest(String text) {
        contents = new ArrayList<>();
        Content content = new Content(text);
        contents.add(content);
    }

    public GeminiRequest(String text, String mimeType, String data) {
        contents = new ArrayList<>();
        Content content = new Content(text, mimeType, data);
        contents.add(content);
    }

    @Getter
    @Setter
    public class Content {
        private List<Part> parts;
        public Content(String text) {
            parts = new ArrayList<>();
            Part part = new Part(text);
            parts.add(part);
        }

        public Content(String text, String mimeType, String data) {
            parts = new ArrayList<>();
            Part part = new Part(text);
            Part part1 = new Part(mimeType, data);
            parts.add(part);
            parts.add(part1);
        }

        @Getter
        @Setter
        public class Part {
            private String text;
            private InlineData inline_data;

            public Part(String text){
                this.text = text;
                this.inline_data = null;
            }

            public Part(String mimeType, String data){
                this.text = null;
                InlineData inlineData = new InlineData();
                inlineData.setMime_type(mimeType);
                inlineData.setData(data);
                this.inline_data = inlineData;
            }

            @Getter
            @Setter
            public class InlineData {
                private String mime_type;
                private String data;
            }


        }
    }

}
