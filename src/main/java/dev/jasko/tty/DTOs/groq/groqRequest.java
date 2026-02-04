package dev.jasko.tty.DTOs.groq;

import java.util.List;

public record groqRequest(String model, List<messages> messages) {
    public record messages(String role, String content){}
}
