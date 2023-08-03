package com.hcaglar.mmwa.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {GET, POST, PUT})
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
