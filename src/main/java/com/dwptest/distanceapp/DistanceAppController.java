package com.dwptest.distanceapp;

import java.util.List;

import com.dwptest.distanceapp.dataretrieval.GetPeopleService;
import com.dwptest.distanceapp.filter.FilterPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DistanceAppController {

    private final GetPeopleService getPeopleService;

    private final FilterPeopleService filterPeopleService;

    @Autowired
    public DistanceAppController(GetPeopleService getPeopleService, FilterPeopleService filterPeopleService) {
        this.getPeopleService = getPeopleService;
        this.filterPeopleService = filterPeopleService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<Person> getUsers() {
        return filterPeopleService.filter(getPeopleService.getPeople());
    }

}