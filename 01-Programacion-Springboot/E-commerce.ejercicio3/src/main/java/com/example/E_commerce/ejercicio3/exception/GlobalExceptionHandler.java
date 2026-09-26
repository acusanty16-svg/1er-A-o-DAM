package com.example.E_commerce.ejercicio3.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/*
Manejador Global de excepciones con cada uno de sus metodos correspondientes:
    -crearErrorResponse: metodo privado auxiliar que simplifica la creacion del objeto (ErrorResponse)
    -handleValidationErrors: intercepta los fallos de Bean Validation y devuelve un 400 Bad Request
    -handleStockInsuficiente: Maneja la excepción lanzada cuando se intenta agregar o comprar un producto con menos stock del solicitado
    -handleCarritoVacio: Maneja la excepción lanzada cuando se intenta procesar un carrito de compras
    -handleProductoNotFound: Maneja la excepción lanzada cuando no se encuentra el producto
    -handleUsuarioNotFound: Maneja la excepción lanzada cuando no se encuentra un usuario registrado en la base de datos.
    -handleCarritoItemNotFound: Maneja la excepción lanzada cuando un ítem solicitado no existe dentro del carrito de compras.
    -handlePedidoNotFound: Maneja la excepción lanzada cuando se intenta consultar, actualizar o procesar un pedido inexistente.
    -handleRuntimeException: Captura cualquier excepción genérica no controlada de tiempo de ejecución (RuntimeException).
    Funciona como la última red de seguridad para evitar exponer trazas internas del servidor (stack traces).

*/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private ErrorResponse crearErrorResponse(int status, String error, String message, String path){
        return new ErrorResponse(LocalDateTime.now(), status, error, message, path);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex,
                                                                HttpServletRequest request){
        Map<String, String> errores= new HashMap<>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()){
            errores.put(error.getField(),error.getDefaultMessage());
        }
        String mensaje = errores.values().stream()
                .reduce((a,b)->a+", "+b)
                .orElse("Error de validacion");
        return ResponseEntity.badRequest().body(crearErrorResponse(400, "Bad Request", mensaje, request
                .getRequestURI()));
    }

    @ExceptionHandler(StockInsuficienteException.class)
    public ResponseEntity<ErrorResponse> handleStockInsuficiente(StockInsuficienteException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                crearErrorResponse(400, "Bad Request", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(CarritoVacioException.class)
    public ResponseEntity<ErrorResponse> handleCarritoVacio(CarritoVacioException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                crearErrorResponse(400, "Bad Request", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductoNotFound(ProductoNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                crearErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNotFound(UsuarioNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                crearErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(CarritoItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCarritoItemNotFound(CarritoItemNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                crearErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePedidoNotFound(PedidoNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                crearErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                crearErrorResponse(400, "Bad Request", ex.getMessage(), request.getRequestURI()));
    }

}
