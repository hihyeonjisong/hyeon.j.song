package kr.or.ddit.study13;

public class ArrayTest {
	private int size = 10;//사이즈 초기값은 정해져있음 //private:외부에서 사용못하게 막음
	private int cur =0;
	String arr[];
	
	public ArrayTest() { //생성자
		this.arr = new String[size]; //10자리 배열을 선언
	}
	
	public void add(String s) {
		if(cur ==size) {
			size = size+10;//자동 확장 //왜 하는거지?
			String temp[] = arr.clone(); //새로운 객체 만들고 ->복사하려함
			arr = new String[size];
			for (int i = 0; i < temp.length; i++) {
				arr[i] =temp[i];
			}
		}
		arr[cur++] =s; //초기값은 0 -> 1 ->2 ...(자동으로 배열에 값이 입력됨)
	}
	
	public int size() { //배열길이 알려줌
		return cur;
	}
	
	
	
}
