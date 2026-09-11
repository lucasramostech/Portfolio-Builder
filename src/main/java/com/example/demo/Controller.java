package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class Controller {

    private final ApiRequest apiRequest;

    public Controller(ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Portfolio Builder!", HttpStatus.OK);
    }

    @PostMapping("/api/hello")
    public ResponseEntity<String> receberDados(@RequestBody DatasRequest request) {

       
        List<Map<String, Object>> ativos = request.getAtivos();
        String result = apiRequest.buscarHistoricoMensal();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}