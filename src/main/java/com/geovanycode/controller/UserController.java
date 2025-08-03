package com.geovanycode.controller;

import com.geovanycode.application.command.CreatePersonCommand;
import com.geovanycode.application.dto.PersonDto;
import com.geovanycode.application.mediator.Mediator;
import com.geovanycode.application.query.GetPersonQuery;
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
    public ResponseEntity<Long> createUser(@RequestBody CreatePersonCommand command) {
        Long userId = mediator.send(command);
        return ResponseEntity.ok(userId);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getUsers() {
        List<PersonDto> users = mediator.send(new GetPersonQuery());
        return ResponseEntity.ok(users);
    }
}
