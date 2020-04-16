package com.dwptest.distanceapp.filter;

import com.dwptest.distanceapp.Person;

public class IsWithinXMilesOfGivenCoordinateFilter implements PersonFilter {

    private final double sourceLatitude;
    private final double sourceLongitude;
    private final long radiusInMiles;

    public IsWithinXMilesOfGivenCoordinateFilter(double sourceLatitude, double sourceLongitude, long radiusInMiles) {
        this.sourceLatitude = sourceLatitude;
        this.sourceLongitude = sourceLongitude;
        this.radiusInMiles = radiusInMiles;
    }

    @Override
    public boolean keep(Person person) {
        double personLatitude = person.getLatitude();
        double personLongitude = person.getLongitude();

        return distance(sourceLatitude, sourceLongitude, personLatitude, personLongitude) < radiusInMiles;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        return dist * 60 * 1.1515;
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
