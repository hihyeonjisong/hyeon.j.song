package kr.or.ddit.study06.exam1;

public class TvExam { 
	public static void main(String[] args) {
		Tv t1 = new Tv();//Tv 선언을 하면 T1클래스를 가져올수있음
		t1.company = "LG"; //t1.을 쓰면 가져올수있음 ( ctrl+click ->참조한 class로 이동함)
		t1.year	   = 2021; 
		t1.size    = 81.5;
		
		Tv t2 = new Tv();//t1은 팥넣는 붕어빵틀 t2는 슈크림넣는 붕어빵틀 (각각 다른공간)
		t1.company = "samsung";
		t1.year	   = 2022;
		t1.size    = 60;
		
		System.out.println(t1);
		System.out.println(t2);
		
	}
}
