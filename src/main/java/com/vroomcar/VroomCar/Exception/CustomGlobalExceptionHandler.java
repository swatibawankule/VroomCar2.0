 package com.vroomcar.VroomCar.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Let Spring BasicErrorController handle the exception, we just override the status code
//    @ExceptionHandler(ConfictException.class)
//    public void springHandleNotFound(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.CONFLICT.value());
//    }
//    
    
    @ExceptionHandler(ConfictException.class)
    public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);

    }
    
    @ExceptionHandler(RideNotPresentException.class)
    public ResponseEntity<CustomErrorResponse> RideNotPresent(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

    }
    
    @ExceptionHandler(InvalidNUmberException.class)
    public ResponseEntity<CustomErrorResponse> NumberInvalid(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.PARTIAL_CONTENT.value());

        return new ResponseEntity<>(errors, HttpStatus.PARTIAL_CONTENT);

    }
    

//    @ExceptionHandler(BookUnSupportedFieldPatchException.class)
//    public void springUnSupportedFieldPatch(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());
//    }
//
//    // @Validate For Validating Path Variables and Request Parameters
//    @ExceptionHandler(ConstraintViolationException.class)
//    public void constraintViolationException(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value());
//    }


}
