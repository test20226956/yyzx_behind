package com.neusoft.SP01.po;

public class CustomerDiet {
	private Integer customerDietId;
	private Integer customerId;
	private String flavor;
	private String restraint;
	private String comment;
	private Integer state;
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
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
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
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
