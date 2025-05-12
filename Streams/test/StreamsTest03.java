package Streams.test;

import Streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTest03 {

    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {

        Stream<LightNovel> stream = lightNovelsList.stream();

        lightNovelsList.forEach(System.out::println);

        long count = stream.filter(ln -> ln.getPrice() <= 4.00)
                .count();

        long count2 = lightNovelsList.stream()
                .distinct()
                .filter(ln -> ln.getPrice() <= 4.00)
                .count();

        System.out.println("Count: " + count);
        System.out.println("Count distinct: " + count2);

    }

}
