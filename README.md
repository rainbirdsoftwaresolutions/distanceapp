# distanceapp

The small Spring Boot application is an implementation of the following request to...

> "...build your own API which calls the API at https://bpdts-test-app.herokuapp.com/, and returns people who are listed as either living in London, or whose current coordinates are within 50 miles of London."

This Spring Boot application starts up on the default port of 8080, which can be tested by calling the following curl with the "users" path:

_curl localhost:8080/users_

This implementation first retrieves all the users from the test data source, and only returns the users that...

* also appear on a subsequent call to retrieve users by city
* ...or are within 50 miles of the lat/long coordinates of London retrieved from [here](https://en.wikipedia.org/wiki/London)

Care has been taken to externalise the test data source urls and to keep the JSON data structures the same.
