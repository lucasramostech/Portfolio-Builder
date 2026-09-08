package com.example.demo;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
public class Controller {

    @GetMapping({"/", "/api/hello"})
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Portfolio Builder!", HttpStatus.OK);
    }

    

}