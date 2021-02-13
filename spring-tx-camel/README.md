# SpringBoot Camel Transaction examples
In this project you will see how to work with different basic transaction concepts

```
# building
mvn package

# This will start to you MySQL instance to test
docker-compose up

# running
java -jar spring-tx-camel-1.0-SNAPSHOT.jar

#testing
curl -H "Content-Type: application/json" -X POST -d {\"info\":\"test\"} http://localhost:8080/api/transactions/

#testing forcing rollback - you can check stacktrace with message: Rolling back
curl -H "Content-Type: application/json" -X POST -d {\"info\":\"force-rollback\"} http://localhost:8080/api/transactions/
```
