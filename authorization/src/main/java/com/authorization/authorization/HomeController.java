package com.authorization.authorization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/http://localhost:8080/swagger-ui/index.html")
    public String homePage() {
        return "Hello World";
    }
}
