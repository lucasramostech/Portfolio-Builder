package com.example.demo; 

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 


// Tags
@SpringBootApplication 
public class Main {
    public static void main(String[] args) { 
        
        // COnfig do env
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(entry -> 
            System.setProperty(entry.getKey(), entry.getValue())
        );

        SpringApplication.run(Main.class, args); 
    }     
}