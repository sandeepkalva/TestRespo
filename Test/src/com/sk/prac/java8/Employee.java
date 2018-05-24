package com.sk.prac.java8;

public class Employee {
	
	private String name;
	private int salary;
	private int id;
	private String group;
	
	public Employee(String name, int salary, int id, String group) {
		super();
		this.name = name;
		this.salary = salary;
		this.id = id;
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", id=" + id + ", group=" + group + "]";
	}

	
	
	
	

}
