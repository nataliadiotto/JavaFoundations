package Streams.test;

import java.util.List;

public class StreamsTest07Reduce01 {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        //retornando um optional
        integers.stream()
                .reduce((x,y) -> x + y)
                .ifPresent(System.out::println);
        //forçando o casting pra integer
        System.out.println(integers.stream()
                .reduce(0, (x,y) -> x + y));
        System.out.println("---------------------");


        //usando o metodo sum de Integer, retornando optional
        integers.stream()
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
        //forçando o casting pra integer
        System.out.println(integers.stream()
                .reduce(0, Integer::sum));
        System.out.println("---------------------");

        //retornando o max
        //forma feia
        integers.stream()
                .reduce((x,y) -> x > y ? x : y)
                .ifPresent(System.out::println);
        //forma bonita
        System.out.println(integers.stream()
                .reduce(Integer::max)); //retornando optional
        System.out.println(integers.stream()
                .reduce(0, Integer::max)); //retornando integer


    }
}
