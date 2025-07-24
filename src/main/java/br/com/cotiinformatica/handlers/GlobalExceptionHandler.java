package br.com.cotiinformatica.handlers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException exception,
            WebRequest request) {

        var erros = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> "Campo: '" + error.getField() + "' : " + error.getDefaultMessage())
                .collect(Collectors.toList());

        var body = new HashMap<String, Object>();
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("erros", erros);
        body.put("data-hora", LocalDateTime.now().format(FORMATTER));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleArgumentException(IllegalArgumentException exception,
            WebRequest request) {

        var body = new HashMap<String, Object>();
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("erro", exception.getMessage());
        body.put("data-hora", LocalDateTime.now().format(FORMATTER));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
