package Streams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest09 {

    public static void main(String[] args) {

        //nao inclui o ultimo numero (50)
        IntStream.range(1, 50)
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println("\n-------------------------");

        //inclui o ultimo numero (50)
        IntStream.rangeClosed(1, 50)
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        Stream.of("Eleve", "O", "Cosmo", "no seu coração")
                .map(String::toUpperCase)
                .sorted()
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        int nums[] = {1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .average()
                .ifPresent(System.out::println);
        System.out.println();


        //filtrar partes que tenham "Java" num file
        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))){

            lines.filter(line -> line.contains("Java"))
                    .forEach(System.out::println);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
