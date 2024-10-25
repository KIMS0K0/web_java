package com.hk.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.database.DataBase;
import com.hk.dtos.RoleStatus;
import com.hk.dtos.UserDto;

public class UserDao extends DataBase{

	//싱글톤 패턴 : 객체를 한번만 생성하자
	//외부에 접근할때 new를 사용 못하게 하자: new UserDao()
	public static UserDao userDao;
	private UserDao() {}
	public static UserDao getUserDao() { // UserDao.getUserDao() 가능
		if(userDao==null) {
			userDao=new UserDao();//내부에서 객체생성 한번 함			
		}
		return userDao;
	}
	
	//사용자 기능
	
	//1. 회원가입 기능(enabled:'Y', role:'USER', regDate:SYSDATE() )
	//insert문 실행
	public boolean insertUser(UserDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" INSERT INTO USERINFO "
				 + " VALUES(NULL,?,?,?,?,?,'Y',?,SYSDATE())";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPassword());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, String.valueOf(RoleStatus.USER));
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//아이디 중복 체크하기
	public String idCheck(String id) {
		String resultId=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql="SELECT ID FROM USERINFO WHERE ID=?";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				resultId=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return resultId;
	}
	
	//로그인 기능: 파라미터 ID, Password
	public UserDto getLogin(String id, String password) {
		UserDto dto=new UserDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" SELECT ID, NAME, ROLE "
				 + " FROM USERINFO "
				 + " WHERE ID=? AND PASSWORD=? AND ENABLED='Y' ";
		
		try {
			conn=getConnection();
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		return dto;
	}
	
	//나의 정보 조회
	public UserDto getUser(String id) {
		UserDto dto=new UserDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" SELECT SEQ, ID, NAME, ADDRESS, EMAIL, ROLE, REGDATE "
				 + " FROM USERINFO "
				 + " WHERE ID=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setRole(rs.getString(6));
				dto.setRegDate(rs.getDate(7));
			}
			System.out.println(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		return dto;
	}
	
	//나의 정보 수정하기: 파라미터 - id , address, email
	public boolean updateUser(UserDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" UPDATE USERINFO SET ADDRESS = ?, EMAIL = ? "
				 + " WHERE ID = ? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getAddress());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getId());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	public boolean updateUserRole(UserDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" UPDATE userinfo SET ROLE = ? "
				 + " WHERE ID = ? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getRole());
			psmt.setString(2, dto.getId());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//회원 탈퇴 : enabled - 'N' 업데이트 , 파라미터: id
	public boolean delUser(String id) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" UPDATE USERINFO SET ENABLED = 'N' WHERE ID=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//ADMIN
	public List<UserDto> getAllUser(){
		List<UserDto> list=new ArrayList<>();
		
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql="SELECT id, name, address, email, enabled, role, regdate, seq "
				+ "FROM userinfo";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계 DB연결 성공");
			psmt=conn.prepareStatement(sql);
			System.out.println("3단계 쿼리준비 성공");
			rs=psmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
			while(rs.next()) {
				UserDto dto=new UserDto();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setEnabled(rs.getString(5));
				dto.setRole(rs.getString(6));
				dto.setRegDate(rs.getDate(7));
				dto.setSeq(rs.getInt(8));
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