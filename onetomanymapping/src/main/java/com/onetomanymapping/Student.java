package com.onetomanymapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stu")
public class Student {
	@Id
	private int stu_Id;
	private String name;
	private String branch;
	public int getStu_Id() {
		return stu_Id;
	}
	public void setStu_Id(int stu_Id) {
		this.stu_Id = stu_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [stu_Id=" + stu_Id + ", name=" + name + ", branch=" + branch + "]";
	}

}
