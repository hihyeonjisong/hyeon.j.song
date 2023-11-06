package kr.or.ddit.supplementary01;

public class MemberVo {
	//field :데이터 저장
		static int call = 0;
		String id;
		String pass;
		String name;
		String addr1;//동까지 주소
		String addr2;//세부주소
		
		//method : 사용하기위함
		public void call() {
			System.out.println(id+"\t"+name);
			System.out.println("call메소드가 호출되었습니다.");
			call++;
			String return_call2 = call2("파라미터1");//1.call2로 파라미터1을 보냄
			System.out.println("call에서 받은"+return_call2);
		}
		
		//     (여기)return값의 결과는 여기에 적는다
		public String call2(String param1) {//2."파라미터1"이 param1에 들어옴
			System.out.println("call2메소드가 호출되었습니다.");
			System.out.println("call2에서 " +param1);
			return "call2에서 보낸 리턴값";
		}
		
		public static void test() {
//			id="";//static메소드에선 일반 변수들 못가져옴,static변수만 사용가능
//			call();
		}
		
		//constraint(생성자)
}
