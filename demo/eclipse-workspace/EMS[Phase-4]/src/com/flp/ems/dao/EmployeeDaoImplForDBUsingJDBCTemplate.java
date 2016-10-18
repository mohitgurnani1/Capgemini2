package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

@Repository
public class EmployeeDaoImplForDBUsingJDBCTemplate implements IEmployeeDao {

	
	DataSource datasource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	Properties prop;
	Connection conn;
	
	@Autowired
	public EmployeeDaoImplForDBUsingJDBCTemplate(DataSource datasource)  {
		this.datasource = datasource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		prop=new Properties();
		try
		{
		//prop.load(new FileInputStream("D:/git/Capgemini/demo/eclipse-workspace/EMS[Phase-3]/properties/dbDetails.properties"));
		prop.load(this.getClass().getClassLoader().getResourceAsStream("dbDetails.properties"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
 }
 
 
 
	@Override
	public void AddEmployee(Employee emp) {
		
		String sql=prop.getProperty("jdbc.query.insertEmployee");
		BeanPropertySqlParameterSource sqlParameterSource;
		sqlParameterSource = new BeanPropertySqlParameterSource(emp);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);	
				
	}

	@Override
	public boolean ModifyEmployee(Employee emp) {
	
		
		String sql=prop.getProperty("jdbc.query.modifyEmployee");
		BeanPropertySqlParameterSource sqlParameterSource;
		sqlParameterSource = new BeanPropertySqlParameterSource(emp);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);	
		String sql2=prop.getProperty("jdbc.query.insertEmployee");
		namedParameterJdbcTemplate.update(sql2, sqlParameterSource);	
		return 	namedParameterJdbcTemplate.update(sql2, sqlParameterSource)==1;	
	}

	@Override
	public boolean RemoveEmployee(String key, String value) {
		String sql=prop.getProperty("jdbc.query.removeEmployee");
		Map<String,String> map=new HashMap<String,String>();
		map.put("key", key);
		map.put("value", value);
		return namedParameterJdbcTemplate.update(sql, map)==1;	
	
			}

	@Override
	public Employee SearchEmployee(HashMap<String, String> emp) {
		String sql="Select * from employee where ";
		
				
			Set set=emp.entrySet();
			int i=0;
			for(Object o:set)
			{
				i++;
				Map.Entry<String, String> m=(Map.Entry<String, String>)o;
				if(i==set.size())
					sql+=m.getKey()+"='"+m.getValue()+"'";
				else	
					sql+=m.getKey()+"='"+m.getValue()+"' or ";
				
			}
	
			
			Employee employee = (Employee)jdbcTemplate.queryForObject(
					sql, new BeanPropertyRowMapper<Employee>(Employee.class));

	return employee;
	
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
	String selectSQL = prop.getProperty("jdbc.query.SAE");
	
	List<Employee> employee  = jdbcTemplate.query(selectSQL,new BeanPropertyRowMapper<Employee>(Employee.class));

	for(Employee e:employee){
		System.out.println("");
	}
	
	System.out.println(employee.size());
	return new ArrayList<Employee>(employee);
	}

	public ArrayList<Department> getDepartmentList() {
		
		String selectSQL = prop.getProperty("jdbc.query.SAD");
		List<Department> deptList  = jdbcTemplate.query(selectSQL,new BeanPropertyRowMapper<Department>(Department.class));
			return new ArrayList<Department>(deptList);
	}

	public Department getDeptById(String deptid){
		String selectSQL = prop.getProperty("jdbc.query.SD");
		System.out.println("deptid="+deptid);
	
		System.out.println("sql="+selectSQL);
		
		Department dept = (Department)jdbcTemplate.queryForObject(
				selectSQL, new Object[] { deptid },new BeanPropertyRowMapper<Department>(Department.class));
		return dept;
		}
	
	public Role getRoleById(String roleId){
		
		String selectSQL = prop.getProperty("jdbc.query.SR");
		Role role = (Role)jdbcTemplate.queryForObject(
				selectSQL, new Object[] { roleId },new BeanPropertyRowMapper<Role>(Role.class));
		return role;

	}
		
	public Project getProjectById(String projId){
		String selectSQL = prop.getProperty("jdbc.query.SP");
		Project proj = (Project)jdbcTemplate.queryForObject(
				selectSQL, new Object[] { projId },new BeanPropertyRowMapper<Project>(Project.class));
		return proj;
		}
	
	public ArrayList<Project> getProjectList(String deptid) {
		String selectSQL = prop.getProperty("jdbc.query.SAP");
	
		List<Project> projectList  = jdbcTemplate.query(selectSQL,new Object[] { deptid },new BeanPropertyRowMapper<Project>(Project.class));
		return new ArrayList(projectList);
	}

	public ArrayList<Role> getRoleList() {
		String selectSQL = prop.getProperty("jdbc.query.SAR");
		List<Role> roleList  = jdbcTemplate.query(selectSQL,new BeanPropertyRowMapper<Role>(Role.class));
		return new ArrayList(roleList);	
	}

	public Employee getEmployeeByEmailId(String emailId) {
			String selectSQL = prop.getProperty("jdbc.query.SE");
			Employee emp = (Employee)jdbcTemplate.queryForObject(
				selectSQL, new Object[] { emailId },new BeanPropertyRowMapper<Employee>(Employee.class));
			return emp;
	}

	public boolean RemoveEmployeeByKinId(String value) {
		String sql=prop.getProperty("jdbc.query.removeEmployeeKin");
	return jdbcTemplate.update(sql,value)==1;	
	}

	public boolean RemoveEmployeeByName(String value) {
		String sql=prop.getProperty("jdbc.query.removeEmployeeName");
		return jdbcTemplate.update(sql,value)==1;	
}

	public boolean RemoveEmployeeByEmailId(String value) {
		String sql=prop.getProperty("jdbc.query.removeEmployeeEmail");
		return jdbcTemplate.update(sql,value)==1;	

	}

}
