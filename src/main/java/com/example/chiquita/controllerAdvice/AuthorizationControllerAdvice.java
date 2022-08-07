package com.example.chiquita.controllerAdvice;

import com.example.chiquita.model.ErrorCodes;
import com.example.chiquita.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthorizationControllerAdvice {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleInvalidParams(MethodArgumentNotValidException exception){
        var fieldError = exception.getBindingResult().getFieldError();
        var fieldValue = fieldError.getField();
        var errorCode = ErrorCodes.BAD_BODY;
        if (fieldValue.equals("firstName")){
            errorCode = ErrorCodes.INVALID_FIRST_NAME;
        }
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        fieldError.getDefaultMessage(),
                        errorCode,
                        HttpStatus.BAD_REQUEST.value()
                )
        );
    }
}
