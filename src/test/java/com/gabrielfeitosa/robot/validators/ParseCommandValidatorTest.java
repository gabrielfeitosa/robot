package com.gabrielfeitosa.robot.validators;

import com.gabrielfeitosa.robot.exception.InvalidCommandException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseCommandValidatorTest {

    private ParseCommandValidator parseCommandValidator;

    @Before
    public void setUp(){
        parseCommandValidator = new ParseCommandValidator();
    }

    @Test(expected = InvalidCommandException.class)
    public void validateNullCommand() {
        parseCommandValidator.validate(null);
    }

    @Test
    public void validateInvalidCommands() {
        assertThat(parseCommandValidator.validate("")).isFalse();
        assertThat(parseCommandValidator.validate(" ")).isFalse();
        assertThat(parseCommandValidator.validate(" MML")).isFalse();
        assertThat(parseCommandValidator.validate("MMR ")).isFalse();
        assertThat(parseCommandValidator.validate("MMMRMMMLAAAAAA")).isFalse();
        assertThat(parseCommandValidator.validate("AAAAAA")).isFalse();
    }

    @Test
    public void validateCommand() {
        assertThat(parseCommandValidator.validate("MML")).isTrue();
        assertThat(parseCommandValidator.validate("L")).isTrue();
        assertThat(parseCommandValidator.validate("MMRMMRMM")).isTrue();
        assertThat(parseCommandValidator.validate("MMMMMMMMMMMMMMMMMMMMMMMM")).isTrue();
    }

}