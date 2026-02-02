package dev.jasko.tty.controllers;

import dev.jasko.tty.DTOs.terminalResponse;
import dev.jasko.tty.services.terminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.jasko.tty.DTOs.terminalRequest;

@CrossOrigin
@RestController
@RequestMapping("terminal")



public class terminalController {

    @Autowired
    private terminalService service;

//    @PostMapping
//    public ResponseEntity String resposta = service.processarComando(data);post(@RequestBody terminalRequest data){
//        service.comandos(data);
//        terminalRequest resul
//        return null;tado = service.comandos(data);
//        return ResponseEntity.ok(resultado);
//    }

    @PostMapping
    public ResponseEntity post(@RequestBody terminalRequest data){
        var resposta = service.processarComando(data);
        return ResponseEntity.ok(resposta);
    }



}
