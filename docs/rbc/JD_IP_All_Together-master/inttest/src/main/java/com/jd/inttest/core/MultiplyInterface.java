package com.jd.inttest.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by jd birla on 02-02-2023 at 13:39
 */
@FunctionalInterface
public interface MultiplyInterface {

  public int multiply(int a, int b);

  default double getScratchCard() {
    return new Random().nextDouble();
  }

  static String datePatterns(String patterns) {
    SimpleDateFormat date = new SimpleDateFormat(patterns);
    return date.format(new Date());

  }
}
