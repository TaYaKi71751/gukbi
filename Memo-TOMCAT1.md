# Tomcat
## [mvn create project](https://maven.apache.org/archetypes/maven-archetype-webapp/)
```shell
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.5
```
## html
### [01start.html](./java/jsp/jsp079/src/main/webapp/01start.html)
## JSP
### [GetServlet.jsp](./java/jsp/jsp079/src/main/webapp/GetServlet.jsp)
### JSP Tag
#### 표현식 `<%= %>`
```
화면에 출력
= 다음으로 오는 데이터를 화면에 출력
```
#### 선언식 `<%! %>`
```
전역변수나 메소드 선언시 사용
```
#### 스크립틀릿 `<% %>`
```
지역변수나 Java로직 사용
```
## Servlet
### [GetServlet](./java/jsp/jsp079/src/main/java/com/the/ex/GetServlet.java)
### [StarServlet](./java/jsp/jsp079/src/main/java/com/the/ex/StarServlet.java)
