package kr.or.ddit.study05;


public class ObjectArrayExample2 {
	public static void main(String[] args) {
		Student[] sArr = new Student[5]; //학생 5명을 공간을 만들겠다
		sArr[0] = new Student("홍길동", 80, 70, 80, 0, 0, 1); //객체 생성(0번째 학생 만듦)
		sArr[1] = new Student("강감찬", 90, 85, 90, 0, 0, 1); //
		sArr[2] = new Student("이성계", 90, 70, 75, 0, 0, 1);
		sArr[3] = new Student("이순신", 65, 75, 70, 0, 0, 1);
		sArr[4] = new Student("정몽주", 90, 80, 75, 0, 0, 1);
		
		
				
		System.out.println(sArr[0]);
		System.out.println(sArr[1]);
		System.out.println();
		
		for (int i = 0; i < sArr.length; i++) {
			sArr[i].sum = sArr[i].kor +sArr[i].eng +sArr[i].math;
			sArr[i].avg = (double)sArr[i].sum/3; //평균
		}
		for (int i = 0; i < sArr.length; i++) { //rank구하기
			for (int j = 0; j < sArr.length; j++) {
				if( sArr[i].sum<sArr[j].sum) {
					sArr[i].rank +=1;
				}
			}
		}
		for (int i = 0; i < sArr.length; i++) {
			System.out.println(sArr[i]);
		}
	}
}

class Student{
	// 5명의 3과목(국 영 수 점수) 성적과 이름을 선언저장하고 // class는 타입을 자유롭게 선언할수있음
    // 총점과 평균 등수를 구하여 출력해라
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	int rank;
	
	public Student(String name, int kor, int eng, int math, int sum, double avg, int rank) { // alt shift s->generate field
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
		this.rank = rank;
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
				+ avg + ", rank=" + rank + "]";
		
	
	}
	
	
	
}