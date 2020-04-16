package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;

import java.util.List;

public class IsInGetCityUsersResultsFilter implements PersonFilter {
    private List<Person> cityPersonList;

    public IsInGetCityUsersResultsFilter(List<Person> cityPersonList) {
        this.cityPersonList = cityPersonList;
    }

    @Override
    public boolean keep(Person person) {
        return cityPersonList.contains(person);
    }
}
