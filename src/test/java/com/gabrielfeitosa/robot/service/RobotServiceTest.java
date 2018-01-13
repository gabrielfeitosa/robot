package com.gabrielfeitosa.robot.service;

import com.gabrielfeitosa.robot.exception.InvalidCommandException;
import com.gabrielfeitosa.robot.model.Position;
import com.gabrielfeitosa.robot.movement.DiscoveryMovement;
import com.gabrielfeitosa.robot.movement.Movement;
import com.gabrielfeitosa.robot.validators.Validator;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyChar;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RobotServiceTest {

    @InjectMocks
    private RobotService robotService;
    @Mock
    private Validator parseCommandValidator;
    @Mock
    private DiscoveryMovement discoveryMovement;
    @Mock
    private Movement movement;
    @Mock
    private ApplicationContext context;


    @Test(expected = InvalidCommandException.class)
    public void invalidCommand() {
        String command = "XXX";
        given(parseCommandValidator.validate(command)).willReturn(false);
        robotService.sendCommand(command);
    }

    @Test(expected = InvalidCommandException.class)
    public void nullCommand() {
        given(parseCommandValidator.validate(null)).willReturn(false);
        robotService.sendCommand(null);
    }

    @Test
    public void sendCommandSucess() {
        String command = "MMR";
        given(parseCommandValidator.validate(command)).willReturn(true);
        given(discoveryMovement.discoveryMovement(anyChar())).willReturn(movement);
        given(context.getBean(Position.class)).willReturn(new Position());
        String response = robotService.sendCommand(command);
        verify(movement, times(3)).move(Matchers.any(Position.class));
        Assertions.assertThat(response).isEqualTo("(0, 0, N)");
    }
}