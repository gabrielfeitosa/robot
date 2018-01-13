package com.gabrielfeitosa.robot.movement.rotation;

import com.gabrielfeitosa.robot.model.Position;
import com.gabrielfeitosa.robot.movement.Movement;

public interface RotateMovement extends Movement {

    void move(Position position);
}
