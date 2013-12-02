package com.gd158.Services.WebServices;

import javax.jws.WebService;

@WebService(endpointInterface = "com.gd158.Services.WebServices.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
 
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}