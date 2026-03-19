Start both the producer and consumer microservices.
Use Postman to send a POST request to http://localhost:8080/send with a message in the request body.
The producer will send the message to Kafka, and the consumer will receive and process it.
You can also check the consumer status by sending a GET request to http://localhost:8081/consume.
