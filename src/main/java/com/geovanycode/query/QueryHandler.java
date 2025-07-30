package com.geovanycode.query;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
