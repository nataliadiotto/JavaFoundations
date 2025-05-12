package Streams.test;

import Streams.domain.Category;
import Streams.domain.LightNovel;
import Streams.domain.Promotion;

import java.util.*;
import java.util.stream.Collectors;

import static Streams.domain.Promotion.NORMAL_PRICE;
import static Streams.domain.Promotion.UNDER_PROMOTION;
import static java.util.stream.Collectors.*;


public class StreamsTest15 {

    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 10.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game no life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)));

    public static void main(String[] args) {

        //GROUP BY CATEGORY AND RETRIEVE STATISTICS ABOUT PRICES
        Map<Category, DoubleSummaryStatistics> collect = lightNovelsList.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect);


        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovelsList.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        groupingBy(StreamsTest15::getPromotion)));
        System.out.println(collect1);


        //Retornando Map<Category, Set<Promotion>>
        Map<Category, Set<Promotion>> collect2 = lightNovelsList.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        mapping(StreamsTest15::getPromotion, toSet())));
        System.out.println(collect2);

        //Retornando um hashset
        Map<Category, LinkedHashSet<Promotion>> collect3 = lightNovelsList.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        mapping(StreamsTest15::getPromotion, toCollection(LinkedHashSet::new))));
        System.out.println(collect3);
    }

    private static Promotion getPromotion(LightNovel lightNovel) {
        return lightNovel.getPrice() < 6.00 ? UNDER_PROMOTION : NORMAL_PRICE;
    }

}
