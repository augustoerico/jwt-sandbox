package io.github.augustoerico.routes

import io.github.augustoerico.auth.SignInHandler
import io.vertx.ext.web.handler.BodyHandler

class AuthRouter {

    def router
    def authProvider

    AuthRouter(router, authProvider) {
        this.router = router
        this.authProvider = authProvider
    }

    def route() {
        router.route().handler BodyHandler.create()
        router.post('/sign_in').handler SignInHandler.create(authProvider).handle
    }

    static create(vertx, authProvider) {
        new AuthRouter(vertx, authProvider)
    }

}
