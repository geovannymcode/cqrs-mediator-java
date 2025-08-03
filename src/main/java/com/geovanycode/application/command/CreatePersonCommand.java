package com.geovanycode.application.command;

public record CreatePersonCommand(String name, String email) implements Command<Long> {
}
