package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class NorthOrientationMovement implements OrientationMovement{

    private static final Logger LOG = LoggerFactory.getLogger(NorthOrientationMovement.class);

    @Override
    public void move(Position position) {
        LOG.info("Moving from {}", position);
        position.setPositionY(position.getPositionY()+1);
        LOG.info("Moved to {}", position);
    }
}
