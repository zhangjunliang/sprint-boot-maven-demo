package com.pvsky.nav.base.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.pvsky.nav.base.bean.DemoParam;
import com.pvsky.nav.base.repository.model.pvskynav.Test;
import com.pvsky.nav.base.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/index")

public class IndexController {

    @Autowired
    private TestService testService;
    private String name;
    
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

    @RequestMapping("/index")
    String index() {
        return "hello world";
    }

    //接收参数常用方式
    //get参数
    @GetMapping("/demo/get/{id}")
    String demoGet(@PathVariable(name = "id") Integer id,@RequestParam(name = "name") String name) {
        return "id="+id+"&name="+name;
    }
    //post body json
    @PostMapping("/demo/post1")
    String demoPost1(@RequestBody Map<String, String> param) {
        return param.get("name");
    }
    
    @PostMapping("/demo/post2")
    String demoPost2(@RequestBody DemoParam param) {
        return param.getName();
    }
    //post form-data
    @PostMapping("/demo/post3")
    String demoPost3(DemoParam param) {
        return param.getName();
    }

    //header cookie token
    @GetMapping("/demo/header1")
    String demoHeader1(@RequestHeader(name = "token") String token,
            @CookieValue(name = "name") String name) {
         return "token="+token+"&name="+name;
    }
    
    @GetMapping("/demo/header2")
    String demoHeader2(HttpServletRequest request) {
        String token = request.getHeader("token");
        String result;
        result = "token="+token;
        for (Cookie cookie : request.getCookies()) {
            if ("name".equals(cookie.getName())) {
                this.name = cookie.getValue();
            }
        }
        return result+"&name="+this.name;
    }
}