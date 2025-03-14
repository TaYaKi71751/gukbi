# Snippets
## Create Folder `.vscode` in Workspace Folder
### Create `html.code-snippets` File in `.vscode` Folder
```json
{
    "Basic HTML Template for JSP": {
        "prefix": "eclipse-html",
        "body": [
            "<!DOCTYPE html>",
            "<html>",
            "<head>",
            "    <meta charset=\"UTF-8\">",
            "    <title>Insert title here</title>",
            "</head>",
            "<body>",
            "",
            "</body>",
            "</html>"
        ],
        "description": "Basic HTML structure for JSP files"
    }
}
```
### Create `jsp.code-snippets` File in `.vscode` Folder
```json
{
    "JSP Template": {
        "prefix": "eclipse-jsp",
        "body": [
            "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"",
            "    pageEncoding=\"UTF-8\"%>",
            "<!DOCTYPE html>",
            "<html>",
            "<head>",
            "    <meta charset=\"UTF-8\">",
            "    <title>Insert title here</title>",
            "</head>",
            "<body>",
            "",
            "</body>",
            "</html>"
        ],
        "description": "Basic JSP template"
    }
}
```
### Create `servlet.code-snippets` File in `.vscode` Folder
```json
{
    "Java Servlet Template": {
        "prefix": "eclipse-servlet",
        "body": [
            "package ${1:com.example};",
            "",
            "import java.io.IOException;",
            "import javax.servlet.ServletException;",
            "import javax.servlet.annotation.WebServlet;",
            "import javax.servlet.http.HttpServlet;",
            "import javax.servlet.http.HttpServletRequest;",
            "import javax.servlet.http.HttpServletResponse;",
            "",
            "/**",
            " * Servlet implementation class ${TM_FILENAME_BASE}",
            " */",
            "@WebServlet(\"/${TM_FILENAME_BASE}\")",
            "public class ${TM_FILENAME_BASE} extends HttpServlet {",
            "    private static final long serialVersionUID = 1L;",
            "    ",
            "    public ${TM_FILENAME_BASE}() {",
            "        super();",
            "    }",
            "",
            "    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {",
            "        response.getWriter().append(\"Served at: \").append(request.getContextPath());",
            "    }",
            "",
            "    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {",
            "        doGet(request, response);",
            "    }",
            "}"
        ],
        "description": "Creates a Java Servlet class with filename as class name"
    }
}

```
## Usage
### eclipse-jsp
### eclipse-html
### eclipse-servlet