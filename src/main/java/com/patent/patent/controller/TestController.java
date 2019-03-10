package com.patent.patent.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configurable
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello(){
        return "hello";
    }
}
