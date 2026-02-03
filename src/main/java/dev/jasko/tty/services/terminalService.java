package dev.jasko.tty.services;

import org.springframework.stereotype.Service;
import dev.jasko.tty.DTOs.terminalRequest;
import dev.jasko.tty.DTOs.terminalResponse;

@Service
public class terminalService {

    public terminalResponse processarComando(terminalRequest data) {
        String comando = data.input();
        return switch (comando){
            case "help", "ajuda" -> new terminalResponse("help: lista comandos\ntasty: breve apresentação\nascii: arte bonita\nregister: registra um novo usuario");
            case "penis" -> new terminalResponse("tu podia ser mais criativo no que tu escreve ne dog");
            case "ascii" -> new terminalResponse(" _____        _______   __\n|_   _|      |_   _\\ \\ / /\n  | | __ _ ___ | |  \\ V / \n  | |/ _` / __|| |   \\ /  \n  | | (_| \\__ \\| |   | |  \n  \\_/\\__,_|___/\\_/   \\_/  \n                          \n                          ");
            case "register" -> new terminalResponse("Que pena! Estamos desenvolvendo essa feature :(");
            case "tasty" -> new terminalResponse("Seja bem vindo ao TasTY.\n------\nProjetei esse site com o intuito\nde aprender uns conceitos novos.\n------\nDigite 'help' para mais comandos!");
            default -> new terminalResponse("Comando não encontrado.\nDigite 'help' para comandos!");
        };

    }

}
