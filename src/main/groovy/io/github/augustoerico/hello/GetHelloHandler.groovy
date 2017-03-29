package io.github.augustoerico.hello

import io.vertx.ext.web.RoutingContext

class GetHelloHandler {

    static HELLO_JSON = '{"greeting": "Hello!"}'

    static handle = { RoutingContext context ->
        def response = context.response()
        response.putHeader('content-type', 'application/json').end(HELLO_JSON)
    }

}
