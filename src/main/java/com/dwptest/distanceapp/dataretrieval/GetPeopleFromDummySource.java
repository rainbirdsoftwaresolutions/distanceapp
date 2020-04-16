package com.dwptest.distanceapp.dataretrieval;

import com.dwptest.distanceapp.Person;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class GetPeopleFromDummySource implements GetPeopleService {
    @Override
    public List<Person> getPeople() {
        return Arrays.asList(new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", BigDecimal.ZERO, BigDecimal.ZERO));
    }
}
