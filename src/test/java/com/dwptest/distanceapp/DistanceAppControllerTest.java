package com.dwptest.distanceapp;

import com.dwptest.distanceapp.dataretrieval.GetPeopleService;
import com.dwptest.distanceapp.filter.FilterPeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DistanceAppControllerTest {

    private Person testPerson1 = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private Person testPerson2 = new Person(2, "Paul", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private Person testPerson3 = new Person(3, "George", "Smith", "here@there.com", "127.0.0.1", 0, 0);
    private Person testPerson4 = new Person(4, "Ringo", "Smith", "here@there.com", "127.0.0.1", 0, 0);

    @Test
    public void controllerSuccessfullyRoutesAnFilters() {

        List<Person> allUsers = Arrays.asList(testPerson1, testPerson2, testPerson3, testPerson4);

        GetPeopleService getPeopleService = mock(GetPeopleService.class);
        when(getPeopleService.getPeople()).thenReturn(allUsers);

        List<Person> filteredUsers = Arrays.asList(testPerson2, testPerson4);

        FilterPeopleService filterPeopleService = mock(FilterPeopleService.class);
        when(filterPeopleService.filter(allUsers)).thenReturn(filteredUsers);

        DistanceAppController controller = new DistanceAppController(getPeopleService, filterPeopleService);

        List<Person> users = controller.getUsers();

        assertEquals(filteredUsers, users);
    }
}