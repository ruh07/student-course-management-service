package com.garg.academic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/apis")
public class Controller {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/worlds")
    public String world() {
        return "World";
    }

    @GetMapping("/employee")
    public String employee(@RequestParam(name = "id")String empId, @RequestParam(required = false) String empName) {
        return String.format("Hello %2$s!, your id is %1$s", empId, empName);
    }

    @GetMapping("/person")
    public Person person(@RequestParam(value = "fname", defaultValue = "First Name")String fName, @RequestParam(name = "lName", defaultValue = "Last Name")String lName) {
        return new Person(fName, lName);
    }

    record Person(String firstName, String lastName) {

    }
}
