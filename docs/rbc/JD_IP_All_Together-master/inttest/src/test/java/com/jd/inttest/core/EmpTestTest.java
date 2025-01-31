package com.jd.inttest.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmpTestTest {
    private EmpTest empTest;

    @BeforeEach
    public void setup() {
        empTest = new EmpTest();
    }

    @Test
    void createInputValidator() {
        String input = "example@domain.com";

        Predicate<String> validateInput = empTest.createInputValidator();
        boolean result = validateInput.test(input);
        Assertions.assertThat(result).isTrue();

    }
}