package kr.or.ddit.study06.exam5.db;

public class EmpVO {
	String empid;
	String name;
	String dept;
	
	
	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "EmpVO [empid=" + empid + ", name=" + name + ", dept=" + dept + "]";
	}
}
