# Spring
## [Create Project](https://start.spring.io/)
- Select `Maven`
- Select `4.0.0` as `Spring Boot`
- Select `Java`
- Enter `Group`, `Artifact`, `Name`, `Description`
- Select `Packaging` as `War`
- Select Java Version
- Click generate
## Set up some configures
- Add below to `dependencies` in `pom.xml`
```
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<version>11.0.7</version> <!-- Ensure this matches your Tomcat version -->
		</dependency>
		<dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
			<version>2.0.0</version> <!-- Use a version compatible with Jakarta EE 9+ -->
		</dependency>
		<dependency>
			<groupId>jakarta.servlet</groupId>
			<artifactId>jakarta.servlet-api</artifactId>
			<version>6.0.0</version> <!-- Use a version compatible with Tomcat 11 -->
			<scope>provided</scope>
		</dependency>
```
- Add below to `src/main/resources/application.properties`
```
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```
## [Example 1](https://github.com/TaYaKi71751/spring01)
