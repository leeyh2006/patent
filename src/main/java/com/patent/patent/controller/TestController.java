package com.patent.patent.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "test controller")
@RestController
@RequestMapping(value = "/api")
public class TestController {

    @ApiOperation(value = "test controller")
    @GetMapping("/test")
    public String hello(){
        return "hello";
    }
}
