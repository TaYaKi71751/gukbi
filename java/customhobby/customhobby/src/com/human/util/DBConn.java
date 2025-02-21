package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static String user = "c##human";
	private static String pw = "human";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static void connect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결");
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("데이터베이스에 접속 성공");
			st=con.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void connect(String user, String pw)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결");
			
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("데이터베이스에 접속 성공");
			st=con.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static ResultSet statementQuery(String sql)
	{
		connect();
		try {
			rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return rs;
    }
	
	public static void statementUpdate(String sql)
	{
		connect();
		if(con == null)
		{
			System.out.println("fail");
		}else
		{
			try {
				int n = st.executeUpdate(sql);
				if(n != 0)
					System.out.println(n + "개의 작업을 성공적으로 수행했습니다");
				else
					System.out.println("작업된 내용이 없습니다");
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			st = null;
			con = null;
		}
	}
}
