package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Position;
import com.gabrielfeitosa.robot.movement.Movement;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ForwardOrientationMovementTest {

    @Test
    public void moveForward() {
        Movement movement = new ForwardOrientationMovement();
        Position position = new Position();
        movement.move(position);
        Assertions.assertThat(position.toString()).isEqualTo("(0, 1, N)");
    }
}