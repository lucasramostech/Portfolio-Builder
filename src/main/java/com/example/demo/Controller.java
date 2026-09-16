package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class Controller {

    private final MainService mainService;

    public Controller(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/api/hello")
    public ResponseEntity<ResultadoInvestimento> receberDados(@RequestBody DatasRequest request) {

        ResultadoInvestimento resultado = mainService.calcularTudo(
            request.getCapitalInicial(),
            request.getAporteMensal(),
            request.getAtivos()
        );
 

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}