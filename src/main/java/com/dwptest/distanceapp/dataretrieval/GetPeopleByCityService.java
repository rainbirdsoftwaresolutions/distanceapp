package com.dwptest.distanceapp.dataretrieval;

import com.dwptest.distanceapp.Person;

import java.util.List;

public interface GetPeopleByCityService {
    List<Person> getPeople(String cityName);
}
