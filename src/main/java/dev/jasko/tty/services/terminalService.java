package dev.jasko.tty.services;

import org.springframework.stereotype.Service;
import dev.jasko.tty.DTOs.terminalRequest;
import dev.jasko.tty.DTOs.terminalResponse;

@Service
public class terminalService {

    public terminalResponse processarComando(terminalRequest data) {
        String comando = data.input();
        return switch (comando){
            case "help", "ajuda" -> new terminalResponse("help: mostra ajuda");
            case "penis" -> new terminalResponse("safado");
            default -> new terminalResponse("comando não encontrado.");
        };

    }

}
