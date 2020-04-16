package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;
import com.dwptest.distanceapp.dataretrieval.GetPeopleByCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterForLondonAndAnyoneWithin50MilesService implements FilterPeopleService {

    public static final String CITY_NAME = "London";
    public static final int RADIUS_IN_MILES = 50;

    // These coords are from the Wikipedia entry for London
    // https://en.wikipedia.org/wiki/London
    private static final double SOURCE_LATITUDE = 51.507222;
    private static final double SOURCE_LONGITUDE = -0.1275;

    private final GetPeopleByCityService getPeopleByCityService;

    private final IsWithinXMilesOfGivenCoordinateFilter isWithinXMilesOfGivenCoordinateFilter = new IsWithinXMilesOfGivenCoordinateFilter(SOURCE_LATITUDE, SOURCE_LONGITUDE, RADIUS_IN_MILES);

    @Autowired
    public FilterForLondonAndAnyoneWithin50MilesService(GetPeopleByCityService getPeopleByCityService) {
        this.getPeopleByCityService = getPeopleByCityService;
    }

    @Override
    public List<Person> filter(List<Person> peopleToFilter) {
        List<Person> londonPeople = getPeopleByCityService.getPeople(CITY_NAME);
        IsInGetCityUsersResultsFilter isInLondonFilter = new IsInGetCityUsersResultsFilter(londonPeople);

        return peopleToFilter
                .parallelStream()
                .filter(person -> isInLondonFilter.keep(person) || isWithinXMilesOfGivenCoordinateFilter.keep(person))
                .collect(Collectors.toList());
    }
}
