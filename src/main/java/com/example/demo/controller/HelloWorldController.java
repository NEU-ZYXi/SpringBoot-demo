package com.example.demo.controller;

import com.example.demo.model.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// A convenience annotation that is itself annotated with @Controller and @ResponseBody.
public class HelloWorldController {

//    @Value("${age}")
//    private Integer age;
//
//    @Value("${country}")
//    private String country;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private UserProperties userProperties;

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @RequestMapping(value = {"/hello", "/index"}, method = RequestMethod.GET)
    @GetMapping("/hello")
    public String index() {
        return "Age: " + userProperties.getAge() + ", Name: " + userProperties.getNick();
    }

//    /user/123
    @GetMapping("/user/{id}")
//    @PathVariable: Annotation which indicates that a method parameter should be bound to a URI template variable
    public String getUserExample1(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

//    user?id=123
    @GetMapping("/user")
//    @RequestParam: Annotation which indicates that a method parameter should be bound to a web request parameter
    public String getUserExample2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id: " + id;
    }
}
