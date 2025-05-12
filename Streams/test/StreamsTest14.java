package Streams.test;

import Streams.domain.Category;
import Streams.domain.LightNovel;
import Streams.domain.Promotion;

import java.util.*;
import java.util.stream.Collectors;

import static Streams.domain.Promotion.NORMAL_PRICE;
import static Streams.domain.Promotion.UNDER_PROMOTION;

public class StreamsTest14 {

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

        //COUNTING BY CATEGORY
        Map<Category, Long> collectCount = lightNovelsList.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.counting()));
        System.out.println(collectCount);


        //COUNTING BY CATEGORY AND FILTERING THE MAX PRICE
        //returning Optional
        Map<Category, Optional<LightNovel>> countByCategoryAndPrice = lightNovelsList.stream()
                .collect(
                        Collectors.groupingBy(LightNovel::getCategory,
                                Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(countByCategoryAndPrice);

        //COUNTING BY CATEGORY AND FILTERING THE MAX PRICE
        //returning Map<Category, LightNovel>, retirando o lightNovel de dentro do Optional
        Map<Category, LightNovel> collect2 = lightNovelsList.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.collectingAndThen(Collectors.maxBy(
                                        Comparator.comparing(LightNovel::getPrice)),
                                Optional::get)));
        System.out.println(collect2);


    }

}
