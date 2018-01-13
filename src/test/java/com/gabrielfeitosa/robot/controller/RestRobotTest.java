package com.gabrielfeitosa.robot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestRobotTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void movingWithRightRotations() {
        final ResponseEntity<String> stringResponseEntity = this.restTemplate.postForEntity("/mars/MMRMMRMM", null, String.class);
        assertThat(stringResponseEntity.getBody()).isEqualTo("(2, 0, S)");
    }

    @Test
    public void movingForLeft() {
        final ResponseEntity<String> stringResponseEntity = this.restTemplate.postForEntity("/mars/MML", null, String.class);
        assertThat(stringResponseEntity.getBody()).isEqualTo("(0, 2, W)");
    }

    @Test
    public void repeatMovingForLeft() {
        final ResponseEntity<String> stringResponseEntity = this.restTemplate.postForEntity("/mars/MML", null, String.class);
        assertThat(stringResponseEntity.getBody()).isEqualTo("(0, 2, W)");
    }

    @Test
    public void sendInvalidCommand() {
        final ResponseEntity<String> stringResponseEntity = this.restTemplate.postForEntity("/mars/AAA", null, String.class);
        assertThat(stringResponseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void sendInvalidPosition() {
        final ResponseEntity<String> stringResponseEntity = this.restTemplate.postForEntity("/mars/MMMMMMMMMMMMMMMMMMMMMMMM", null, String.class);
        assertThat(stringResponseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}