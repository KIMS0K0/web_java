package com.hk.database;

import java.sql.*;

public class Database {

	public Database() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.print("1단계 드라이버로딩 성공 ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("1단계 드라이버로딩 실패 ");
		}
	}
	
	public Connection getConnection() {
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn =null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("2단계 DB연결 성공 ");
		
		return conn;
	}
	
	public void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
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
}
