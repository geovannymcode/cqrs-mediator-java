package com.geovanycode.application.mediator;

import com.geovanycode.application.command.Command;
import com.geovanycode.application.command.handler.CommandHandler;
import com.geovanycode.application.query.Query;
import com.geovanycode.application.query.handler.QueryHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Mediator {
    private final ApplicationContext applicationContext;

    public Mediator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <R, C extends Command<R>> R send(C command) {
        Class<?> commandClass = command.getClass();
        String handlerName = commandClass.getSimpleName() + "Handler";
        String handlerPackage = commandClass.getPackageName();
        String handlerFullName = handlerPackage + "." + handlerName;

        try {
            @SuppressWarnings("unchecked")
            CommandHandler<C, R> handler = (CommandHandler<C, R>) applicationContext
                    .getBean(Class.forName(handlerFullName));
            return handler.handle(command);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No handler found for command: " + commandClass.getName(), e);
        }
    }

    public <R, Q extends Query<R>> R send(Q query) {
        Class<?> queryClass = query.getClass();
        String handlerName = queryClass.getSimpleName() + "Handler";
        String handlerPackage = queryClass.getPackageName();
        String handlerFullName = handlerPackage + "." + handlerName;

        try {
            @SuppressWarnings("unchecked")
            QueryHandler<Q, R> handler = (QueryHandler<Q, R>) applicationContext
                    .getBean(Class.forName(handlerFullName));
            return handler.handle(query);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No handler found for query: " + queryClass.getName(), e);
        }
    }
}
