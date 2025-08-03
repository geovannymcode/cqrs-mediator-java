package com.geovanycode.presentation.controller;

import com.geovanycode.application.command.CreatePersonCommand;
import com.geovanycode.application.dto.CreatePersonRequest;
import com.geovanycode.application.dto.PersonDto;
import com.geovanycode.application.mediator.Mediator;
import com.geovanycode.application.query.GetPersonQuery;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final Mediator mediator;

    public PersonController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<Void> createPerson(@Valid @RequestBody CreatePersonRequest request) {
        CreatePersonCommand command = new CreatePersonCommand(request.name(), request.email());
        Long personId = mediator.send(command);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(personId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPeople() {
        List<PersonDto> people = mediator.send(new GetPersonQuery());
        return ResponseEntity.ok(people);
    }
}
