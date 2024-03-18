package com.example.expenseapp.exceptions;

import com.example.expenseapp.entity.ErrorObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject>handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request){
      ErrorObject errorObject=new ErrorObject();
      errorObject.setStatuscode(HttpStatus.NOT_FOUND.value());
      errorObject.setMessage(ex.getMessage());
      errorObject.setTimestamp(new Date());
      return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject>handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request){
        ErrorObject errorObject=new ErrorObject();
        errorObject.setStatuscode(HttpStatus.BAD_REQUEST.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject>handleGeneralException(Exception ex, WebRequest request){
        ErrorObject errorObject=new ErrorObject();
        errorObject.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName =((FieldError)error).getField();
            String message    =error.getDefaultMessage();
            resp.put(fieldName, message);
        });


        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(ItemAlreadyExitsException.class)
    public ResponseEntity<ErrorObject >handleItemAlreadyExitsException(ItemAlreadyExitsException ex, WebRequest request){
        ErrorObject errorObject=new ErrorObject();
        errorObject.setStatuscode(HttpStatus.CONFLICT.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.CONFLICT);

    }

}
