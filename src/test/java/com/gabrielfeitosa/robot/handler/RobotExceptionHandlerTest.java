package com.gabrielfeitosa.robot.handler;

import com.gabrielfeitosa.robot.exception.RobotException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RobotExceptionHandlerTest {

    @InjectMocks
    private RobotExceptionHandler robotExceptionHandler;

    @Mock
    private WebRequest webRequest;

    @Test
    public void handlerRobotException(){
        ResponseEntity<Object> responseEntity = robotExceptionHandler.handleRobotException(new RobotException(), webRequest);
        assertThat(responseEntity.getBody()).isEqualTo(RobotExceptionHandler.BADREQUEST);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


}