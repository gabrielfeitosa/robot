package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SouthOrientationMovementTest {

    @Test
    public void moveToNorth() {
        Position position = new Position();
        position.setPositionX(2);
        position.setPositionY(3);
        OrientationMovement movement = new SouthOrientationMovement();
        movement.move(position);
        assertThat(position.getPositionX()).isEqualTo(2);
        assertThat(position.getPositionY()).isEqualTo(2);
    }
}