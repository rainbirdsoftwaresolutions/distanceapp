package com.dwptest.distanceapp.dataretrieval;

import com.dwptest.distanceapp.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GetPeopleFromDummySource implements GetPeopleService {

    private Person testPerson1 = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private Person testPerson2 = new Person(2, "Paul", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private Person testPerson3 = new Person(3, "George", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private Person testPerson4 = new Person(4, "Ringo", "Smith", "here@there.com", "127.0.0.1", 0, 0);

    @Override
    public List<Person> getPeople() {
        return Arrays.asList(testPerson1, testPerson2, testPerson3, testPerson4);
    }
}
