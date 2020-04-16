package com.dwptest.distanceapp.dataretrieval;

import com.dwptest.distanceapp.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GetPeopleByCityFromDummySource implements GetPeopleService {

    private Person testPerson1 = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 0, 0);

    @Override
    public List<Person> getPeople() {
        return Arrays.asList(testPerson1);
    }
}
