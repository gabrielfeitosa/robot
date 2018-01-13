package com.gabrielfeitosa.robot.handler;

import com.gabrielfeitosa.robot.exception.RobotException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RobotExceptionHandler extends ResponseEntityExceptionHandler {

    static final String BADREQUEST = "400 Bad Request";

    @ExceptionHandler(value = { RobotException.class })
    protected ResponseEntity<Object> handleRobotException(RobotException ex, WebRequest request) {
        return handleExceptionInternal(ex, BADREQUEST,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}