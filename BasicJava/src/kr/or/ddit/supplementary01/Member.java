package kr.or.ddit.supplementary01;

public class Member {
	public String id;
	private String pass;
	private String name;
	private String addr1;//동까지 주소
	private String addr2;//세부주소
	private int age;
	
	public Member() {
		
	}
	
	public Member(String id, String pass, String name, int age) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
	}
	public int getAge() {//필드 값을 사용할수 있게하는 gettersetter
		return age;
	}
	public void setAge(int age) { //gettersetter로 조건!을 넣을수있음
		if(age<0) {
			System.out.println("0이하는 입력불가");
			return;
		}
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
}
