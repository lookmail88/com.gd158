package com.gd158.Services.WebServices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://WebServices.Services.gd158.com/", portName = "SayHelloPort", serviceName = "SayHelloService")
public class SayHello
{
    @WebMethod(operationName = "sayHello", action = "urn:SayHello")
	@RequestWrapper(className = "com.gd158.Services.WebServices.jaxws.SayHello", localName = "sayHello", targetNamespace = "http://WebServices.Services.gd158.com/")
	@ResponseWrapper(className = "com.gd158.Services.WebServices.jaxws.SayHelloResponse", localName = "sayHelloResponse", targetNamespace = "http://WebServices.Services.gd158.com/")
	@WebResult(name = "return")
	public String sayHello(@WebParam(name = "arg0") String name)
    {
        return "Hello " ;
    }
}
