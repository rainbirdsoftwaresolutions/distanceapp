package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;

public interface PersonFilter {
    boolean keep(Person person);
}
