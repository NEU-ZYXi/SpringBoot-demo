package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestParam("username") String username,
                          @RequestParam("age") Integer age) {
        User user = new User();
        user.setUsername(username);
        user.setAge(age);

        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/users/age/{age}")
    public List<User> findUsersByAge(@PathVariable("age") Integer age) {
        return userRepository.findByAge(age);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Integer id,
                           @RequestParam("username") String username,
                           @RequestParam("age") Integer age) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setAge(age);

        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users/two")
    public void addUsers() {
        userService.insertUsers();
    }
}
