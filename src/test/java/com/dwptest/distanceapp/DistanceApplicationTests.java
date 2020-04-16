package com.dwptest.distanceapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DistanceApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DistanceAppController controller;

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    public void confirmThatTheApplicationCanStartAndRetrievesUsers() {
        ResponseEntity<Person[]> response =
                restTemplate.getForEntity(
                        "http://localhost:" + port + "/users",
                        Person[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(9, response.getBody().length);
    }
}
