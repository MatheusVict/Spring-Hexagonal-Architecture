# Spring Hexagonal Architecture

This a task manager Spring Boot application using Hexagonal architecture with a low framework coupling that consumes [Json place holder api](https://jsonplaceholder.typicode.com/)

![hexagonal architecture](https://miro.medium.com/v2/resize:fit:1170/1*aD3zDFzcF5Y2_27dvU213Q.png)

### Technologies used

* [Java](https://www.java.com/en/)
* [Spring](https://spring.io/)
* [MySQL](https://www.mysql.com/)
* [JPA](https://spring.io/projects/spring-data-jpa)

## Dependencies

* Java - Version: 17
* Spring - Version: 3.1.5
* Maven - Version: 3.8.6 (Optional)

### Getting start

**OBS:** First of all, look at application.yml and change the database configuration for yours

you can use this example:
```
jdbc:mysql://<your_database_host>:<your_database_port>/<your_database_name>?useSSL=false&serverTimezone=UTC
```

### Running with javac

```
mvn clean install
```

After that:

```
java -jar target/hexagonal-0.0.1-SNAPSHOT.jar
```

### Running with Maven:

```
mvn spring-boot:run
```

### Running with docker:

```
docker build -t image_name .
```

After that:

```
docker run image_name
```
You'll see messagem saying it's running on port ```8080```  open your [localhost:8080](http://localhost:8080)

## How to run tests

```
mvn test
```

# Http routes

## Register a task
> POST

```/```

Body:

```json
{
  "title": "Play with Tú",
  "description": "play with her bird",
  "completed": false
}
```

Retun:

```json
{
  "id": 2,
  "title": "Play with Tú",
  "description": "play with her bird",
  "createdAt": null,
  "completed": false
}
```

## get a task
> GET

```/{taskId}```

Retun:

```json
{
  "id": 2,
  "title": "Play with Tú",
  "description": "play with her bird",
  "createdAt": null,
  "completed": false
}
```

## get all task
> GET

```/```

Retun:

```json
[
  {
    "id": 2,
    "title": "Play with Tú",
    "description": "play with her bird",
    "createdAt": null,
    "completed": false
  },
  {
    "id": 2,
    "title": "Play with Tú",
    "description": "play with her bird",
    "createdAt": null,
    "completed": false
  }
]
```

## get additional information of a task
> GET

```/{taskId}/additionalInfo```

Retun:

```json
{
  "userId": 1,
  "userName": "Leanne Graham",
  "userEmail": "Sincere@april.biz"
}
```

## Update a task
> PUT

```/{taskId}```

Body:

```json
{
  "title": "Play with Tú",
  "description": "play with her bird",
  "completed": false
}
```

Retun:

```json
{
  "id": 2,
  "title": "Play with Tú",
  "description": "play with her bird",
  "createdAt": null,
  "completed": false
}
```

## Delete a task
> DELETE

```/{taskId}```

Retun:

```
Status 204
```

## Problems faced


### Problem 1:
Error on using this architecture because it's decoupled from framework
* You need to do manual dependency injection


## Next steps

Documentation with Swagger



