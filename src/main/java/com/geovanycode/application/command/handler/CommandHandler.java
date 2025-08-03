package com.geovanycode.application.command.handler;

import com.geovanycode.application.command.Command;

public interface CommandHandler <C extends Command<R>, R> {
    R handle(C command);
}