package com.jd.interviewprep.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jd birla on 02-02-2023 at 13:53
 */
public class JavaCodingInterview {
    public static Map<String, String> strMap;
    static {

        strMap = new HashMap<String, String>();
        strMap.put("Effective Java", "Kathy Sierra");
        strMap.put("Spring in Action", "Craig Walls");
        strMap.put("Hibernate in Action", "Gavin King");
        strMap.put("Pro Angular", "Freeman");
        strMap.put("Pro Spring Boot", "Felipe Gutierrez");
    }
    public static void main(String[] args) {

        System.out.println("Que1:How to print keys & values of a Map in Java 8 ?");
        strMap.forEach((key, value) -> System.out.println(key + " : " + value));
        strMap.entrySet().forEach(e -> System.out.println(e.getKey() + " : " +e.getValue()));
        System.out.println("-----------------------------------------------------");
        strMap.keySet().stream().iterator().forEachRemaining(System.out::println);
        System.out.println("-----------------------------------------------------");
        strMap.values().stream().forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        System.out.println("Que3:How to count occurrences of each character of a String in Java 8?");

       String str = "Jitendra Birla";
        char[] chars = str.toCharArray();
        // getting distinct characters in strArray
        Set<Character> set = new TreeSet<>();
        for (char c : chars) {
            set.add(c);
        }

        System.out.println(set);
        for (char c : set) {
            // Using Streams & Lambda Expressions in Java 8
            long count = str.chars().filter( ch -> (c != ' ')?ch==c:false ).count();
            if(count!=0)
            System.out.println("Occurances of Character '" + c + "' : " + count);
        }
        System.out.println("--------------------------------------------------------------------");
        String someString1 = "Jitendra Birla";
        String someString2 = "JitendraBirla";

        String[] arrstr = someString1.split("");
        String[] arrstr2 = someString1.replaceAll("\\W", "").split("");
        String[] arrstr3 = someString1.split(" ");
         
        
        
        
        Stream s1 = Arrays.stream(arrstr);
        Map<String, Long> collectjd = (Map<String, Long>) s1
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(collectjd);
        System.out.println("Que 10: Count the no of occurance of words in given string using java 8");
        String input = "welcome to code decode and code decode welcome you";

        List<String> list = Arrays.asList(input.split(" "));

        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        System.out.println(collect1);
        System.out.println("--------------------------------------------------------------");

        System.out.println("Que 11: Map and flatmap");
        List<Employee> employees = EmployeeDatabase.getEmployees();
        List<String> collect2 = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect2);

        List<List<Address>> collect3 = employees.stream().map(Employee::getAddress).collect(Collectors.toList());
        System.out.println(collect3);
        List<String> collect4 = employees.stream().map(Employee::getAddress).flatMap(List::stream).map(ad -> ad.getCity()).distinct().collect(Collectors.toList());
        System.out.println("collect4 :"+collect4);
        System.out.println("-=============================================================================================================");
        System.out.println(
                "Que4: Given a list of integers, find out all the even numbers exist in the list using Stream functions?");

        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        myList.stream().filter(n -> n % 2 == 0).iterator().forEachRemaining(System.out::println);
        System.out.println(
                "Que4: Given a list of integers, find out all the numbers starting with 1 using Stream functions??");
        List<Integer> myList1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList1.stream().map(a -> a.toString()).filter(s -> s.startsWith("1")).forEach(System.out::println);
        System.out.println(
                "Que5: How to find duplicate elements in a given integers list in java using Stream functions?\r\n"
                        + "");
        List<Integer> myList2 = Arrays.asList(10, 15, 8, 10, 25, 15, 32, 15);
        HashSet<Integer> s = new HashSet<Integer>();

        myList2.stream().filter(a -> !s.add(a)).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("---------------------duplicate using new-------------------------");
        int[] arr = {4,3,2,1,5,4,3};
         List<Integer> collect7 = Arrays.stream(arr)
         .boxed()
         .collect(Collectors.toList());
         collect7.stream()
         .filter(i -> Collections.frequency(collect7, i)>1)
         .distinct()
         .forEach(System.out::println);
         System.out.println("-----------------------------------------------");

        System.out.println(
                "Que6: Q6 Given a list of integers, find the maximum value element present in it using Stream functions?");

        List<Integer> myList3 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        // myList3.stream().max(Comparator.comparing(Integer::intValue)).ifPresent(System
        // .out::println);
        myList3.stream().distinct().collect(Collectors.maxBy(Comparator.comparing(Integer::intValue)))
                .ifPresent(System.out::println);
        // myList3.stream().distinct().peek(System.out::println).collect(Collectors.maxBy(Comparator.comparing(Integer::intValue))).ifPresent(System.out::println);

        System.out.println(
                "-=============================================================================================================");
        System.out.println("-------------------JDSorting----------------------------------------------");
        System.out.println(
                " Que7: Given a list of integers, sort all the values present in it using Stream functions?\r\n" + "");

        List<Integer> myList4 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        myList4.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");

        Comparator<Integer> com = (a1, a2) -> a1.compareTo(a2);
        myList4.sort(com);
        System.out.println(myList4);
        System.out.println("--------------------------------------------------------------");

        Collections.sort(myList4);
        System.out.println(myList4);

        System.out.println("--------------------------------------------------------------");
        Comparator<Integer> com1 = (a1, a2) -> -a1.compareTo(a2);
        Collections.sort(myList4, com1);
        System.out.println(myList4);
        System.out.println("--------------------------------------------------------------");
        Comparator<Integer> com2 = (a1, a2) -> {
            if (a1 < a2)
                return -1;
            else if (a1 > a2)
                return +1;
            else
                return 0;
        };

        Collections.sort(myList4, com2);
        System.out.println(myList4);

        System.out.println("--------------------------------------------------------------");
        Comparator<Integer> com3 = (a1, a2) -> {
            if (a1 < a2)
                return +1;
            else if (a1 > a2)
                return -1;
            else
                return 0;
        };

        Collections.sort(myList4, com3);
        System.out.println(myList4);
        System.out.println(
                "-=============================================================================================================");
        System.out.println(
                "Que 8: Given a list of integers, sort all the values present in it in descending order using Stream functions?");

        List<Integer> myList6 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        myList6.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        myList6.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach(System.out::println);

        System.out.println("Que 8: Sort the Employee list using inside object adress in which city is available?");
        List<Employee> empList = EmployeeDatabase.getEmployees();

        Stream<String> sorted = empList.stream().map(e -> e.getAddress()).flatMap(List::stream).map(a -> a.getCity()).sorted((c1, c2) -> c1.compareTo(c2));
        List<Employee> empsortbyid = empList.stream().sorted((e1, e2) -> e1.getId().compareTo(e2.getId()))
                .collect(Collectors.toList());
        System.out.println("Sort by id: " + empsortbyid);

        List<Employee> collect5 = empList.stream().sorted((e1, e2) -> e1.getAddress().get(0).getCity().compareTo(e2.getAddress().get(0).getCity())).collect(Collectors.toList());
        System.out.println("Sort by address first city: " + collect5);

        System.out.println("Sort by Address city: " + collect5);

        System.out.println(
                "Que 12: Assume you have list of employee in various dept, WAP to find highest paid employee from each dept");
        Map<String, Optional<Employee>> collect6 = EmployeeDatabase.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));

        collect6.forEach((k,v) -> {
            System.out.println(k+' '+v.get());
        });
        System.out
                .println("Que 13: Wrtie a program to sort employee based on salary and collect into map by department");
        Map<String, List<Employee>> collect8 = EmployeeDatabase.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.toList()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey((c1, c2) -> c1.compareTo(c2)))
                .collect(Collectors.toMap(a -> a.getKey(), b -> b.getValue()));

        collect8.forEach((key, value) -> System.out.println("Key : " + key + "\t\t" + "Value : " + value));

        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getSalary))
                        .collect(Collectors.groupingBy(Employee::getDept));

        System.out.println("Employees by department: " + employeesByDepartment);
    }
}
