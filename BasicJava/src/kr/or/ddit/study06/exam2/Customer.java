package kr.or.ddit.study06.exam2; //다시 입력하기, 오버로드오버라이드면접단골

public class Customer {
	//아이디 비밀번호 만들어보기    , class를 만들기위해선 객채를 만들어야함 , 기본으로 생성됨
	String nation = "한국"; //생성자에서 굳이 한국을 입력안하게 할수 있다.
	String id;
	String pw;
	String name;
	int age;
	
	public Customer() {
		System.out.println("기본 생성자 입니다.");// 아무것도 안한 기본생성자
	}
	
	// 동일한 생성자명,메소드명에서 파라미터값만 달라지는것을 오버로딩이라고 한다.
	public Customer(String id, String pw, String name, int age) {//(외부에서입력된정보)
		
		this.id = id; //class에서 생성된 id(class내부id)
		this.pw = pw;
		this.name = name;
		this.age = age;//기본값으로 정하면 출력할때 자동으로 나옴
		
		System.out.println("1번 생성자");
	}
	
	public Customer(String id, String pw, String name ) {
//		this.id = id; 
//		this.pw = pw;
//		this.name = name;
		this(id,pw,name,30);
		System.out.println("2번 생성자");
	}

	@Override //오버라이드 :
	public String toString() {
		return "Customer [nation=" + nation + ", id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + "]";
	}


	
	
	
//	private Customer() { //private는 내부에서만 사용가능함
//		
//	}
	
	
}
