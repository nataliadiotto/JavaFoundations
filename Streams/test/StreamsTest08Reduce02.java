package Streams.test;

import Streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class StreamsTest08Reduce02 {

    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 10.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));
    public static void main(String[] args) {

        lightNovelsList.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price > 3.00)
                .reduce(Double::sum)
                .ifPresent(System.out::println);


        double sum = lightNovelsList.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3.00)
                .sum();
    }
}
