package com.geovanycode.application.query;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
