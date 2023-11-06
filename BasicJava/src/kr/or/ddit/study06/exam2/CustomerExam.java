package kr.or.ddit.study06.exam2;

public class CustomerExam {
	public static void main(String[] args) {
//		Customer c1 = new Customer(); //Customer() :생성자 
//		c1.id   ="yhw"; //생성자를 통해 일을 줄일수있음
//		c1.pw = "1234";
//		c1.name = "양형운";
//		c1.age  = 30;
		
		Customer c1 = new Customer("yhw","1234","양형운",30); //Customer() :생성자 
		Customer c2 = new Customer("kye","1234","권예은"); 
//		Customer c3 = new Customer(); //생성자를 따로 안만들었을경우 기본생성자가 생성되지 않는다.
		System.out.println(c1);
		System.out.println(c2);
	}
}
