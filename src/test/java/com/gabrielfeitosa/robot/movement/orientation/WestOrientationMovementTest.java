package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WestOrientationMovementTest {

    @Test
    public void moveToNorth() {
        Position position = new Position();
        position.setPositionX(4);
        position.setPositionY(2);
        OrientationMovement movement = new WestOrientationMovement();
        movement.move(position);
        assertThat(position.getPositionX()).isEqualTo(3);
        assertThat(position.getPositionY()).isEqualTo(2);
    }
}