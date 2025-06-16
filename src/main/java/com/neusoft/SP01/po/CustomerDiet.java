package com.neusoft.SP01.po;

public class CustomerDiet {
	private Integer customerDietId;
	private Integer customerId;
	private String flaver;
	private String restraint;
	private String comment;
	public Integer getCustomerDietId() {
		return customerDietId;
	}
	public void setCustomerDietId(Integer customerDietId) {
		this.customerDietId = customerDietId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFlaver() {
		return flaver;
	}
	public void setFlaver(String flaver) {
		this.flaver = flaver;
	}
	public String getRestraint() {
		return restraint;
	}
	public void setRestraint(String restraint) {
		this.restraint = restraint;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public CustomerDiet() {
		super();
	}
	
	
}
