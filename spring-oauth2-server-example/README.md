

#### Create user

```
curl -X POST -H "Content-Type: application/json" -d '{"username": "<USERNAME>", "<PASSWORD>": "user"}' http://localhost:8080/users
```

#### Get token

```
curl -X POST --user 'ui:ui' -d 'scope=ui&grant_type=password&username=<USERNAME>&password=<PASSWORD>' http://localhost:8080/oauth/token
```

or

```
curl ui:ui@localhost:8080/oauth/token -d grant_type=password -d username=<USERNAME> -d password=<PASSWORD>
```

#### Get user info:

```
curl -X GET -H "Authorization: Bearer <TOKEN>" http://localhost:8080/users/current
```


###Links

https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/htmlsingle/
