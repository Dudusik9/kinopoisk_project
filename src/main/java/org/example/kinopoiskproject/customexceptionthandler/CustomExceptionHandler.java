package org.example.kinopoiskproject.customexceptionthandler;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {
    @ExceptionHandler
    public ResponseEntity validationExceptionHandler(MethodArgumentNotValidException e ){
        Map<String, Object> body = new LinkedHashMap<>();
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getCode)
                .collect(Collectors.toList());
        body.put("errors", errors);

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

// Простейший обработчик ошибок для примера

    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public List<FieldError> validationExceptionHandler(MethodArgumentNotValidException e){
//        return e.getBindingResult().getFieldErrors();
//    }
}
