# spring-rabbitmq
Spring Boot projet using RabiitMQ as service broker

To run RabbitMQ container:

`docker container run -d -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3-management`
