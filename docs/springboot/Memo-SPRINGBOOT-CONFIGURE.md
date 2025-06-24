# SpringBoot
## [Create a new SpringBoot Project](https://start.spring.io/)
- Select `Gradle - Groovey` as `Project`
- Select `Java` as `Language`
- Select `3.3.13` as `Spring Boot`
- Edit `Artifact` as you want, but in this used `start01`
- Select `War` as `Package` is recommended
- Click `ADD DEPENDENCIES` for add dependencies
- Select `21` as `Java`
```
Spring Boot Dev Tools
Lombok
Spring Web
Thymeleaf/Mustache/JSTL (Select One)
MyBatis Framework
Spring Data JPA
H2 Database
Oracle Driver
```
- Click `Generate`
- Extract with directory
## Open from Intellij IDEA
- Open Intellij IDEA
- Click `Open`
- Select project directory
- Click `Open`
## Configure project
- Add `index.html` to `src/main/resources/static/`
- Add below to dependencies in `build.gradle`
```
	implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
	implementation 'jakarta.servlet:jakarta.servlet-api'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
	// JSTL
	implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api'
	implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl'
```
- Click `File` > `Project Structure`, Select `temurin 21` as `jdk`, Select `SDK default` as `Language level`
- Add below to `src/main/resources/application.properties`
```
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
# Edit jsp without restart
server.servlet.jsp.init-parameters.development=true
```
- To change server port `src/main/resources/application.properties` add below
```
# If you want to use 8081 port
server.port=8081
```