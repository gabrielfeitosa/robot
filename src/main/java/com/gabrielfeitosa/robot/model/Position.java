package com.gabrielfeitosa.robot.model;

import com.gabrielfeitosa.robot.exception.InvalidPositionException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Position {

    private static final int MIN = 0;
    private static final int MAX = 5;

    private int positionX = 0;
    private int positionY = 0;
    private Orientation orientation = Orientation.NORTH;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        validateNewPosition(positionX);
        this.positionX = positionX;
    }

    private void validateNewPosition(int position) {
        if (position > MAX || position < MIN) {
            throw new InvalidPositionException();
        }
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        validateNewPosition(positionY);
        this.positionY = positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %s)", positionX, positionY, orientation.getLabel());
    }
}
