package com.sk.mvc.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sk.mvc.dtos.ManagerDto;


public class ManagerDao {

	public ManagerDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("1단계 드라이버로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("1단계 드라이버로딩 실패");
		}
	}
	
	public List<ManagerDto> getAllUser(){
		List<ManagerDto> list=new ArrayList<>();
		
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql="SELECT id,"
				+ "		 NAME,"
				+ "		 PASSWORD,"
				+ "		 address,"
				+ "		 email,"
				+ "		 enabled,"
				+ "		 ROLE,"
				+ "		 regdate "
				+ "FROM userinfo";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계 DB연결 성공");
			psmt=conn.prepareStatement(sql);
			System.out.println("3단계 쿼리준비 성공");
			rs=psmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
			while(rs.next()) {
				ManagerDto dto=new ManagerDto();
				dto.setUserId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setEnabled(rs.getString(6));
				dto.setRole(rs.getString(7));
				dto.setRegdate(rs.getDate(8));
				
				list.add(dto);
			}
			System.out.println("5단계 쿼리결과받기 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 실패: "+getClass());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(psmt!=null) {
					psmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				System.out.println("6단계 DB닫기 성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("6단계 DB닫기 실패");
			}
		}
		return list;
	}
	
	public List<ManagerDto> logIn(String logIn_Id, String logIn_Password){
		List<ManagerDto> list=new ArrayList<>();
		
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql="SELECT id,"
				+ "		 NAME,"
				+ "		 PASSWORD,"
				+ "		 address,"
				+ "		 email,"
				+ "		 enabled,"
				+ "		 ROLE,"
				+ "		 regdate "
				+ "FROM userinfo "
				+ "WHERE id = '" + logIn_Id
				+ "' AND PASSWORD = '" + logIn_Password +"'";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계 DB연결 성공");
			psmt=conn.prepareStatement(sql);
			System.out.println("3단계 쿼리준비 성공");
			rs=psmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
			while(rs.next()) {
				ManagerDto dto=new ManagerDto();
				dto.setUserId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setEnabled(rs.getString(6));
				dto.setRole(rs.getString(7));
				dto.setRegdate(rs.getDate(8));
				
				list.add(dto);
			}
			System.out.println("5단계 쿼리결과받기 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 실패: "+getClass());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(psmt!=null) {
					psmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				System.out.println("6단계 DB닫기 성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("6단계 DB닫기 실패");
			}
		}
		return list;
	}
}
