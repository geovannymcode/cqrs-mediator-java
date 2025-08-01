package com.geovanycode.controller;

import com.geovanycode.application.command.user.CreateUserCommand;
import com.geovanycode.dto.UserDto;
import com.geovanycode.application.mediator.Mediator;
import com.geovanycode.application.query.user.GetUsersQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final Mediator mediator;

    public UserController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody CreateUserCommand command) {
        Long userId = mediator.send(command);
        return ResponseEntity.ok(userId);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = mediator.send(new GetUsersQuery());
        return ResponseEntity.ok(users);
    }
}
