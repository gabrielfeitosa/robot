package com.gabrielfeitosa.robot.model;

import com.gabrielfeitosa.robot.exception.InvalidPositionException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void verifyInitialPosition(){
        Position position = new Position();
        assertThat(position.getOrientation()).isEqualTo(Orientation.NORTH);
        assertThat(position.getPositionX()).isEqualTo(0);
        assertThat(position.getPositionY()).isEqualTo(0);
    }

    @Test(expected = InvalidPositionException.class)
    public void verifyValidationInvalidMaxPositionX(){
        Position position = new Position();
        position.setPositionX(6);
    }

    @Test(expected = InvalidPositionException.class)
    public void verifyValidationInvalidMinPositionX(){
        Position position = new Position();
        position.setPositionX(-1);
    }

    @Test(expected = InvalidPositionException.class)
    public void verifyValidationInvalidMaxPositionY(){
        Position position = new Position();
        position.setPositionY(7);
    }

    @Test(expected = InvalidPositionException.class)
    public void verifyValidationInvalidMinPositionY(){
        Position position = new Position();
        position.setPositionY(-6);
    }

    @Test
    public void verifyChangePosition(){
        Position position = new Position();
        position.setPositionX(1);
        position.setPositionY(2);
        position.setOrientation(Orientation.SOUTH);

        assertThat(position.getPositionX()).isEqualTo(1);
        assertThat(position.getPositionY()).isEqualTo(2);
        assertThat(position.getOrientation()).isEqualTo(Orientation.SOUTH);
        assertThat(position.toString()).isEqualTo("(1, 2, S)");
    }

}