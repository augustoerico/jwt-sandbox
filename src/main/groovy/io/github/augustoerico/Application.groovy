package io.github.augustoerico

import io.vertx.core.Vertx
import io.vertx.ext.auth.User
import io.vertx.ext.auth.jwt.JWTAuth

class Application {

    static main(args) {
        Vertx vertx = Vertx.vertx()
        vertx.with {
            deployVerticle(ServerVerticle.name) {
                println 'Server verticle deployed'
            }
        }
    }

//    static main(args) {
//        def config = [keyStore:[path:"keystore.jceks", type:"jceks", password:"secret"]]
//
//        def provider = JWTAuth.create(Vertx.vertx(), config)
//
//        def token = provider.generateToken([sub: 'ercio'], [permissions:['foo:bar']])
//
//        println token
//
//        // creating authorization
//
//        provider.authenticate([jwt: token], { res ->
//            println 'handling'
//            if (res.succeeded()) {
//                println 'print it!'
//                User user = res.result()
//                println "User ${user.principal()} is authenticated"
//                user.isAuthorised('foo:bar', { res2 ->
//                    if (res2.succeeded()) {
//                        println 'success'
//                        println "isAuthorised: ${res2.result()}"
//                    } else {
//                        res2.cause().printStackTrace()
//                    }
//                })
//            } else {
//                res.cause().printStackTrace()
//            }
//        })
//
//    }

}
