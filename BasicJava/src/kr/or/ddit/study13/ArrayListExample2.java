package kr.or.ddit.study13;

import java.util.ArrayList;

public class ArrayListExample2 {
	public static void main(String[] args) {
//		Student[] sArr = new Student[5]; //학생 5명을 공간을 만들겠다
//		sArr[0] = new Student("홍길동", 80, 70, 80, 0, 0, 1); //객체 생성(0번째 학생 만듦)
//		sArr[1] = new Student("강감찬", 90, 85, 90, 0, 0, 1); //
//		sArr[2] = new Student("이성계", 90, 70, 75, 0, 0, 1);
//		sArr[3] = new Student("이순신", 65, 75, 70, 0, 0, 1);
//		sArr[4] = new Student("정몽주", 90, 80, 75, 0, 0, 1);
		
		
		Student s1 = new Student("홍길동", 80, 70, 80, 0, 0, 1); //객체 생성(0번째 학생 만듦)
		Student s2 = new Student("강감찬", 90, 85, 90, 0, 0, 1); //
		Student s3 = new Student("이성계", 90, 70, 75, 0, 0, 1);
		Student s4 = new Student("이순신", 65, 75, 70, 0, 0, 1);
		Student s5 = new Student("정몽주", 90, 80, 75, 0, 0, 1);
		
		ArrayList al = new ArrayList();//import 필요
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		System.out.println("리스트의사이즈:"+ al.size());//.size로 크기 표현함
		for(Object s:al){ //list는 향상된 for 문 사용가능함
			System.out.println(s);
		}
		Student s6 = new Student("정몽주1",80,80,70,0,0,1);
		al.add(s6);    
		al.remove(s3);//지울 객체를 직접 넣으면 됌->간단해짐
//		al.remove(2); //지울 순서를 지정(0부터시작)
		System.out.println("리스트의 사이즈:"+al.size());
		
		for(Object s:al){ //list는 향상된 for 문 사용가능함
			System.out.println(s);
		}
		if(al.contains(s2)){ //.contains: 포함 여부 확인
			System.out.println(s2+"이 포함됨");
		}
	}
}
