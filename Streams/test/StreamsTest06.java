package Streams.test;

import Streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamsTest06 {

    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {

        System.out.println(lightNovelsList.stream()
                .anyMatch(ln -> ln.getPrice() > 8.00));

        System.out.println(lightNovelsList.stream()
                .allMatch(ln -> ln.getPrice() > 0));

        System.out.println(lightNovelsList.stream()
                .noneMatch(ln -> ln.getPrice() > 0));

        lightNovelsList.stream()
                .filter(ln -> ln.getPrice() > 3.00)
                .findAny()
                .ifPresent(System.out::println);

        lightNovelsList.stream()
                .filter(ln -> ln.getPrice() > 3.00)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst()
                .ifPresent(System.out::println);

        lightNovelsList.stream()
                .filter(ln -> ln.getPrice() > 3.00)
                .max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);

    }
}
