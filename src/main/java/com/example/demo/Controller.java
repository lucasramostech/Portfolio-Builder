package com.example.demo;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Portfolio Builder!", HttpStatus.OK);
    }

    @PostMapping("/api/hello")
    public ResponseEntity<DatasRequest> receberDados(@RequestBody DatasRequest request) {

        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}