package com.gabrielfeitosa.robot.movement.rotation;

import com.gabrielfeitosa.robot.model.Orientation;
import com.gabrielfeitosa.robot.model.Position;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeftRotateMovementTest {

    @Test
    public void rotateToLeft() {
        Position position = new Position();
        new LeftRotateMovement().move(position);
        Assertions.assertThat(position.getPositionX()).isEqualTo(0);
        Assertions.assertThat(position.getPositionY()).isEqualTo(0);
        Assertions.assertThat(position.getOrientation()).isEqualTo(Orientation.WEST);
    }
}