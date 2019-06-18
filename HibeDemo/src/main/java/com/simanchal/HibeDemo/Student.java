package com.simanchal.HibeDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	
	@Id
	private int sId;
	private StudentsName sname;
	private String rollNo;
	
	@ManyToMany(mappedBy="students")
	private List<Laptop> laptops = new ArrayList<Laptop>();
	
	
	public List<Laptop> getLaptop() {
		return laptops;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptops = laptop;
	}
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
