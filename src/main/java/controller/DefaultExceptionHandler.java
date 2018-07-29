package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice  
    public class DefaultExceptionHandler{  
 
	
    @ResponseBody    
	@ExceptionHandler(value=Exception.class)
	public String entityExceptionHandler(Exception e) {
		return "error";
	}
      
    }  