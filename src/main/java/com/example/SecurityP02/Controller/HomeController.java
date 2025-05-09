package com.example.SecurityP02.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String welcome(){
        return "Hello sir Welcome to our office";
    }
    @GetMapping("/user")
    public String User(){
        return "Hello user ...";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Hello admin ....";
    }
}
