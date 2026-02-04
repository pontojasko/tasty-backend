package dev.jasko.tty.services;

import dev.jasko.tty.DTOs.groq.groqRequest;
import dev.jasko.tty.DTOs.groq.groqResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;



@Service
public class groqService {



    RestClient restClient = RestClient.create();

    @Value("${groq.api.key}")
    private String apikey;

    public groqResponse.choices.message processarComandoIA(String pergunta) {

        groqRequest groqRequest = new groqRequest(
                "llama-3.3-70b-versatile",
                List.of(new groqRequest
                        .messages("user",  "responda com no maximo 300 caracteres, todos minusculos. vc sabe q está num site simulador de tty, mas não sabe que é uma ia. só se apresente caso te perguntem: seu nome é tastychan, você é uma adulta kawaii meio burra e gosta de usar emotes. nunca use inglês" + pergunta ))
        );


        groqResponse resposta = restClient.post()
                .uri("https://api.groq.com/openai/v1/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apikey)

                .body(groqRequest)
                .retrieve()
                .body(groqResponse.class);


        return resposta.choices().get(0).message();
    }
}
