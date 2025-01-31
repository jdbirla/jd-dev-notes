package com.jd.interviewprep.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jd birla on 02-02-2023 at 13:33
 */
public class EmployeeDatabase {
    public static List<Employee> getEmployees() {
        return Stream.of(
                new Employee(101, "Ram", "A", "Manager", 60000, List.of((new Address("Indore", "India")), (new Address("Pune", "India")))),
                new Employee(102, "Raju", "B", "IT", 70000, List.of((new Address("Chennai", "India")), (new Address("Bangalore", "India")))),
                new Employee(103, "Abhijit", "C", "DEV", 80000, List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India")))),
                new Employee(104, "Bhupendra", "D", "BAU", 50000, List.of((new Address("Indore", "India")), (new Address("Mumbai", "India")))),
                new Employee(105, "Niranjan", "A", "Lead", 120000, List.of((new Address("Chennai", "India")), (new Address("Tokyo", "Japan")))),
                new Employee(106, "Sunil", "B", "IT", 80000, List.of((new Address("Chennai", "India")), (new Address("Bangalore", "India")))),
                new Employee(107, "Gajanand", "A", "Manager", 120000, List.of((new Address("Indore", "India")), (new Address("Pune", "India")))),
                new Employee(108, "Mrp", "A", "DEV", 70000, List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India"))))


        ).collect(Collectors.toList());
    }
}
