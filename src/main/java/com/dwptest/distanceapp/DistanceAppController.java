package com.dwptest.distanceapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DistanceAppController {

    @GetMapping("/users")
    @ResponseBody
    public List<Person> getUsers() {
        return Arrays.asList(new Person(1, "John", "Smith", "here@there.com", "127.0.0.1", 0, 0));
    }

}