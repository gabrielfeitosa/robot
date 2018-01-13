package com.gabrielfeitosa.robot.movement;

import com.gabrielfeitosa.robot.exception.InvalidCommandException;
import com.gabrielfeitosa.robot.movement.orientation.ForwardOrientationMovement;
import com.gabrielfeitosa.robot.movement.rotation.LeftRotateMovement;
import com.gabrielfeitosa.robot.movement.rotation.RightRotateMovement;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class DiscoveryMovement {

    private Map<Character, Movement> movementMap = new HashMap<>();

    @PostConstruct
    private void init(){
        movementMap.put('M', new ForwardOrientationMovement());
        movementMap.put('R', new RightRotateMovement());
        movementMap.put('L', new LeftRotateMovement());
    }

    public Movement discoveryMovement(char type){
        return Optional.ofNullable(movementMap.get(type)).orElseThrow(InvalidCommandException::new);
    }

}
