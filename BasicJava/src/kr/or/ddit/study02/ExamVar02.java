package kr.or.ddit.study02;

public class ExamVar02 {
	public static void main(String[] args) 
	{
		//숙제1 
		//변수사용:1년은 365.2422일이다. 이것을 xxx일 xx시간 xx분 xx초로 나타내라
		//결과물->1년은 365일 5시간 48분 48초 이다.		
		//System.out.println("1년은 " +i+ "일 "+j+"시간 48분 48초 이다." );		
				
		//char k = 'A';
		//int s = k + 32;
		//char m = (char)s;
		//System.out.println(m);
		
		//365일
		double d = 365.2422;
		int year = (int)d; //365일
		
		//5시간
		double day =0.2422;//0.2422일  (1일=24시간)
		double day2= day*24;//5.8128시간
		int hour = (int)day2;//5시간
		
		//48분
		double hour2 = day2-hour;//0.8128시간  (1시간=60분)
		double hour3 = hour2*60;//48.7680분
		int  min= (int)hour3;//48분
		
		//46초
		double min2 = hour3-min;//0.7680분  (1분=60초)
		double min3 = min2*60; // 46.08초
		int sec = (int)min3; // 46초
		
		System.out.println("1년은 " +year+ "일 "+hour +"시간 "+ min +"분 "+sec+"초 이다.");
			
		//숙제2
		// a를 추출하기
		
		char k='A'; // char는 문자로 변환 (아스키코드 A는 65)
		int l = k +32;// 97
		char m = (char)l;//char는 문자로 변환 (97->아스키코드로 a)
		
		System.out.println(m);
	
		
					
	}

}
