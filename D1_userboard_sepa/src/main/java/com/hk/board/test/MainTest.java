package com.hk.board.test;
import java.util.List;

import com.hk.board.daos.UserDao;
import com.hk.board.dtos.UserDto;

public class MainTest {
	public static void main(String[] args) {
		
		UserDao dao=new UserDao();
		
		//회원목록 조회
		List<UserDto> userList=dao.getAllUser();
		System.out.println("==회원목록==");
		for(int i = 0;i<userList.size();i++) {
			System.out.println(userList.get(i));
		}
		
		//회원정보 등록
		/* UserDto dto=new UserDto();
		 * dto.setUserID("JWY"); ... <- setter 메서드 사용할 경우
		 */
		
		 UserDto dto1=new UserDto("JWY","장원영",2004,"서울","010","22223333",173,null);
		 boolean isS=dao.insertUser(dto1); System.out.println("회원정보등록성공");
		userList=dao.getAllUser();
		System.out.println("==회원목록==");
		for(int i = 0;i<userList.size();i++) {
			System.out.println(userList.get(i));
		}
		System.out.println();
		System.out.println();
		
		//회원정보 수정
		boolean isSUpdate=dao.updateUser(new UserDto(
														"LSG",
														"이수근",
														2024,
														"제주",
														"011",
														"10101010",
														148
										));
		System.out.println("회원수정성공:" + isSUpdate);
		
		System.out.println();
		System.out.println();
		
		
		//회원정보 상세조회
		UserDto dto=dao.getUser("LSG");
		System.out.println(dto);
		
		System.out.println();
		System.out.println();
		
		
		//회원정보 삭제
		boolean isDelete=dao.deleteUser("JWY");
		System.out.println("회원 삭제 성공: "+isDelete);
		userList=dao.getAllUser();
		System.out.println("==회원목록==");
		for(int i = 0;i<userList.size();i++) {
			System.out.println(userList.get(i));
		}
	}
}
