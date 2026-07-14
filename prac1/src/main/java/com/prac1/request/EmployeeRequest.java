package com.prac1.request;

public class EmployeeRequest {
	String name;
	Double salary;
	String departmentName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "EmployeeRequest [name=" + name + ", salary=" + salary + ", departmentName=" + departmentName + "]";
	}
	
	
}
