package com.dwptest.distanceapp;

import java.util.List;

import com.dwptest.distanceapp.dataretrieval.GetPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DistanceAppController {

    private final GetPeopleService getPeopleService;

    @Autowired
    public DistanceAppController(GetPeopleService getPeopleService) {
        this.getPeopleService = getPeopleService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<Person> getUsers() {
        return getPeopleService.getPeople();
    }

}