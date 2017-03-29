# Vertx + MongoDB REST API boilerplate
Boilerplate for REST API projects using [Vertx](http://vertx.io/) and [MongoDB](https://www.mongodb.com/). This application is ready to deploy on [Heroku](https://www.heroku.com/).

# Test
You can test everything is working fine by running `./gradlew clean build` on the project's root directory. It sets up the server and makes a `GET` request for the `/health` endpoint.

# Running
You can run the application by typing `./gradlew clean run` on the project's root directory. It's going to start a server on `http://localhost:3000`

# Your first request
You can use [Postman](https://www.getpostman.com/) (or yet another tool you like) to make a `GET` request for `http://localhost:3000/health` and see for yourself the server response.
