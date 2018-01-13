package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Position;
import com.gabrielfeitosa.robot.movement.Movement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForwardOrientationMovement implements Movement {

    private static final Logger LOG = LoggerFactory.getLogger(ForwardOrientationMovement.class);

    @Override
    public void move(Position position) {
        LOG.info("Moving from {}", position);
        final OrientationMovement orientationMovement = DiscoveryOrientationMovement.discovery(position.getOrientation());
        orientationMovement.move(position);
        LOG.info("Moved to {}", position);
    }
}
