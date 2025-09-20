package br.com.orbitall.hackathon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/") // <-- Mapeia para a raiz do site: http://localhost:8080/
    public String welcome() {
        return "API do Hackathon Orbitall 2025 está no ar!";
    }

}