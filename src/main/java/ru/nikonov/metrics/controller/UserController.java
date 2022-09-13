package ru.nikonov.metrics.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikonov.metrics.entity.User;
import ru.nikonov.metrics.service.UserService;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
//
//    @PostMapping
//    User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @GetMapping("/{userId}")
//    User getUser(@PathVariable("userId") UUID id) {
//        return userService.getUser(id);
//    }
//
//    @PutMapping
//    User changeUser(@RequestBody User user) {
//        return userService.changeUser(user);
//    }
//
//    @GetMapping
//    List<User> getUsers() {
//        return userService.getUsers();
//    }
//
//    @DeleteMapping("/userId")
//    void deleteUser(@PathVariable UUID id) {
//        userService.deleteUser(id);
//    }
}
