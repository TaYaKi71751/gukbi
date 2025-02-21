package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.HobbyDto;
import com.human.util.DBConn;

public class HobbyDao {
	public ArrayList<HobbyDto> select() {
		ArrayList<HobbyDto> resultDtos=new ArrayList<HobbyDto>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from hobby"));
		try {
			while(rs.next()) {
				resultDtos.add(new HobbyDto(rs.getInt("id"), rs.getString("hobby")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;	
	}
	public HobbyDto selectId(int id) {
		HobbyDto resultDtos=new HobbyDto();
		ResultSet rs=DBConn.statementQuery(String.format("select * from hobby where id=%d", id));
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new HobbyDto(rs.getInt("id"),rs.getString("hobby"));
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
				
	public void insert(HobbyDto dto) {
		String sql=String.format("insert into hobby values("+"%d,'%s')",
				dto.getId(),dto.getHobby());
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	public void update(String upHobby, int id) {
		String sql=String.format("update hobby set hobby='%s' where id='%d'",id,upHobby);
		DBConn.statementUpdate(sql);
		System.out.println("[수정 완료]");
	}
	public void delete(int id) {
		String sql=String.format("delete hobby where id=%d",id);
		DBConn.statementUpdate(sql);
		System.out.println("[삭제 완료]");
	}
	
//	public ArrayList<Integer> getIds() {
//		ArrayList<Integer> ids=new ArrayList<Integer>();
//		ResultSet rs=DBConn.statementQuery(String.format("select * from hobby"));
//		try {
//			while(rs.next()) {
//				ids.add(rs.getInt("id"));
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	return ids;
//	}
//
//	public int getMaxId() {
//		int maxIdValue=-1;
//		ResultSet rs=DBConn.statementQuery(String.format("select max(id) as maxId from hobby"));
//		if(rs!=null) {
//			try {
//				rs.next();
//				maxIdValue=rs.getInt("maxId");	
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return maxIdValue;
//	}
}