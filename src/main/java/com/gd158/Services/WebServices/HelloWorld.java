package com.gd158.Services.WebServices;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}