package com.example.Marketplace.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.event.ObjectChangeListener;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidExceptions(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }*/

    /*
    Dev notes:
    had an issue when i was annotating the above method with @ExceptionHandler(MethodArgumentNotValidException.class).
    because ResourceEntityExceptionHandler already has a method that is annotated with the above annotation,
    Spring now had two methods with the same signature(in other words they were supposed to do the same thing
    i.e handle MethodArgumentNotValidExceptions) that it had to choose between. This ambiguity in choice
    is why it displayed the following error message:
    'Ambiguous @ExceptionHandler method mapped for [class org.springframework.web.bind.MethodArgumentNotValidException]'
    */
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        //can also use UNPROCESSABLE ENTITY, consult yousuf or umer bhai
    }
}
