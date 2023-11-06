package kr.or.ddit.study06.exam1;

public class Tv {	//Tv란 class
	String company; //각각의 field(여러가지를 담을수있는)
	int year;
	double size;
	
	@Override
	public String toString() {
		return "Tv [company=" + company + ", year=" + year + ", size=" + size + "]";
	}
	
}
