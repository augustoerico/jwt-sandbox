package io.github.augustoerico.auth

import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.jwt.JWTAuth
import io.vertx.ext.web.RoutingContext

class SignInHandler {

    JWTAuth authProvider

    static final Map DEFAULT_AUTH = [permissions: ['hello']]

    SignInHandler(authProvider) {
        this.authProvider = authProvider
    }

    def handle = { RoutingContext context ->

        def response = context.response()
        def body = context.getBodyAsJson().map

        // Validate here!
        def token = authProvider.generateToken([sub: body.username], DEFAULT_AUTH)
        def json = new JsonObject([token: token])
        response.setStatusCode(201).end(json.encodePrettily())
    }

    static create(authProvider) {
        new SignInHandler(authProvider)
    }

}
