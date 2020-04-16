package com.dwptest.distanceapp;

import com.dwptest.distanceapp.dataretrieval.GetPeopleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DistanceAppControllerTest {

    @Test
    public void controllerSimplyRoutesFromUnderlyingService() {

        List<Person> mockResults = new ArrayList();
        mockResults.add(new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", BigDecimal.ZERO, BigDecimal.ZERO));

        GetPeopleService getPeopleService = mock(GetPeopleService.class);
        when(getPeopleService.getPeople()).thenReturn(mockResults);

        DistanceAppController controller = new DistanceAppController(getPeopleService);

        List<Person> users = controller.getUsers();

        assertEquals(mockResults, users);
    }
}