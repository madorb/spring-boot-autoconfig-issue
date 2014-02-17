Recreating issue as described at:

http://stackoverflow.com/questions/21710450/disable-spring-boot-autoconfiguration-for-transitive-dependencies

* ```gradle clean build```
*  ```java -jar build/libs/boot-autoconfig-issue.jar```

Failure during startup:

```java.lang.NoClassDefFoundError: org/springframework/security/web/authentication/switchuser/AuthenticationSwitchUserEvent```



SecurityAutoConfiguration is disabled in app.groovy so I would expect that even though Spring Security is transitively included in runtime classpath due to dependency on Spring-WS-Sec that Spring Boot would not attempt to initialize Security.


