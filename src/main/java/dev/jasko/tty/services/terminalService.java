package dev.jasko.tty.services;

import dev.jasko.tty.DTOs.*;
import dev.jasko.tty.DTOs.terminal.terminalRequest;
import dev.jasko.tty.DTOs.terminal.terminalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class terminalService {

    RestClient restClient = RestClient.create();

    @Autowired
    private groqService groqService;


    private String mensagembenius(){
    mensagemRequest[] json = restClient.get()
            .uri("https://api-benius.jasko.dev/mensagem")
            .retrieve()
            .body(mensagemRequest[].class);
        return json[0].texto();
    }


    public terminalResponse processarComando(terminalRequest data) {
        String comando = data.input();

        if (comando.startsWith("ia")){
            String resto = comando.substring(2);

            if (resto.isEmpty()){
                return new terminalResponse("Digite algo como: 'ia prompt'");
            }
            return new terminalResponse(groqService.processarComandoIA(resto).content());
        }


        return switch (comando){
            case "benius", "b" -> new terminalResponse("alguém disse: " + mensagembenius());
            case "help", "ajuda", "h" -> new terminalResponse("help: lista comandos\ntasty: breve apresentação\nascii: arte bonita\nregister: registra um novo usuario\nbenius: exibe uma mensagem benius™\nia: conversa poderosa!");
            case "penis", "sexo" -> new terminalResponse("tu podia ser mais criativo no que tu escreve ne dog");
            case "ascii" -> new terminalResponse(" _____        _______   __\n|_   _|      |_   _\\ \\ / /\n  | | __ _ ___ | |  \\ V / \n  | |/ _` / __|| |   \\ /  \n  | | (_| \\__ \\| |   | |  \n  \\_/\\__,_|___/\\_/   \\_/  \n                          \n                          ");
            case "register", "login" -> new terminalResponse("Que pena! Estamos desenvolvendo essa feature :(");
            case "tasty" -> new terminalResponse("Seja bem vindo ao TasTY.\n------\nProjetei esse site com o intuito de aprender uns conceitos novos.\n------\nDigite 'help' para mais comandos!");
            default -> new terminalResponse("Comando não encontrado.\nDigite 'help' para comandos!");
        };



    }

}
