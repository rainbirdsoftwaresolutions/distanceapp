package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;

import java.util.List;

public interface FilterPeopleService {
    List<Person> filter(List<Person> peopleToFilter);
}
