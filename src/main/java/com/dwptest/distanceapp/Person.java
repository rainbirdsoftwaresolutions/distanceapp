package com.dwptest.distanceapp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Person bean containing all the information available about them.
 */
public class Person {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String ipAddress;
    private final long latitude;
    private final long longitude;

    public Person(long id, String firstName, String lastName, String email, String ipAddress, long latitude, long longitude) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ipAddress = ipAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @JsonProperty("ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }
}
