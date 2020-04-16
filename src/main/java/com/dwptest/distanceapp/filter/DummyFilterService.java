package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyFilterService implements FilterPeopleService {
    @Override
    public List<Person> filter(List<Person> peopleToFilter) {
        return peopleToFilter;
    }
}
