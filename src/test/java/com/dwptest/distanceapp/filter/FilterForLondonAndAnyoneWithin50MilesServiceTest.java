package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;
import com.dwptest.distanceapp.dataretrieval.GetPeopleByCityService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterForLondonAndAnyoneWithin50MilesServiceTest {

    private final Person londonPerson1 = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private final Person londonPerson2 = new Person(2, "Paul", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private final Person personWithLondonCoordinates = new Person(3, "Paul", "Smith", "here@there.com", "127.0.0.1", 51.6553959, 0.0572553);
    private final Person personWithParisCoordinates = new Person(4, "Paul", "Smith", "here@there.com", "127.0.0.1", 48.856613, 2.352222);

    private final List<Person> listOfEveryone = Arrays.asList(londonPerson1, londonPerson2, personWithLondonCoordinates, personWithParisCoordinates);

    @Test
    public void fullFilterTest() {

        GetPeopleByCityService getPeopleByCityService = mock(GetPeopleByCityService.class);

        when(getPeopleByCityService.getPeople("London")).thenReturn(Arrays.asList(londonPerson1, londonPerson2));

        FilterForLondonAndAnyoneWithin50MilesService londonPlus50Milesfilter = new FilterForLondonAndAnyoneWithin50MilesService(getPeopleByCityService);

        List<Person> resultOfFilter = londonPlus50Milesfilter.filter(listOfEveryone);

        assertEquals(3, resultOfFilter.size());
        assertTrue(resultOfFilter.contains(londonPerson1));
        assertTrue(resultOfFilter.contains(londonPerson2));
        assertTrue(resultOfFilter.contains(personWithLondonCoordinates));
        assertFalse(resultOfFilter.contains(personWithParisCoordinates));

    }

}