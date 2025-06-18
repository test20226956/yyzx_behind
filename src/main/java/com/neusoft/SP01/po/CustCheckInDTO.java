package com.neusoft.SP01.po;

//这是入住登记页面的表格字段视图类
//不与数据库进行交互

public class CustCheckInDTO {
//  入住登记id
    private Integer checkInRecordId;
//  老人姓名
    private String customerName;
//  客户年龄（讨论在前端还是后端计算）
    private Integer age;
//  性别
    private Integer gender;
//  身份证号
    private String identity;
//  血型
    private String bloodType;
//  客户本人的联系电话
    private String tel;
//  联系人
    private String familyName;
//  联系人电话
    private String familyTel;
//  楼层
    private String floor;
//  房间号
    private String room;
//  床位号
    private String bed;
//  入住时间
    private String checkInTime;
//  合约到期时间
    private String endTime;
	public Integer getCheckInRecordId() {
		return checkInRecordId;
	}
	public void setCheckInRecordId(Integer checkInRecordId) {
		this.checkInRecordId = checkInRecordId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyTel() {
		return familyTel;
	}
	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public CustCheckInDTO() {
		super();
	}
    
    
}
