package com.sk.prac.java8;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeOperate {
	public static void main(String[] args) {
		ArrayList<Employee> employeeList = createEmployeeList();
		System.out.println("---------------------------");
		System.out.println("Max Salary in ORG: "+maxSalaryInOrg(employeeList));
		System.out.println("---------------------------");
		totalCostToOrg(employeeList);
		System.out.println("---------------------------");
		topEmpbySalandGrp(employeeList);
		System.out.println("---------------------------");
		listGroupEmp(employeeList);
		System.out.println("---------------------------");
	}

	private static void listGroupEmp(ArrayList<Employee> employeeList) {
		Map<String, List<Employee>> empList = employeeList.stream().collect(Collectors.groupingBy(Employee::getGroup));
		for(Entry<String, List<Employee>> emp:empList.entrySet()) {
			System.out.println(emp.getKey()+"::"+emp.getValue());
		}

	}

	private static void topEmpbySalandGrp(ArrayList<Employee> employeeList) {

		Map<String, Optional<Employee>> empList = employeeList.stream().collect(Collectors.groupingBy(Employee::getGroup,
				Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
				));

		//to remove optional we use

		Map<String, Employee> empList2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGroup,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)
				));

		for(Entry<String, Optional<Employee>> emp:empList.entrySet()) {
			System.out.println(emp.getKey()+"::"+emp.getValue().get());
		}

	}

	private static void totalCostToOrg(ArrayList<Employee> employeeList) {

		Integer ss = employeeList.stream().map(e->e.getSalary()).reduce((a,b)->a+b).get();
		System.out.println("Total Cost:"+ss);


	}

	private static int maxSalaryInOrg(ArrayList<Employee> employeeList) {

	//	return employeeList.stream().reduce((Employee e1,Employee e2)-> e1.getSalary()>e2.getSalary()?e1:e2).orElse(null).getSalary();
		return employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))).get().getSalary();

	}

	private static ArrayList<Employee> createEmployeeList() {
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Sanjay", 15000, 65478, "HR"));
		employeeList.add(new Employee("Raghu", 90000, 65478, "HR"));
		employeeList.add(new Employee("Kiran", 30000, 65478, "HR"));
		employeeList.add(new Employee("Rajiv", 40000, 65478, "QA"));
		employeeList.add(new Employee("Srikanth", 44000, 65478, "QA"));
		employeeList.add(new Employee("Mahan", 56000, 65478, "DEV"));
		employeeList.add(new Employee("Rahul", 12010, 65478, "DEV"));
		return employeeList;
	}
}
