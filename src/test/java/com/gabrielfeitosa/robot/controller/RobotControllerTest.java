package com.gabrielfeitosa.robot.controller;

import com.gabrielfeitosa.robot.exception.RobotException;
import com.gabrielfeitosa.robot.service.RobotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RobotControllerTest {

    @InjectMocks
    private RobotController robotController;

    @Mock
    private RobotService robotService;

    @Test
    public void sendCommand(){
        String command = "MML";
        String response = "(0, 2, W)";
        given(robotService.sendCommand(command)).willReturn(response);
        assertThat(robotController.command(command).getBody()).isEqualTo(response);
    }

    @Test(expected = RobotException.class)
    public void sendInvalidCommand(){
        String command = "SSSS";
        given(robotService.sendCommand(command)).willThrow(new RobotException());
        robotController.command(command);
    }
}