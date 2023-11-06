package kr.or.ddit.study02;

public class StringExample {
	public static void main(String[] args) { 
		// 문자와 문자열
		// 문자: 한글자로 ''로 묶어서 선언=> char
		// 문자열 : 복수개의 글자로 구성된 자료(데이터 타임은 아님)
		// "" 로 묶어 선언  => String
		
		String name = "홍길동";
		String name2 = new String("홍길동2");
		String namesum = name+", "+name2;//String을 합칠땐 더하기로 합침
		System.out.println(namesum);
		
		// \n : 개행 스크린 커서 위치를 다음줄의 처음으로 옮김
		// \t : 수평탭 스크린 커서를 다음 탭으로 옮김
		// \r : 캐리지리턴 스크린 커서의 위치를 현재 줄의 처음으로 옮김 (n과 같은 역할)
		// \\ :역슬래시 문자를 출력할때 사용.
		// \" : 큰따옴표를 사용할때 사용 (큰따옴표라는 문자)
		// \' : 작은따옴표를 사용할때 사용
		// \b : 백스페이스
		
		String nameEnter = name + "\n" +name2;
		System.out.println(nameEnter);
		
		String nameTab = name +"\t" +name2;
		System.out.println(nameTab);
		
		String nameTTA = "\""+ name+","+name2+"\"";
		System.out.println(nameTTA);
		
		
		String year = "20"+23; //String은 자동으로 int가 ..
		System.out.println(year);
		
		String sDouble = "20" +23.3;
		System.out.println(sDouble);
		
		
		
		char c='a';
		String sChar2 = "20"+c;
		System.out.println(sChar2);
		
		String str ="나는 \"자바\"를 좋아합니다."; //  \"=>"로 출력됨
		System.out.println(str);
		
		
		
		
	}

}
