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
	implementation 'jakarta.servlet.jsp:jakarta.servlet.jsp-api:3.0.0'
	implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0'
	runtimeOnly 'org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1'
    implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
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
- Create directory `webapp` into `src/main/`
- Create directory `WEB-INF` into `src/main/webapp/`
- Create directory `views` into `src/main/webapp/WEB-INF/`
### Code
- Create jsp file `01start` into `src/main/webapp/WEB-INF/views/` like below
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Test Page</title>
</head>
<body>
   <h1>Hello, World!</h1>
   <p>This is a simple JSP page.</p>
   <p>01start.jsp</p>
</body>
</html>
```
- Create new package `controller` into `src/main/com/example/start01/`
- Create Java Class `MyController` into `src/main/com/example/start01/controller/`, edit like below
```
package com.example.start01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {
    @GetMapping("/sum")
    public String sum(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a + b);
        return "sum";
    }

    @GetMapping("/sub")
    public String sub(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a - b);
        return "sub";
    }

    @GetMapping("/mul")
    public String mul(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a * b);
        return "mul";
    }

    @GetMapping("/div")
    public String div(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a / b);
        return "div";
    }

    @GetMapping("/model2")
    public ModelAndView model2() {
        ModelAndView modelAndView = new ModelAndView("model2");
        modelAndView.addObject("key", "value=model2");
        modelAndView.setViewName("model2");
        return modelAndView;
    }

    @GetMapping("/model3")
    public String model3(Model model) {
        Map<String, String> rMap = new HashMap<>();
        rMap.put("key1", "홍길동");
        rMap.put("key2", "21");
        rMap.put("key3", "서울");
        model.addAttribute("mapData", rMap);
        return "model3";
    }
}
```
- Create `div.jsp` into `src/main/webapp/WEB-INF/views/` like below
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Div Calculation</title>
</head>
<body>
    ${a} / ${b} = ${result}
</body>
</html>
```
- Create `mul.jsp` into `src/main/webapp/WEB-INF/views/` like below
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mul Calculation</title>
</head>
<body>
    ${a} * ${b} = ${result}
</body>
</html>
```
- Create `sub.jsp` into `src/main/webapp/WEB-INF/views/` like below
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sub Calculation</title>
</head>
<body>
    ${a} - ${b} = ${result}
</body>
</html>
```
- Create `sum.jsp` into `src/main/webapp/WEB-INF/views/` like below
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum Calculation</title>
</head>
<body>
    ${a} + ${b} = ${result}
</body>
</html>
```
- Create `model2.jsp` into `src/main/webapp/WEB-INF/views`
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
    <h1>Model and View Example</h1>
    key:${key}
</body>
</html>
```
- Create `model3.jsp` into `src/main/webapp/WEB-INF/views/`
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
    <h1>Model 3</h1>
    <p>key1 : ${mapData.key1}</p>
    <p>key2 : ${mapData.key2}</p>
    <p>key3 : ${mapData.key3}</p>
</body>
</html>
```
- 
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