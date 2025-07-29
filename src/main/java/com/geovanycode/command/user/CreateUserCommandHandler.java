package com.geovanycode.command.user;

import com.geovanycode.command.CommandHandler;
import com.geovanycode.domain.User;
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
        User user = new User(command.name(), command.email());
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
