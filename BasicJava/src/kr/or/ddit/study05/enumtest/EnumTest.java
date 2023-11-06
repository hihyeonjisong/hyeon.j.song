package kr.or.ddit.study05.enumtest;

public class EnumTest {
	public static void main(String[] args) {
		WEEK fri = WEEK.FRI;
		
		String week = "";
		
		if(week.equals("fri")) {
			System.out.println("금요일 입니다.");
		}
		
		for(WEEK w : WEEK.values()){
			if(w == WEEK.FRI) {
				System.out.println("금요일 입니다.");
			}
		}
	}
}
