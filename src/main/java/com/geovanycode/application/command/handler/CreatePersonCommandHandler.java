package com.geovanycode.application.command.handler;

import com.geovanycode.application.command.CreatePersonCommand;
import com.geovanycode.domain.PersonDomainService;
import com.geovanycode.domain.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreatePersonCommandHandler implements CommandHandler<CreatePersonCommand, Long> {
    private final PersonDomainService personDomainService;

    public CreatePersonCommandHandler(PersonDomainService personDomainService) {
        this.personDomainService = personDomainService;
    }

    @Override
    @Transactional
    public Long handle(CreatePersonCommand command) {
        Person person = personDomainService.createPerson(command.name(), command.email());
        return person.getId();
    }
}
