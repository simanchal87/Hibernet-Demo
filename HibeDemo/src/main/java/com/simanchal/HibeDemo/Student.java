package com.simanchal.HibeDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	
	@Id
	private int rollNo;
	private String sname;
	private double mark ;
	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sname=" + sname + ", mark=" + mark + "]";
	}
	
	
	
	

}
