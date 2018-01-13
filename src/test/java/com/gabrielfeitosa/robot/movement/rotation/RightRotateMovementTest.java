package com.gabrielfeitosa.robot.movement.rotation;

import com.gabrielfeitosa.robot.model.Orientation;
import com.gabrielfeitosa.robot.model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RightRotateMovementTest {

    @Test
    public void rotateToLeft() {
        Position position = new Position();
        new RightRotateMovement().move(position);
        assertThat(position.getPositionX()).isEqualTo(0);
        assertThat(position.getPositionY()).isEqualTo(0);
        assertThat(position.getOrientation()).isEqualTo(Orientation.EAST);
    }
}