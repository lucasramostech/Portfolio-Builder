package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    private final ApiRequest apiRequest;
    private final SalvarDados salvarDados;

    public Controller(ApiRequest apiRequest, SalvarDados salvarDados) {
        this.apiRequest = apiRequest;
        this.salvarDados = salvarDados;
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Portfolio Builder!", HttpStatus.OK);
    }

    @PostMapping("/api/hello")
    public ResponseEntity<Map<String, Object>> receberDados(@RequestBody DatasRequest request) {

    
        Map<String, Object> result = apiRequest.buscarHistoricoMensal();

        try {
            salvarDados.salvarHistoricoMensal(result);
        } catch (DataAccessException e) {
            System.err.println("Nao foi possivel salvar o historico no banco: " + e.getMessage());
        }


        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}