package kr.or.ddit.study03;

public class AssignmentOperator {

	public static void main(String[] args) {
		// = : '=' 오른쪽의 값을 '=' 왼쪽에 저장 우선순위가 가장 늦다
		//'='과 다른연산자가 결합
		//a= a+b  a+=b 
		//a= a*b  a*=b
		//a= a/b  a/=b
		//a= a-b  a-=b
		//a= a&b  a&=b (잘안씀)
		
		//같은값
		//a=a+b; a자기자신한테 a+b를 넣는것임 
		//a+=b;
		
		int a =10;
		int b = 4;
		System.out.println("a=a+b =>" + "a +=b=>"+(a +=b));//a+b값인 14를 a에 넣어줌
		System.out.println("a=a*b =>" + "a *=b=>" +(a *=b));//a값인 14에 4를 곱해서 56
		System.out.println("a=a-b =>" + "a -=b=>" +(a -=b));//a값인 56에 4를 빼서 52
		
		System.out.println(a/=b); 
		
		
		
	}

}
