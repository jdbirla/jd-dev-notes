package com.jd.inttest.core;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jd birla on 06-02-2023 at 11:26
 */
public class PracticeTest {

  public static void main(String[] args) {
//    String s = "string data to count each character";
//    Map<String, Long> map = Arrays.stream(s.replaceAll("\\W","").split(""))
//            .map(String::toLowerCase)
//            .collect(Collectors
//                    .groupingBy(str -> str,
//                            LinkedHashMap::new, Collectors.counting()));
//    map.forEach((k,v) -> System.out.println(k + "=" + v));
//
    List<Employee> employees = EmployeeDatabase.getEmployees();
    employees.stream()
            .collect(Collectors.groupingBy(
                    Employee::getDept,
                    LinkedHashMap::new,
                    Collectors.collectingAndThen(
                            Collectors.toList(),
                            list -> list.stream()
                                    .sorted(Comparator.comparingDouble(Employee::getSalary))
                                    .collect(Collectors.toList())
                    )
            ));


//    employeesByDeptSortedBySalary.forEach((department, deptEmployees) -> {
//      System.out.println("Department: " + department);
//      deptEmployees.forEach(employee -> System.out.println("  " + employee.getName() + " - Salary: " + employee.getSalary()));
//    });
  }

}


