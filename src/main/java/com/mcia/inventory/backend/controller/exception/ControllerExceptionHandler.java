package com.mcia.inventory.backend.controller.exception;


import com.mcia.inventory.backend.controller.dto.ErrorMessage;
import com.mcia.inventory.backend.service.exception.InvalidRequestException;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.hql.internal.ast.ErrorReporter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static String DEFAULT_REASON = "unknown reason";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidRequestException.class, PropertyReferenceException.class})
    public final ResponseEntity<ErrorMessage> handleInvalidRequestException(RuntimeException exception) {
        log.warn("Bad request: {}", exception.getMessage());
        ErrorMessage error = ErrorMessage.badRequest(exception.getMessage().isEmpty()? DEFAULT_REASON: exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException exception) {
        log.warn("resource not found: {}", exception.getMessage());
        ErrorMessage error = ErrorMessage.notFound(exception.getMessage().isEmpty()? DEFAULT_REASON: exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<ErrorMessage> handleDataAcessException(DataIntegrityViolationException exception) {
        log.warn("Integrity violation: {}", exception.getMessage());
        ErrorMessage error = ErrorMessage.conflict(exception.getMessage().isEmpty()? DEFAULT_REASON: exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException exception) {
        log.warn("Internal error", exception);
        ErrorMessage error = ErrorMessage.internal(exception.getMessage().isEmpty()? DEFAULT_REASON: exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
