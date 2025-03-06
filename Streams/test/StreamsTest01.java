package Streams.test;

import Streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//1. Order LightNovel by title
//2. Retrieve the first 3 light novels titles with prices lower than 4
public class StreamsTest01 {

    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {

        //ordenar usando collections
        lightNovelsList.sort(Comparator.comparing(LightNovel::getTitle));

        //retrieve light novels' titles
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel: lightNovelsList) {
            if (lightNovel.getPrice() <= 4.00) {
                titles.add(lightNovel.getTitle());
            }
            if (titles.size() >= 3){
                break;
            }
        }

        System.out.println(lightNovelsList);
        System.out.println(titles);

    }

}
