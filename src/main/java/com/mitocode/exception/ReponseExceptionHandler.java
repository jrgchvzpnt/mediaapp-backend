package com.mitocode.exception;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ReponseExceptionHandler {

     @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        CustomErrorResponse err = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

     /*@ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorRecord> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        CustomErrorRecord err = new CustomErrorRecord(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }*/


    // solo para Spring Boot 3 
   /*  @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
        pd.setTitle("Model Not Found Exception");
        pd.setType(URI.create(request.getDescription(false)));
        pd.setProperty("AtributoExtra", "Atributo");;

        return pd;
    }*/

    // solo para Spring Boot 3 
    /*@ExceptionHandler(ModelNotFoundException.class)
    public ErrorResponse handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){

        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage())
        .title("Model NOT FOUND")
        .type(URI.create(request.getDescription(false)))
        .property("Extra", "Extra2")
        .build();
    }*/

}
