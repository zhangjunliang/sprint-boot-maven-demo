package com.pvsky.nav.base.bean;

import org.springframework.stereotype.Component;

@Component
public class DemoParam
{
    String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}