<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
		이름 : <input type="text" name="name"><br>
		키 : <input type="number" name="height" step="0.00000001"><br>
		생일 : <input type="date" name="birthday"><br>
		<input type="submit" value="submit">
	</form>
	<%
	request.setCharacterEncoding("UTF-8");
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String name = request.getParameter("name");
	String height = request.getParameter("height");
	String birthday = request.getParameter("birthday");
	if(name == null || height == null || birthday == null){
	 out.println("값을 입력하세요.");
		return;
	}

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:";
	String uid = "c##human";
	String upw = "human";
	String query = "select * from member";
	String maxIdQuery = "select max(no) as maxId from member";
	Integer maxId = 1;
	%>
	<%
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(maxIdQuery);
			while(resultSet.next()){
			 maxId = resultSet.getInt("maxId");
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
			}
		}
	%>
 <%
	 String insert = String.format(
	  "insert into member values(%d,'%s',%f,to_date('%s','YYYY-MM-DD'))",
			maxId + 1,
			name,
			Double.parseDouble(height),
			birthday
		);
	%>
	<%
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(insert);
			
			
		} catch (Exception e) {
			out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
			}
		}
	%>
	새로운데이터를 입력함
</body>
</html>
