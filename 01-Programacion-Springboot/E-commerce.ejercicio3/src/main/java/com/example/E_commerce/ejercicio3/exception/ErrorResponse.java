package com.example.E_commerce.ejercicio3.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
DTO para definir la estructura del cuerpo JSON de la respuesta cada vez que la API devuelva un error:
    -timestamp: La fecha y hora exacta en que ocurrió el problema.
    -status: El código de estado HTTP en formato numérico (ej. `400`).
    -error: La descripción del código de estado HTTP (ej. `"Bad Request"`).
    -message: El mensaje descriptivo con la causa real del fallo (ej. "El stock del producto es insuficiente").
    -path: La URI/Ruta del endpoint que el cliente intentó consumir (ej. `/api/pedidos`).
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
