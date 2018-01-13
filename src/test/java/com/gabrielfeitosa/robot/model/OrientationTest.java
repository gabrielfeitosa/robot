package com.gabrielfeitosa.robot.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {

    @Test
    public void verifyNorthOrientation() {
        Orientation orientation = Orientation.NORTH;
        assertThat(orientation.getLabel()).isEqualTo('N');
        assertThat(orientation.getLeft()).isEqualTo(Orientation.WEST);
        assertThat(orientation.getRight()).isEqualTo(Orientation.EAST);
    }

    @Test
    public void verifyEastOrientation() {
        Orientation orientation = Orientation.EAST;
        assertThat(orientation.getLabel()).isEqualTo('E');
        assertThat(orientation.getLeft()).isEqualTo(Orientation.NORTH);
        assertThat(orientation.getRight()).isEqualTo(Orientation.SOUTH);
    }

    @Test
    public void verifySouthOrientation() {
        Orientation orientation = Orientation.SOUTH;
        assertThat(orientation.getLabel()).isEqualTo('S');
        assertThat(orientation.getLeft()).isEqualTo(Orientation.EAST);
        assertThat(orientation.getRight()).isEqualTo(Orientation.WEST);
    }

    @Test
    public void verifyWestOrientation() {
        Orientation orientation = Orientation.WEST;
        assertThat(orientation.getLabel()).isEqualTo('W');
        assertThat(orientation.getLeft()).isEqualTo(Orientation.SOUTH);
        assertThat(orientation.getRight()).isEqualTo(Orientation.NORTH);
    }

}