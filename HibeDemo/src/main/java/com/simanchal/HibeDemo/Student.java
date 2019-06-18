package com.simanchal.HibeDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="st1")
public class Student {
	
	@Id
	private int sId;
	private StudentsName sname;
	private String rollNo;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	
		
	public StudentsName getSname() {
		return sname;
	}
	public void setSname(StudentsName sname) {
		this.sname = sname;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", rollNo=" + rollNo + "]";
	}
	
	

}
