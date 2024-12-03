package com.ecom.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class CheckController {

    @GetMapping("/test")
    public String check(){
        return "ecommerce testing successfully!";
    }
}
