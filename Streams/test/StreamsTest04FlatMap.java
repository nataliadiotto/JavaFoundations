package Streams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTest04FlatMap {

    public static void main(String[] args) {
        List<List<String>> diottodev = new ArrayList<>();
        
        List<String> graphicDesigners = List.of("Wildnei Suane",
                                        "Catarina Santos",
                                        "Sandy Carvalho");
        List<String> developers = List.of("William Johnson",
                                    "David Lopez",
                                    "Harrison Ford");
        List<String> students = List.of("Édipo",
                                        "Gustavo Lima",
                                        "Gustavo Mendes",
                                        "Guilherme Arana");

        diottodev.add(graphicDesigners);
        diottodev.add(developers);
        diottodev.add(students);

        System.out.println("Map:");
        for (List<String> people : diottodev) {
            for (String person : people) {
                System.out.println(person);
            }

        }
        System.out.println("-----------");
        System.out.println("FlatMap:");

        //map: trabalha no primeiro nivel
        //flatmap: se aprofunda mais que o map, usado para quando precisamos
        //extrair um atributo que esta aninhado (flattening) a uma coleção

        diottodev.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

    }

}
