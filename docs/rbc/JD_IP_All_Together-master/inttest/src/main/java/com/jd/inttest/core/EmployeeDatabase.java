package com.jd.inttest.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jd birla on 02-02-2023 at 13:33
 */
public class EmployeeDatabase {

  public static List<com.jd.inttest.core.Employee> getEmployees() {
    return Stream.of(
            new com.jd.inttest.core.Employee(101, "Ram", "A", "Manager", 120000,
                    List.of((new Address("Indore", "India")), (new Address("Pune", "India")))),
            new com.jd.inttest.core.Employee(102, "Raju", "B", "IT", 120000,
                    List.of((new Address("Chennai", "India")), (new Address("Bangalore", "India")))),
            new com.jd.inttest.core.Employee(103, "Abhijit", "C", "DEV", 110000,
                    List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India")))),
            new com.jd.inttest.core.Employee(104, "Bhupendra", "D", "BAU", 10000,
                    List.of((new Address("Indore", "India")), (new Address("Mumbai", "India")))),
            new com.jd.inttest.core.Employee(105, "Niranjan", "A", "Lead", 90000,
                    List.of((new Address("Chennai", "India")), (new Address("Tokyo", "Japan")))),
            new com.jd.inttest.core.Employee(106, "Sunil", "B", "IT", 80000,
                    List.of((new Address("Chennai", "India")), (new Address("Bangalore", "India")))),
            new com.jd.inttest.core.Employee(107, "Gajanand", "A", "Manager", 70000,
                    List.of((new Address("Indore", "India")), (new Address("Pune", "India")))),
            new com.jd.inttest.core.Employee(108, "Mrp", "A", "DEV", 60000,
                    List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India"))))

    ).collect(Collectors.toList());
  }
}
