package com.gabrielfeitosa.robot.service;

import com.gabrielfeitosa.robot.exception.InvalidCommandException;
import com.gabrielfeitosa.robot.model.Position;
import com.gabrielfeitosa.robot.movement.DiscoveryMovement;
import com.gabrielfeitosa.robot.validators.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    private static final Logger LOG = LoggerFactory.getLogger(RobotService.class);

    private ApplicationContext applicationContext;
    private Validator parseCommandValidator;
    private DiscoveryMovement discoveryMovement;

    public RobotService(ApplicationContext applicationContext, Validator parseCommandValidator, DiscoveryMovement discoveryMovement) {
        this.applicationContext = applicationContext;
        this.parseCommandValidator = parseCommandValidator;
        this.discoveryMovement = discoveryMovement;
    }

    public String sendCommand(String command) {
        LOG.info("Validating command {}", command);
        if(!parseCommandValidator.validate(command)){
            throw new InvalidCommandException();
        }
        Position position = applicationContext.getBean(Position.class);
        for (int i = 0; i < command.length(); i++) {
            LOG.info("Movement type {}", command.charAt(i));
            discoveryMovement.discoveryMovement(command.charAt(i))
                    .move(position);
        }
        return position.toString();
    }
}
