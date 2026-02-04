package dev.jasko.tty.DTOs.groq;

import java.util.List;

public record groqResponse(List<choices> choices) {
    public record choices(message message) {
        public record message(String content) {

        }
    }
}
