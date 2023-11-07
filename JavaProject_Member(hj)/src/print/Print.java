package print;

import java.util.List;

import vo.Book;
import vo.Member;

public class Print {

	public void printVar() {
		System.out.println("----------------------------------");
	}

	public void printLn(int num) {
		for (int i = 0; i < num; i++)
			System.out.println();
	}

	public void printHome() {
		printVar();
		System.out.println("1. MANAGER");
		System.out.println("2. MEMBER");
		printLn(6);
		printVar();
	}

	public void printAdmin() {
		printVar();
		System.out.println("1. 신규등록");
		System.out.println("2. 업데이트");
		System.out.println("3. 삭제");
		System.out.println("4. 로그아웃");
		printLn(3);
		printVar();
	}

	public void printMemberhome() {
		printVar();
		System.out.println("1. 회원가입");
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 회원탈퇴");
		System.out.println("4. 로그아웃");
		System.out.println("5. 종료");
		printLn(3);
		printVar();
	}
	
	public void printManagerLoginMenu() {
		printVar();
		System.out.println("1.로그인하기");
		System.out.println("2.회원가입하기");
		System.out.println("3.뒤로가기");
		printLn(5);
		printVar();
		
	}
	
	public void printMemberList(List<Member> list) {
		printVar();
		System.out.println("회원번호\t아이디\t비밀번호\t이름\t나이\t호수\t탈퇴여부");
		for (Member m : list) {
			System.out.printf("%d\t%s\t%s\t%s\t%d\t%s\t%s\t",m.getMem_no(),m.getMem_id(),m.getMem_pass(),m.getMem_name(),m.getMem_age(),m.getMem_room(),m.getMem_delete());
			System.out.println();
		}
		printVar();
	}

//	public void printBookList(List<Book> list) {
//		System.out.println("책이름\t출판사\t저자 \t내용\t가격");
//		for (Book book : list) {
//			System.out.printf("%s\t%s\t%s\t%s\t%d\t", book.getName(), book.getCompany(), book.getWriter(),
//					book.getCon(), book.getSale());
//			System.out.println();
//		}
//		printVar();
//	}

	

}
