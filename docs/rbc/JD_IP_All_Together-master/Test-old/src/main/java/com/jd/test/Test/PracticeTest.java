package com.jd.test.Test;

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
       //10,15,8,49,25,98,98,32,15
    //Print Name of all employees having salary less than 3rd highest salary using Stream
    HashSet<Integer> set = new HashSet<Integer>();
      Arrays.asList(10,15,8,49,25,98,98,32,15).stream().filter( n -> !set.add(n)).forEach(System.out::println);
  }

}


