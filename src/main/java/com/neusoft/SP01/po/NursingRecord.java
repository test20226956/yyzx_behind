package com.neusoft.SP01.po;

public class NursingRecord {
	private String time;
	private Integer nursingRecordId;
	private Integer nusrssingServiceId;
	private Integer customerId;
	private Integer count;
	private Integer userId;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getNursingRecordId() {
		return nursingRecordId;
	}
	public void setNursingRecordId(Integer nursingRecordId) {
		this.nursingRecordId = nursingRecordId;
	}
	public Integer getNusrssingServiceId() {
		return nusrssingServiceId;
	}
	public void setNusrssingServiceId(Integer nusrssingServiceId) {
		this.nusrssingServiceId = nusrssingServiceId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public NursingRecord() {
		super();
	}
	
	
}
