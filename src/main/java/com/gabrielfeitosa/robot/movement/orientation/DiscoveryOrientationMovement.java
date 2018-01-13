package com.gabrielfeitosa.robot.movement.orientation;

import com.gabrielfeitosa.robot.model.Orientation;

import java.util.EnumMap;
import java.util.Map;

public final class DiscoveryOrientationMovement {

    private static Map<Orientation, OrientationMovement> movementMap = new EnumMap<>(Orientation.class);

    static {
        movementMap.put(Orientation.NORTH, new NorthOrientationMovement());
        movementMap.put(Orientation.SOUTH, new SouthOrientationMovement());
        movementMap.put(Orientation.EAST, new EastOrientationMovement());
        movementMap.put(Orientation.WEST, new WestOrientationMovement());
    }

    private DiscoveryOrientationMovement(){
        //private constructor
    }

    public static OrientationMovement discovery(Orientation orientation) {
        return movementMap.get(orientation);
    }
}
