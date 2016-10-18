package com.flp.ems.domain;

public class Project {
String projId,name,description;
String deptId;
public Project(){}
public Project(String projId, String name, String description, String deptId) {
	this.projId = projId;
	this.name = name;
	this.description = description;
	this.deptId = deptId;
}
public String getProjId() {
	return projId;
}
public void setProjId(String projId) {
	this.projId = projId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDeptId() {
	return deptId;
}
public void setDeptId(String deptId) {
	this.deptId = deptId;
}
}
