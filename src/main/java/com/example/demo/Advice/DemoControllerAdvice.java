package com.example.demo.Advice;

import com.example.demo.custom.Exception.WrongInputException;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoControllerAdvice {

    @ExceptionHandler(WrongInputException.class)
    public ResponseEntity<String> handleWrongInput(WrongInputException wrongInputException){
        System.out.println("Wrong Input Exception raised:" + wrongInputException.toString());
        return new ResponseEntity<String>(wrongInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException notFoundException){
        return new ResponseEntity<String>(notFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception exception){
//        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
