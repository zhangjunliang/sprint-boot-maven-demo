package com.pvsky.nav.base.controller;
 
import com.pvsky.nav.base.repository.model.pvskynav.Test;
import com.pvsky.nav.base.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/index")

public class IndexController {

    @Autowired
    private TestService testService;
    
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/info")
    String info() {
        return "Hello info!";
    }

    @RequestMapping("/test")
    Test test() {
        return testService.getInfo(1);
    }
 
}