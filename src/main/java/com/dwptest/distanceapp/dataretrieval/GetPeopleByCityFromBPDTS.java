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
public class GetPeopleByCityFromBPDTS implements GetPeopleByCityService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${distanceapp.getpeoplebycityurl.format}")
    private String BPDTS_URL_FORMAT;
    private static final List<Person> EMPTY_RESULT = Collections.emptyList();

    private Logger logger = LoggerFactory.getLogger(GetPeopleByCityFromBPDTS.class);

    @Override
    public List<Person> getPeople(String cityName) {

        List<Person> result;

        try {
            ResponseEntity<Person[]> response =
                    restTemplate.getForEntity(
                            String.format(BPDTS_URL_FORMAT, cityName),
                            Person[].class);

            if (HttpStatus.OK != response.getStatusCode()) {
                logger.error("Unexpected response from the BPDTS datasource when retrieving users from a city", response);
                result = EMPTY_RESULT;
            } else {
                Person[] peopleArray = response.getBody();
                result = Arrays.asList(peopleArray);
            }
        } catch (RestClientException rce
        ) {
            logger.error("Unsuccessful call to BPDTS datasource when retrieving users from a city", rce);
            result = EMPTY_RESULT;
        }

        return result;
    }
}
