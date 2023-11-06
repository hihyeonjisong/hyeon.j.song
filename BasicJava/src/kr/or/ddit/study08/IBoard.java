package kr.or.ddit.study08;

import java.util.Scanner;

public interface IBoard {
	
	public void writeBoard(String title, String content,String id){
	
	//1.DB에서 이름가져오기
	//id null일 경우 로그인 시키기
	ILogin login = new LoginImple();
	Scanner sc = new Scanner(System.in);
	if(id== null)
	id = sc.next();
	String pass= sc.next();
	login.login(id,pass);
 }
}
