package kr.or.ddit.study06.exam4;

public class PersonVo {//vo ~:데이터를 담기위한 공감이다
	String name;
	int		age;
	String nation;
	
	
	public PersonVo (String name, int age, String nation) {
		super();
		this.name = name;
		this.age = age;
		this.nation = nation;
	}

	@Override
	public String toString() {
		return "PersonVo [name=" + name + ", age=" + age + ", nation=" + nation + "]";
	}
	public int getAge() {//데잍터 가져올대씀
		return age;
	}
	
	public void setAge (int age) {//데이터 입력할때씀
		if(age<0) {
			System.out.println("음수는 입력할수 없습니다");
		}else {
			this.age =age;
		}
//		this.age =age;
	}

	public String getName() { //alt shift s -generate getter and setter(밑의 4형태)
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	
}
