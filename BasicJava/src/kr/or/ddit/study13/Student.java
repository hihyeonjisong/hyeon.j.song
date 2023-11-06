package kr.or.ddit.study13;

public class Student {

		// 5명의 3과목(국 영 수 점수) 성적과 이름을 선언저장하고 // class는 타입을 자유롭게 선언할수있음
	    // 총점과 평균 등수를 구하여 출력해라
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		int rank;
		
		public Student() { // alt shift s->generate field
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.sum = sum;
			this.avg = avg;
			this.rank = rank;
			
		}
		@Override //보고싶은 값 출력하려고 override사용
		public String toString() {
			return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
					+ avg + ", rank=" + rank + "]";
			
		
		}
		

}
