package com.neusoft.SP01.po;

import com.baomidou.mybatisplus.annotation.TableId;

public class Dept {
	@TableId
	private Integer deptno;
	private String loc;
	private String dname;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	

	public Dept(Integer deptno, String loc, String dname) {
		super();
		this.deptno = deptno;
		this.loc = loc;
		this.dname = dname;
	}
	

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
