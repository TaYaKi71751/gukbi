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
Thymeleaf/Mustache (Select One, likley jstl)
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
	implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api'
	implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
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
### Code
- Create directory [webapp](../../springboot/start01/src/main/webapp) into `src/main/`
- Create directory [WEB-INF](../../springboot/start01/src/main/webapp/WEB-INF) into `src/main/webapp/`
- Create directory [views](../../springboot/start01/src/main/webapp/WEB-INF/views) into `src/main/webapp/WEB-INF/`
- Create diretory [controller](../../springboot/start01/src/main/java/com/example/start01/controller]) into `src/main/com/example/start01/`
- Create [MyController.java](../../springboot/start01/src/main/java/com/example/start01/controller/MyController.java) into `src/main/com/example/start01/controller/`
- Create [div.jsp](../../springboot/start01/src/main/webapp/WEB-INF/views/div.jsp) into `src/main/webapp/WEB-INF/views/`
- Create [mul.jsp](../../springboot/start01/src/main/webapp/WEB-INF/views/mul.jsp) into `src/main/webapp/WEB-INF/views/`
- Create [sub.jsp](../../springboot/start01/src/main/webapp/WEB-INF/views/sub.jsp) into `src/main/webapp/WEB-INF/views/`
- Create [sum.jsp](../../springboot/start01/src/main/webapp/WEB-INF/views/sum.jsp) into `src/main/webapp/WEB-INF/views/`
- Create [model2.jsp](../../springboot/start01/src/main/webapp/WEB-INF/views/model2.jsp) into `src/main/webapp/WEB-INF/views`
- Create [model3.jsp](../../springboot/start01/src/main/webapp/WEB-INF/views/model3.jsp) into `src/main/webapp/WEB-INF/views/`
- Create directory [dto](../../springboot/start01/src/main/java/com/example/start01/dto) into `src/main/java/com/example/start01/`
- Create [HumanDto.java](../../springboot/start01/src/main/java/com/example/start01/dto/HumanDto.java) into `src/main/java/com/example/start01/`
- Create [model4.jsp](../../springboot/start01/src/main/webapp/WEB-INF/views/model4.jsp) into `src/main/webapp/WEB-INF/views/`
```java
package com.example
```
## Run
- Open `Start01Application`, Click `Run`
### MacOS, Linux
```bash
# cd to project then run
./gradlew bootRun
```
### Windows
```powershell
# cd to project then run
gradlew.bat bootRun
```