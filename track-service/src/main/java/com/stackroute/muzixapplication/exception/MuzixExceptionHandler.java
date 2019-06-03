package com.stackroute.muzixapplication.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MuzixExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getMessage(), HttpStatus.CONFLICT);
    }

    /*public String handleTrackAlreadyExistsException(TrackAlreadyExistsException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    public String handleIdNotFoundException(IdNotFoundException e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public String handleTrackNotFoundException(TrackNotFoundException ex) {
        return ex.getMessage();
    }*/
}
