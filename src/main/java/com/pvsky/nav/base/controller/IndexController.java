package com.pvsky.nav.base.controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/index")

public class IndexController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/info")
    String info() {
        return "Hello info!";
    }
 
}