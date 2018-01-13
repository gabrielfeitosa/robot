package com.gabrielfeitosa.robot.movement;

import com.gabrielfeitosa.robot.exception.InvalidCommandException;
import com.gabrielfeitosa.robot.movement.orientation.ForwardOrientationMovement;
import com.gabrielfeitosa.robot.movement.rotation.LeftRotateMovement;
import com.gabrielfeitosa.robot.movement.rotation.RightRotateMovement;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiscoveryMovementTest {

    @Autowired
    private DiscoveryMovement discoveryMovement;


    @Test(expected = InvalidCommandException.class)
    public void invalidMovement() {
        discoveryMovement.discoveryMovement('A');
    }

    @Test
    public void discoveryForwardMovement() {
        Movement movement = discoveryMovement.discoveryMovement('M');
        Assertions.assertThat(movement).isOfAnyClassIn(ForwardOrientationMovement.class);
    }

    @Test
    public void discoveryRightRotateMovement() {
        Movement movement = discoveryMovement.discoveryMovement('R');
        Assertions.assertThat(movement).isOfAnyClassIn(RightRotateMovement.class);
    }

    @Test
    public void discoveryLeftRotateMovement() {
        Movement movement = discoveryMovement.discoveryMovement('L');
        Assertions.assertThat(movement).isOfAnyClassIn(LeftRotateMovement.class);
    }
}