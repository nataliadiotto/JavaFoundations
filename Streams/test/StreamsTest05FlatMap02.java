package Streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest05FlatMap02 {

    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
        String[] letters = words.get(0).split("");
        System.out.println(Arrays.toString(letters));
        System.out.println("----------");

        words.stream()
                .map(w -> w.split(""))
                .collect(Collectors.toList());
        Stream<String> streamLetters = Arrays.stream(letters);

        List<Object> letters2 = words.stream()
                .map(w -> w.split("")) //retorna: Stream<String[]>
                .flatMap(Arrays::stream) //para acessar os elemetos do array, retorna: Stream<String>
                .collect(Collectors.toList());
        System.out.println(letters2);

    }

}
