package com.gabrielfeitosa.robot.controller;

import com.gabrielfeitosa.robot.service.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mars")
public class RobotController {

    private static final Logger LOG = LoggerFactory.getLogger(RobotController.class);

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/{command}")
    public ResponseEntity<String> command(@PathVariable("command") String command){
        LOG.info("Command received {}", command);
        String position = robotService.sendCommand(command);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }
}
