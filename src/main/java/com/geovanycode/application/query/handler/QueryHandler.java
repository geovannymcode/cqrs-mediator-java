package com.geovanycode.application.query.handler;

import com.geovanycode.application.query.Query;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
