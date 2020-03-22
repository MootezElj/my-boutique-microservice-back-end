package com.targa.labs.myBoutique.auth.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthResources {

    @GetMapping("hello")
    public String hello(){
        return "hello World !";
    }
}
