package com.hk.board.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.board.dtos.UserDto;

public class UserDao {
	public UserDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("1단계 드라이버로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("1단계 드라이버로딩 실패");
		}
	}
	
	public List<UserDto> getAllUser(){
		List<UserDto> list=new ArrayList<>();
		
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql="SELECT 	userID, "
				+ "			NAME, "
				+ "			birthYear, "
				+ "			addr, "
				+ "			mobile1, "
				+ "			mobile2, "
				+ "			height, "
				+ "			mDate "
				+ "FROM usertbl ";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계 DB연결 성공");
			psmt=conn.prepareStatement(sql);
			System.out.println("3단계 쿼리준비 성공");
			rs=psmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
			while(rs.next()) {
				UserDto dto=new UserDto();
				dto.setUserID(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirthYear(rs.getInt(3));
				dto.setAddr(rs.getString(4));
				dto.setMobile1(rs.getString(5));
				dto.setMobile2(rs.getString(6));
				dto.setHeight(rs.getInt(7));
				dto.setmDate(rs.getDate(8));
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
	
	public UserDto getUser(String userID){
		UserDto dto=new UserDto();
		
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql="SELECT 	userID, "
				+ "			NAME, "
				+ "			birthYear, "
				+ "			addr, "
				+ "			mobile1, "
				+ "			mobile2, "
				+ "			height, "
				+ "			mDate "
				+ "FROM usertbl "
				+ "WHERE USERID = ? ";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계 DB연결 성공");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			System.out.println("3단계 쿼리준비 성공");
			rs=psmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
			while(rs.next()) {
				dto.setUserID(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirthYear(rs.getInt(3));
				dto.setAddr(rs.getString(4));
				dto.setMobile1(rs.getString(5));
				dto.setMobile2(rs.getString(6));
				dto.setHeight(rs.getInt(7));
				dto.setmDate(rs.getDate(8));
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
		return dto;
	}
	
	public boolean insertUser(UserDto dto){
		int count=0;

		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" INSERT INTO usertbl  "
				 + " VALUES(?, ?, ?, ?, ?,?,?,SYSDATE()) ";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계:DB연결 성공");
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getUserID());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, dto.getBirthYear());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getMobile1());
			psmt.setString(6, dto.getMobile2());
			psmt.setInt(7, dto.getHeight());
			System.out.println("3단계:쿼리준비 성공");
			
			count=psmt.executeUpdate();
			System.out.println("4단계:쿼리실행 성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패: "+getClass());
			e.printStackTrace();
		}finally {
			try {
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
		
		return count>0?true:false;//삼항연산자
	}
	
	public boolean updateUser(UserDto dto){
		int count=0;

		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" UPDATE usertbl SET 	NAME = ?,"
				+ "							birthYear = ?,"
				+ "							addr = ? ,"
				+ "							mobile1 = ? ,"
				+ "							mobile2 = ? ,"
				+ "							height = ? "
				+ "WHERE userID = ? ";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계:DB연결성공");
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getBirthYear());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getMobile1());
			psmt.setString(5, dto.getMobile2());
			psmt.setInt(6, dto.getHeight());
			psmt.setString(7, dto.getUserID());
			System.out.println("3단계:쿼리준비성공");
			
			count=psmt.executeUpdate();
			System.out.println("4단계:쿼리실행성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패: "+getClass());
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) {
					psmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				System.out.println("6단계 DB닫기 성공");
				count=1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("6단계 DB닫기 실패");
			}
		}
		
		return count>0?true:false;//삼항연산자
	}
	
	//회원정보 삭제
	public boolean deleteUser(String userID){
		int count=0;
		
		UserDto dto=new UserDto();
		
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql="DELETE FROM usertbl WHERE userID=?";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계 DB연결 성공");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			System.out.println("3단계 쿼리준비 성공");
			rs=psmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
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
				count=1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("6단계 DB닫기 실패");
			}
		}
		return count>0?true:false;
	}
}
