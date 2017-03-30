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
        router.route('/hello/*')
                .handler JWTAuthHandler.create(authProvider).addAuthority('hello').&handle
        router.route(HttpMethod.GET, '/hello')
                .handler GetHelloHandler.handle

        router.route('/hello/there/*')
                .handler JWTAuthHandler.create(authProvider).addAuthority('hello-there').&handle
        router.get('/hello/there')
                .handler GetHelloHandler.handle // TODO add a get-hello-there handler
    }

    static create(Router router, AuthProvider authProvider) {
        new HelloRouter(router, authProvider)
    }

}
