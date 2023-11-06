package kr.or.ddit.study13.homework;

import java.util.ArrayList;
import java.util.List;

public class HistoGram {
	/*요구사항
	 * 주사위를 2개던져(랜덤) 총 주사위 합을 구한 후 전체 히스토그램을 구해볼것
	 * 1000번 시행 후 해당 값을 저장할것(list or map)
	 * 주사위 눈은 1~6으로 구현되어있음
	 * 
	 */
	List <Integer>diceList = new ArrayList(); //List 에 int형만 넣는다는뜻
	public static void main(String[] args) {
		HistoGram hg = new HistoGram();//불러오는 식들을 사용하기위해 만들어야함
		for(int i = 0; i<1000; i++) {
			int d =hg.throwDice();//주사위 두번던진값을 여기다 넣음
			hg.diceList.add(d);
		}
		hg.print();
		
	}
	
	public int throwDice() {//주사위를 랜덤으로 던져서 두값을 합하기
		int dice1=(int) (Math.random()*6+1);
		int dice2=(int) (Math.random()*6+1);
		int sum = dice1+dice2;
		return sum;
	}
//두번째방법	
//	public int throwDice() {
//		return new Random().nextInt(6)+1;
//	}
	
	public int diceCount(int num) {//오버로딩?을 사용하려면 같은 형만 사용가능해서 int x를 하나 꼭 써줘야함!
//		int num =0; 
		int count=0;
		for( int i :diceList) {// 주사위합계들 중에서~~ 
			if(i==num) {	  // num과 같은게 있으면(print메소드에서 i와 같은게 있다면) 카운트
				count++;
			}
		}return count;
		
	}
	
	public void print() {
		for(int i=0;i<=12;i++) {//여기에서 diceCount가 필요해서 생성함
		System.out.println("주사위의 합"+i+"는 "+diceCount(i) +"번 나옵니다.");
		}
	}
	
}	