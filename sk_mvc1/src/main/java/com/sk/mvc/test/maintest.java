package com.sk.mvc.test;
import java.util.*;

import com.sk.mvc.daos.ManagerDao;
import com.sk.mvc.dtos.ManagerDto;

public class maintest {
	public static void main(String[] args) {
		ManagerDao dao=new ManagerDao();
		
		//회원목록 조회
		List<ManagerDto> userList=dao.getAllUser();
		System.out.println("==회원목록==");
		for(int i = 0;i<userList.size();i++) {
			System.out.println(userList.get(i));
		}
		
		userList=dao.logIn("JWY", "qwert");
		System.out.println("==회원목록==");
		for(int i = 0;i<userList.size();i++) {
			System.out.println(userList.get(i));
		}
	}
}
