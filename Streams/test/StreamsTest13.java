package Streams.test;

import Streams.domain.Category;
import Streams.domain.LightNovel;
import Streams.domain.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static Streams.domain.Promotion.*;

public class StreamsTest13 {

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

       //AGRUPAR POR PREÇO
        Map<Promotion, List<LightNovel>> collectByPrice = lightNovelsList.stream()
                .collect(Collectors.groupingBy(lightNovel ->
                        lightNovel.getPrice() < 6.00 ? UNDER_PROMOTION : NORMAL_PRICE));
        System.out.println(collectByPrice);

        //AGRUPAR POR PREÇO E CATEGORIA
        //Map<Category, Map<Promotion, List<LightNovel>>>
        Map<Category, Map<Promotion, List<LightNovel>>> groupByCategoryAndPrice = lightNovelsList.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.groupingBy(lightNovel ->
                                lightNovel.getPrice() < 6.00 ? UNDER_PROMOTION : NORMAL_PRICE)));
        System.out.println(groupByCategoryAndPrice);
    }

}
