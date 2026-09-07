package Biblioteca.ejercicio2.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.security.access.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ErrorResponse crearErrorResponse(int status, String error, String message, String path){
        return new ErrorResponse(
                LocalDateTime.now(),
                status,
                error,
                message,
                path
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex,
                                                                HttpServletRequest request){
        Map<String, String> errores = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            errores.put(error.getField(),error.getDefaultMessage());
        }
        String mensaje = errores.values().stream()
                .reduce((a,b)->a+ ", "+b)
                .orElse("Error de validacion");
        return ResponseEntity.badRequest().body(crearErrorResponse(400, "Bad Request", mensaje, request.getRequestURI()));
    }

    @ExceptionHandler(UsuarioDuplicadoException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioDuplicado(UsuarioDuplicadoException ex,
                                                                HttpServletRequest request){
        return ResponseEntity.badRequest().body(crearErrorResponse(400, "Bad Request", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(CredencialesInvalidasException.class)
    public ResponseEntity<ErrorResponse> handleCredencialesInvalidas(CredencialesInvalidasException ex,
                                                                     HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(crearErrorResponse(401, "Unauthorized"
        ,ex.getMessage(),request.getRequestURI()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNotFound(UsernameNotFoundException ex,
                                                               HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(crearErrorResponse(401, "Unauthorized"
        ,ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException ex,
                                                                       HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(crearErrorResponse(401, "Unauthorized"
                ,ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(crearErrorResponse(403, "Forbidden"
        ,"No tienes permisos para acceder a este recurso", request.getRequestURI()));
    }

    @ExceptionHandler(LibroNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLibroNotFound(LibroNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(crearErrorResponse(404, "Not Found",
                ex.getMessage(),request.getRequestURI()));
    }
    @ExceptionHandler(PrestamoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePrestamoNotFound(
            PrestamoNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                crearErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI())
        );
    }

    @ExceptionHandler(AutorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAutorNotFound(
            AutorNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                crearErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI())
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, HttpServletRequest request){
        return ResponseEntity.badRequest().body(crearErrorResponse(400, "Bad Request", ex.getMessage(),
                request.getRequestURI()));
    }
}
