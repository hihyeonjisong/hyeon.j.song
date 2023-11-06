package kr.or.ddit.study06.Homework;

import java.util.Scanner;

public class Homework5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 값을 입력받을때 씀 (scanner sc를 쓸거야)
		
		Member m1 = new Member("ywh","1111","양형운");
		Member m2 = new Member("shj","2222","송현지");
		Member m3 = new Member("sis","3333","성이수");
		Member m4 = new Member("sms","4444","신민수");
		Member m5 = new Member("saj","5555","서어진");
		System.out.println(m1);
		
		/*
		 * 멤버 클래스를 5명 배열을 선언 후
		 * 배열에 5명 저장 할것.
		 */
		Member[] mArr = {
				 m1,m2, m3, m4, m5
		};
		/*
		 * 멤버중 한명 선택후 
		 * 아이디와 비밀번호를 입력해서 맞을 경우 
		 * -> 로그인 성공
		 * 실패 할경우 
		 * -> 아이디 , 비밀번호 일치 하지 않음 출력 
		 * 
		 */
		
		// 멤버 이름 출력 
		for(int i=0; i<mArr.length;i++) {
			System.out.println(mArr[i].name);
		}
		// 멤버 배열 선택
		System.out.println("1~5숫자를 입력하시오");
		int select = sc.nextInt()-1; // 1을 입력했을때 0번째로 인식되어야해서 -1해줌

		
		while(true) {
			// 아이디 
			String id = sc.next();
			String pw = sc.next();
			boolean bid = mArr[select].id.equals(id); //객체끼리 비교할땐 .equals꼭 써줘야함!
			boolean bpw = mArr[select].pass.equals(pw);
			// 비밀번호 
			// 비교문 통과 여부 확인.
			/*
			 * if("")
			 */
			if(bid && bpw) {
				System.out.println("로그인 성공");
				break;
			}
			System.out.println("아이디 또는 비밀번호 오류");
		}
		System.out.println(mArr[select]);
		
		
	}

}
class Member {
	String nation;
	String group;
	String id;
	String pass;
	String name;
	
	/*
	 * 국가 = 한국 
	 * group = 403호	 를 기본으로 하고 
	 * id , pass, name를 입력 가능하도록 하는    
	 * Member 생성자를 만들자. (.equal )
	 * 
	 */
	public Member(String id,String pass, String name){
		this("한국","403",id,pass,name);
	
			}
	public Member(String nation, String group, String id, String pass, String name) {
		;
		this.nation = nation;
		this.group = group;
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	/*
	 * toString 메소드를 통해 값을 바로 출력하도록 할것.
	 */

	@Override
	public String toString() {
		return "Member [nation=" + nation + ", group=" + group + ", id=" + id + ", pass=" + pass + ", name=" + name
				+ "]";
	}
	
}
