package com.app.stream;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    @Test
    @Description("it will print unique numbers from list")
    void getUniqueList() {
        List<Integer> integers = List.of(1, 10, 2, 1, 10, 5);
        Set<Integer> collect = integers.stream().collect(Collectors.toSet());
        System.out.println("first way " + collect);

        System.out.println("second way " + new HashSet<>(integers));

        System.out.println("third way " + integers.stream().distinct().toList());
    }

    @Test
    void findDuplicateNumbersFromList() {
        Map<Integer, Long> collect = List.of(1, 4, 3, 1, 4, 9).stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));
        collect.entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > 1).forEach(System.out::println);
    }

    @Test
    @Description("find the max number through stream")
    void findMax() {
        List<Integer> integerStream = List.of(2, 10, 4, 1);
        System.out.println(integerStream.stream().reduce((x, y) -> x > y ? x : y).get());
        System.out.println(integerStream.stream().max(Integer::compareTo));
    }


    @Test
    @Description("Demo of Collectors method")
    void demonstrateCollectorsMethod() {
        List<String> list = List.of("ab", "d", "abc", "cd", "f");

        //1  Collects the elements of the stream into a Map.
        // 1.A Simple toMap: Requires key and value mapper functions.
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("toMap Result -> "+collect);

        //1.B toMap with Merge Function: Handles duplicate keys.
        Map<Integer, String> collect1 = list.stream().collect(Collectors.toMap(String::length, Function.identity(), (s, s2) -> s + "," + s2));
        System.out.println("toMap Result with merge function -> "+collect1);

        //2 Joining
        String result = list.stream().collect(Collectors.joining());
        System.out.println("stream joining method result -> "+result);

        result = String.join("", list);
        System.out.println("String join method result -> "+result);

        result = list.stream().collect(Collectors.joining(","));
        System.out.println("Stream joining by delimiter -> "+result);

        //3 groupingBy()  Groups the elements of the stream by a classifier function.
        Map<Integer, List<String>> groupingByResult = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("groupBy Result -> "+groupingByResult);

        Map<Integer, Long> groupingByResult2 = list.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("groupBy with downstream collectors -> "+groupingByResult2);

        //4 partitioningBy()  Partitions the elements of the stream into two groups based on a predicate.
        Map<Boolean, List<String>> partitioningByResult = list.stream().collect(Collectors.partitioningBy(s -> s.length() > 2));
        System.out.println("partitionBy Result -> "+partitioningByResult);

        Map<Boolean, Long> partitionByResult2 = list.stream().collect(Collectors.partitioningBy(s -> s.length() > 2, Collectors.counting()));
        System.out.println("partitionBy with downstream collectors -> "+partitionByResult2);

        //5 counting
        Long countResult = list.stream().collect(Collectors.counting());
        System.out.println("counting result -> "+countResult);

        countResult=list.stream().count();
        System.out.println("count result -> "+countResult);

        //6 summarizingInt
        IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(String::length));
        System.out.println("summarizingInt result -> "+summaryStatistics);


        //7 mapping() Adapts a collector by applying a mapping function to each input element before collecting.
        List<String> collect2 = list.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
        System.out.println("mapping result -> "+collect2);


    }


    @Test
    @Description("it will print the first non repeated character from string")
    void getFirstNonRepeatedChar() {
        String str = "aarfi";
        Map<Character, Long> collect = str.chars().mapToObj(value -> (char) value).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect.entrySet().stream().filter(characterLongEntry -> collect.get(characterLongEntry.getKey()) == 1).findFirst());
    }

    @Test
    @Description("it will reverse the string")
    void reversString() {
        String str = "abc";
        List<String> collect = str.chars().mapToObj(value -> String.valueOf((char) value)).collect(Collectors.toList());
        Collections.reverse(collect);
        System.out.println(collect.stream().reduce("", (a, b) -> a + b));
    }

    @Test
    @Description("it will return the occurrence")
    void findOccurrence() {
        List<Integer> integers = List.of(1, 3, 1, 5, 9, 3, 10, 1, 16, 3, 21);
        Map<Integer, Long> collect = integers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect.entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() == 1).findFirst());

    }


    @Description("jdk 12")
    @Test
    void indent() {
        System.out.println("this is method".indent(12));
        System.out.println("this is method".indent(-12));
    }

    @Test
    @Description("jdk 12")
    void transform() {
        System.out.println("result -> " + " ab".transform(String::strip));
    }


    @Test
    @Description("jdk 12")
    void teeing() {
        Integer sum = Stream.of(10, 2, 5, 20).collect(Collectors.teeing(Collectors.minBy(Integer::compareTo), Collectors.maxBy(Integer::compareTo), (min, max) -> min.get() + max.get()));
        System.out.println(sum);
    }

    @Test
    void textBlock() {
        String str = """
                {
                 "username" :"abc",
                 "password" : "pass1"
                }
                """;
        System.out.println(str);
    }

    @Test
    @Description("use of instance of operator with variable declaration")
    void instanceOf() {
        Object obj = new StreamDemo();
        if (obj instanceof StreamDemo x) {
            System.out.println(x);
        }
    }

}
