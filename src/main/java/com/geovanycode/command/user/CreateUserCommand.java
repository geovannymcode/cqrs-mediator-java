package com.geovanycode.command.user;

import com.geovanycode.command.Command;

public record CreateUserCommand(String name, String email) implements Command<Long> {
}
