package com.gabrielfeitosa.robot.movement.rotation;

import com.gabrielfeitosa.robot.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RightRotateMovement implements RotateMovement {

    private static final Logger LOG = LoggerFactory.getLogger(RightRotateMovement.class);

    @Override
    public void move(Position position) {
        LOG.info("Rotating from {}", position);
        position.setOrientation(position.getOrientation().getRight());
        LOG.info("Rotated to {}", position);
    }

}
