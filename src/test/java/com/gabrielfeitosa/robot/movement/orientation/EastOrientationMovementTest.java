package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Position;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EastOrientationMovementTest {

    @Test
    public void moveToEast() {
        Position position = new Position();
        OrientationMovement movement = new EastOrientationMovement();
        movement.move(position);
        assertThat(position.getPositionX()).isEqualTo(1);
        assertThat(position.getPositionY()).isEqualTo(0);
    }
}