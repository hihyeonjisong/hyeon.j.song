package kr.or.ddit.study06.exam2;

public class Animal {
	/*
	 * 동물 종,이름,날수있는지여부
	 * 평균수명, 무게, 현재나이
	 */
	String type;
	String type_name;
	boolean fly;
	int avg_age;
	int weight;
	int age;
	public Animal(String type, String type_name, boolean fly, int avg_age, int weight, int age) {
		this.type = type;
		this.type_name = type_name;
		this.fly = fly;
		this.avg_age = avg_age;
		this.weight = weight;
		this.age = age;
	}
	public Animal(Mammalia m, String type_name, boolean fly, int avg_age, int weight, int age) {
		this.type = m.type;
		this.type_name = type_name;
		this.fly = m.fly;
		this.avg_age = avg_age;
		this.weight = weight;
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
}
