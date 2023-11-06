package kr.or.ddit.supplementary01;

public class Main2 {
	public static void main(String[] args) {
		Member m1 = new Member();
		String id = m1.id ;
//		String pass = m1.Pass();
		m1.setId("m1의id");
		m1.setPass("m1의pass");
		m1.setName("m1의name");
		m1.setAge(-20);
		Member m2 = new Member();
		m2.setId("m2의id");
		m2.setPass("m2의pass");
		m2.setName("m2의name");
		m2.setAge(20);
		Member m3 = new Member("m3의id","m3의pass","m3의name",20);
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
	}
}
