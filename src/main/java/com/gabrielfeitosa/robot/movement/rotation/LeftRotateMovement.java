package com.gabrielfeitosa.robot.movement.rotation;

import com.gabrielfeitosa.robot.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeftRotateMovement implements RotateMovement {

    private static final Logger LOG = LoggerFactory.getLogger(LeftRotateMovement.class);

    @Override
    public void move(Position position) {
        LOG.info("Rotating from {}", position);
        position.setOrientation(position.getOrientation().getLeft());
        LOG.info("Rotated to {}", position);
    }

}
