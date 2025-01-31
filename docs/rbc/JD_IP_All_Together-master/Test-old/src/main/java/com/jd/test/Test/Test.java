package com.jd.test.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jd birla on 04-05-2023 at 08:07
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> myList6 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> dupSet = new HashSet<>();
        List<Integer> collect = myList6.stream().filter(el->dupSet.add(el)).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    }


