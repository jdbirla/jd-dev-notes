package com.jd.interviewprep.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeCustomSortDepartment {
	public static void main(String[] args) {

		List<EmployeeNew> employees = Arrays.asList(new EmployeeNew(1, "JD", "HR"), new EmployeeNew(2, "Ram", "IT"),
				new EmployeeNew(3, "Ramesh", "Admin"));

		// Define the desired department order
		List<String> departmentOrder = Arrays.asList("IT", "HR", "Admin");

		// Sort the employees based on department using a custom comparator

		employees.sort(
				Comparator.comparing(EmployeeNew::getEmpDepartment, Comparator.comparingInt(departmentOrder::indexOf)));

		employees.forEach(employee -> System.out.println(employee.getEmpName() + " - " + employee.getEmpDepartment()));

	}
}
