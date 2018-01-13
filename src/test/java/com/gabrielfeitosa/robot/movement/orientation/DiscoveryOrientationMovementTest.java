package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Orientation;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DiscoveryOrientationMovementTest {

    @Test
    public void discoveryNorthMovement() {
        OrientationMovement movement = DiscoveryOrientationMovement.discovery(Orientation.NORTH);
        Assertions.assertThat(movement).isOfAnyClassIn(NorthOrientationMovement.class);
    }

    @Test
    public void discoverySouthMovement() {
        OrientationMovement movement = DiscoveryOrientationMovement.discovery(Orientation.SOUTH);
        Assertions.assertThat(movement).isOfAnyClassIn(SouthOrientationMovement.class);
    }

    @Test
    public void discoveryEastMovement() {
        OrientationMovement movement = DiscoveryOrientationMovement.discovery(Orientation.EAST);
        Assertions.assertThat(movement).isOfAnyClassIn(EastOrientationMovement.class);
    }

    @Test
    public void discoveryWestMovement() {
        OrientationMovement movement = DiscoveryOrientationMovement.discovery(Orientation.WEST);
        Assertions.assertThat(movement).isOfAnyClassIn(WestOrientationMovement.class);
    }

}