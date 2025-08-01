package com.geovanycode.application.command.user;

import com.geovanycode.application.command.CommandHandler;
import com.geovanycode.domain.model.Person;
import com.geovanycode.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, Long> {
    private final UserRepository userRepository;

    public CreateUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Long handle(CreateUserCommand command) {
        Person person = new Person(command.name(), command.email());
        Person savedPerson = userRepository.save(person);
        return savedPerson.getId();
    }
}
