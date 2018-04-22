# Dojo-Overflow
Stack Overflow like question and answer site in Java Spring

<hr>
To get this running start up mysql and create a schema called ```dojooverflow```

```sql
CREATE SCHEMA dojooverflow;
```

Also edit ```src/main/resources/application.properties``` to change the username and password to the appropriate values for your mysql

```
spring.datasource.username=test
spring.datasource.password=Test1234
```

To run the server, in the same directory as ```pom.xml``` run the command

```bash
mvn spring-boot:run
```
