package io.github.augustoerico.routes

import io.github.augustoerico.hello.GetHelloHandler
import io.vertx.core.http.HttpMethod
import io.vertx.ext.auth.AuthProvider
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.JWTAuthHandler

class HelloRouter {

    Router router
    AuthProvider authProvider

    HelloRouter(Router router, AuthProvider authProvider) {
        this.router = router
        this.authProvider = authProvider
    }

    def route() {
        router.route('/*').handler JWTAuthHandler.create(authProvider).&handle
        router.route(HttpMethod.GET, '/hello').handler GetHelloHandler.handle
    }

    static create(Router router, AuthProvider authProvider) {
        new HelloRouter(router, authProvider)
    }

}
