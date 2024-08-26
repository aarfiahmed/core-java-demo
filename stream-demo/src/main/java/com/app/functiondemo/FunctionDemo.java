package com.app.functiondemo;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.function.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionDemo {

    @Test
    @Description("Represents an operation on a single operand that produces a result of the same type as its operand.")
    void shouldDUnaryOperator() {
        UnaryOperator<String> f = String::toUpperCase;
        String result = f.apply("hello");

        assertEquals("HELLO", result);
    }

    @Test
    @Description("Represents an operation upon two operands of the same type, producing a result of the same type as the operands.")
    void shouldBinaryOperator() {
        BinaryOperator<String> f = (s, s2) -> s + "," + s2;
        String result = f.apply("hello", "world");

        assertEquals("hello,world", result);
    }

    @Test
    @Description("Represents a function that accepts two arguments and produces a result.")
    void shouldBiFunction() {
        BiFunction<String, String, Integer> f = (s, s2) -> s.length() + s2.length();

        Integer result = f.apply("a", "ab");
        assertEquals(3, result);
    }

    @Test
    @Description("Represents an operation that accepts a single input argument and returns no result.")
    void shouldConsumer(){
        Consumer<String> f=  System.out::println;

        f.accept("hello");
    }

    @Test
    @Description("Represents an operation that accepts a single input argument and returns no result.")
    void shouldBiConsumer(){
        BiConsumer<String,Integer> f=  (s, integer) -> System.out.println(s+" "+integer);

        f.accept("hello",10);
    }
}
