package io.github.augustoerico.hello

import io.vertx.ext.auth.jwt.impl.JWTUser
import io.vertx.ext.web.RoutingContext

class GetHelloHandler {

    static handle = { RoutingContext context ->
        JWTUser user = context.user()
        def principal = user.jwtToken.map // TODO: REPORT THIS BUG! jwtToken != principal()
        def sub = principal.sub
        def response = context.response()
        response.putHeader('content-type', 'application/json').end("{\"greeting\": \"Hello, $sub!\"}")
    }

}
