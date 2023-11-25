## Документация API доступна по адресу:

http://localhost:8080/swagger-ui/index.html

## Как запустить

В файле /backend/src/main/resources/application.properties поменять первую строку

```
spring.datasource.url=jdbc:postgresql://localhost:5432/sber_helper
```

на 

```
spring.datasource.url=jdbc:postgresql://host.docker.internal:5432/sber_helper
```

далее запускаем docker-compose:

```
docker compose -f "docker-compose.yml" up -d --build 
```

Ждем, пока все проставится. Далее, радуемся жизни по адресу: 

localhost:8080