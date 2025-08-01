package com.geovanycode.application.command.user;

import com.geovanycode.application.command.Command;

public record CreateUserCommand(String name, String email) implements Command<Long> {
}
