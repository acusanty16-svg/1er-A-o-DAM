package com.example.ejercicio1_hola_mundo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Manejador global de errores para todos los controladores.
 * Captura las excepciones y las convierte en respuestas JSON limpias.
 * Sin esto, Spring devolvería errores feos con stack traces internos.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Cuando el cliente busca un producto que no existe
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProductoNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // Cuando el cliente envía datos inválidos (nombre vacío, precio negativo, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();
        ErrorResponse error = new ErrorResponse("Errores de validación: " + errores);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
