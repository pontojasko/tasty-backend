package dev.jasko.tty.services;

import dev.jasko.tty.DTOs.mensagemRequest;
import dev.jasko.tty.DTOs.terminalRequest;
import org.springframework.stereotype.Service;
import dev.jasko.tty.DTOs.terminalResponse;

import org.springframework.web.client.RestClient;

@Service
public class terminalService {



    RestClient restClient = RestClient.create();

    private String mensagem(){
    mensagemRequest[] json = restClient.get()
            .uri("https://api-benius.jasko.dev/mensagem")
            .retrieve()
            .body(mensagemRequest[].class);
        return json[0].texto();
    }



    public terminalResponse processarComando(terminalRequest data) {
        String comando = data.input();
        return switch (comando){
            case "benius", "b" -> new terminalResponse("alguém disse: " + mensagem());
            case "help", "ajuda", "h" -> new terminalResponse("help: lista comandos\ntasty: breve apresentação\nascii: arte bonita\nregister: registra um novo usuario\nbenius: exibe uma mensagem benius™");
            case "penis", "sexo" -> new terminalResponse("tu podia ser mais criativo no que tu escreve ne dog");
            case "ascii" -> new terminalResponse(" _____        _______   __\n|_   _|      |_   _\\ \\ / /\n  | | __ _ ___ | |  \\ V / \n  | |/ _` / __|| |   \\ /  \n  | | (_| \\__ \\| |   | |  \n  \\_/\\__,_|___/\\_/   \\_/  \n                          \n                          ");
            case "register", "login" -> new terminalResponse("Que pena! Estamos desenvolvendo essa feature :(");
            case "tasty" -> new terminalResponse("Seja bem vindo ao TasTY.\n------\nProjetei esse site com o intuito\nde aprender uns conceitos novos.\n------\nDigite 'help' para mais comandos!");
            default -> new terminalResponse("Comando não encontrado.\nDigite 'help' para comandos!");
        };

    }

}
