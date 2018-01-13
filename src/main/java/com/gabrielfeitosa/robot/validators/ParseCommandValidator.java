package com.gabrielfeitosa.robot.validators;

import com.gabrielfeitosa.robot.exception.InvalidCommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ParseCommandValidator implements Validator{

    private static final Logger LOG = LoggerFactory.getLogger(ParseCommandValidator.class);

    private static final String COMMAND_FORMAT = "^[MLR]+$";

    public boolean validate(String command){
        final boolean matches = Optional.ofNullable(command)
                .orElseThrow(InvalidCommandException::new)
                .matches(COMMAND_FORMAT);
        LOG.info("Command {} valid? {}", command, matches);
        return matches;
    }
}
