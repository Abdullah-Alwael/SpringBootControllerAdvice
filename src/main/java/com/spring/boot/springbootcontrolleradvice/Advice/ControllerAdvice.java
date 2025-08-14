package com.spring.boot.springbootcontrolleradvice.Advice;


import com.spring.boot.springbootcontrolleradvice.Api.ApiException;
import com.spring.boot.springbootcontrolleradvice.Api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    // it was agreed to name the  exception methods with the same name of the exception
    // Capital letters
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiException(ApiException apiException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(apiException.getMessage()));
    }

    // we no longer need to use the (Errors errors) in the add or update Controller methods
    // , the exception handler will do it

    // copy the exceptions from the console and add them here as methods
    // what is the max number of exceptions did you catch? tell next class tomorrow

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> HttpMessageNotReadableException(HttpMessageNotReadableException
                                                                               httpMessageNotReadableException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                ApiResponse(httpMessageNotReadableException.getMessage()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException
                                                                               methodArgumentNotValidException){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                        ApiResponse(methodArgumentNotValidException.getMessage()));
    }
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiResponse> HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException
                                                                                  httpMediaTypeNotSupportedException){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                        ApiResponse(httpMediaTypeNotSupportedException.getMessage()));
    }
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<ApiResponse> NoResourceFoundException(NoResourceFoundException noResourceFoundException){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                        ApiResponse(noResourceFoundException.getMessage()));
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse> HttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException
                    httpRequestMethodNotSupportedException){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                        ApiResponse(httpRequestMethodNotSupportedException.getMessage()));
    }
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException
                                                                                   methodArgumentTypeMismatchException){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                        ApiResponse(methodArgumentTypeMismatchException.getMessage()));
    }

} // 7 Exceptions Found
