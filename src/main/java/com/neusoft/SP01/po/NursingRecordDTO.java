package com.neusoft.SP01.po;

public class NursingRecordDTO extends NursingRecord{
    private Integer nursingRecordId;
    //和项目有关的部分
    private String projectName;
    private String description;

    //护理人员
    private String nurse;
    private String nurseTel;
	public Integer getNursingRecordId() {
		return nursingRecordId;
	}
	public void setNursingRecordId(Integer nursingRecordId) {
		this.nursingRecordId = nursingRecordId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNurse() {
		return nurse;
	}
	public void setNurse(String nurse) {
		this.nurse = nurse;
	}
	public String getNurseTel() {
		return nurseTel;
	}
	public void setNurseTel(String nurseTel) {
		this.nurseTel = nurseTel;
	}
	public NursingRecordDTO() {
		super();
	}
    
    



}
