package com.gabrielfeitosa.robot.movement.rotation;

import com.gabrielfeitosa.robot.model.Orientation;
import com.gabrielfeitosa.robot.model.Position;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RotateMovementTest {

    @Test
    public void moveDefault() {
        Position position = new Position();
        new LeftRotateMovement().move(position);
        Assertions.assertThat(position.getOrientation()).isEqualTo(Orientation.WEST);
    }
}