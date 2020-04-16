package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsWithinXMilesOfGivenCoordinateFilterTest {

    // These coords are from the Wikipedia entry for London
    // https://en.wikipedia.org/wiki/London
    private final double sourceLatitude = 51.507222;
    private final double sourceLongitude = -0.1275;

    private IsWithinXMilesOfGivenCoordinateFilter filter = new IsWithinXMilesOfGivenCoordinateFilter(sourceLatitude, sourceLongitude, 50);

    @Test
    public void isThePersonInVeryCentreOfLondonKept() {
        Person person = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", sourceLatitude, sourceLongitude);
        assertTrue(filter.keep(person));
    }

    @Test
    public void isThePersonInParisFilteredOut() {
        double parisLat = 48.856613;
        double parisLong = 2.352222;

        Person person = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", parisLat, parisLong);

        assertFalse(filter.keep(person));
    }

    @Test
    public void isThePersonJustOutsideOfTheDefinedRadiusFilteredOut() {
        Person person = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 52.187980, -0.535430);
        assertFalse(filter.keep(person));
    }

    @Test
    public void isThePersonJustInsideOfTheDefinedRadiusKept() {
        Person person = new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 51.169420, -1.141050);
        assertTrue(filter.keep(person));
    }
}