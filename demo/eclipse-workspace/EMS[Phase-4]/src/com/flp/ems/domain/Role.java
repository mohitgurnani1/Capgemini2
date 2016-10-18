package com.flp.ems.domain;

public class Role {
String roleId,name,description;

public Role(){}

public Role(String roleId, String name, String description) {
	this.roleId = roleId;
	this.name = name;
	this.description = description;
}

public String getRoleId() {
	return roleId;
}

public void setRoleId(String roleId) {
	this.roleId = roleId;
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
}
