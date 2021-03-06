package com.dwptest.distanceapp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Person bean containing all the information available about them.
 */
public class Person {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String ipAddress;
    private final double latitude;
    private final double longitude;

    @JsonCreator
    public Person(@JsonProperty("id") long id,
                  @JsonProperty("first_name") String firstName,
                  @JsonProperty("last_name") String lastName,
                  @JsonProperty("email") String email,
                  @JsonProperty("ip_address") String ipAddress,
                  @JsonProperty("latitude") double latitude,
                  @JsonProperty("longitude") double longitude) {
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email) &&
                Objects.equals(ipAddress, person.ipAddress) &&
                Objects.equals(latitude, person.latitude) &&
                Objects.equals(longitude, person.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, ipAddress, latitude, longitude);
    }
}
