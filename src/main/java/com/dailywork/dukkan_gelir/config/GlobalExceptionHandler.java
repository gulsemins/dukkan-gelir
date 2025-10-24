package com.dailywork.dukkan_gelir.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        String message = ex.getMessage();

        // Gelen hata mesajına göre hangi alana ait olduğunu belirliyoruz.
        if (message.contains("Username already exists")) {
            // Frontend'in anlayacağı şekilde, alan adıyla birlikte hata mesajını koyuyoruz.
            errorResponse.put("username", "Bu kullanıcı adı zaten kullanılıyor.");
        } else if (message.contains("Email already exists")) {
            errorResponse.put("email", "Bu e-posta adresi zaten kayıtlı.");
        } else {
            // Diğer beklenmedik IllegalArgumentException'lar için genel bir hata
            errorResponse.put("general", message);
        }


        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}