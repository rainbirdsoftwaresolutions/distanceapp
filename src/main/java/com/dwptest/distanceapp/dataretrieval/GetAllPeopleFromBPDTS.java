package com.dwptest.distanceapp.dataretrieval;

import com.dwptest.distanceapp.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GetAllPeopleFromBPDTS implements GetPeopleService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${distanceapp.getallpeopleurl}")
    private String BPDTS_URL;
    private static final List<Person> EMPTY_RESULT = Collections.emptyList();

    private Logger logger = LoggerFactory.getLogger(GetAllPeopleFromBPDTS.class);

    @Override
    public List<Person> getPeople() {

        List<Person> result;

        try {
            ResponseEntity<Person[]> response =
                    restTemplate.getForEntity(
                            BPDTS_URL,
                            Person[].class);

            if (HttpStatus.OK != response.getStatusCode()) {
                logger.error("Unexpected response from the BPDTS datasource when retrieving all users", response);
                result = EMPTY_RESULT;
            } else {
                Person[] peopleArray = response.getBody();
                result = Arrays.asList(peopleArray);
            }
        } catch (RestClientException exception) {
            logger.error("Unsuccessful call to BPDTS datasource when retrieving all users", exception);
            result = EMPTY_RESULT;
        }

        return result;
    }
}
