package com.jd.test.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Created by jd birla on 07-05-2023 at 17:35
 */
public class EmpTest {

  public static void main(String[] args) {
    String input = "example@domain.com";
    Predicate<String> validateInput = createInputValidator();
    boolean result = validateInput.test(input);
    System.out.println(result); // Output: true



  }

  public static Predicate<String> createInputValidator() {
    Predicate<String> notEmpty = s -> !s.isEmpty();
    Predicate<String> validEmail = s -> Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", s);
    Predicate<String> minLength = s -> s.length() >= 6;

    return notEmpty.and(validEmail).and(minLength);
  }


}



