package Streams.test;

import Streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest11 {

    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 10.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {

        System.out.println(lightNovelsList.stream().count());
        System.out.println(lightNovelsList.stream().collect(Collectors.counting()));

        //Encontrando preço maximo
        lightNovelsList.stream()
                .max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);

        //Encontrando preço max com Collectors
        lightNovelsList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
                .ifPresent(System.out::println);

        //Somando todos os preços
        System.out.println(lightNovelsList.stream()
                .mapToDouble(LightNovel::getPrice)
                .sum());

        //Somando todos os preços com Collectors
        System.out.println(lightNovelsList.stream()
                .collect(Collectors.summingDouble(LightNovel::getPrice)));

        //media de todos os preços
        lightNovelsList.stream()
                .mapToDouble(LightNovel::getPrice)
                .average()
                .ifPresent(System.out::println);

        //media de todos os preços com Collectors
        System.out.println(lightNovelsList.stream()
                .collect(Collectors.averagingDouble(LightNovel::getPrice)));

        //Todas as operaçoes acima podem ser reduzidas a esse objeto DoubleSummaryStatistics
        //DoubleSummaryStatistics{count=7, sum=40,940000, min=1,990000, average=5,848571, max=10,990000}
        DoubleSummaryStatistics collect = lightNovelsList.stream()
                .collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);
        System.out.println(collect.getSum());
        System.out.println(collect.getAverage());

        //Pegar todos os titulos e separar por virgula
        String titles = lightNovelsList.stream()
                .map(LightNovel::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println(titles);
    }
}
