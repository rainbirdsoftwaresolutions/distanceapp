package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsInGetCityUsersResultsFilterTest {

    private final Person testPerson1 = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private final Person testPerson2 = new Person(2, "Paul", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private final Person testPerson3 = new Person(3, "George", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private final Person testPerson4 = new Person(4, "Ringo", "Smith", "here@there.com", "127.0.0.1", 0, 0);

    private final IsInGetCityUsersResultsFilter filter = new IsInGetCityUsersResultsFilter(Arrays.asList(testPerson1, testPerson2, testPerson3));

    @Test
    public void confirmSimpleContainsFilterWorks() {
        assertTrue(filter.keep(testPerson1));
        assertTrue(filter.keep(testPerson2));
        assertTrue(filter.keep(testPerson3));
        assertFalse(filter.keep(testPerson4));
    }

}