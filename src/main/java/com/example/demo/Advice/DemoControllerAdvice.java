package com.example.demo.Advice;
/**
 * author : Sharvari Nagesh
 * Description: Controller Advice class. This handles exceptions thrown.
 *
 */

import com.example.demo.custom.Exception.WrongInputException;
import com.wrapper.spotify.exceptions.detailed.InternalServerErrorException;
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
    public ResponseEntity<String> handleNotFound(NotFoundException notFoundException) {
        System.out.println("NotFoundException raised:" + notFoundException.getMessage());
        return new ResponseEntity<String>(notFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<String> handleInternalError(InternalServerErrorException internalServerErrorExceptionError){

        return new ResponseEntity<String>(internalServerErrorExceptionError.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
