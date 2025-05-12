package Streams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamsTest10 {

    public static void main(String[] args) {

        //ITERATE
        //imprimir todos os numeros pares infinitamente
        //Stream.iterate(1, number -> number+2).forEach(System.out::println);

        Stream.iterate(1, number -> number+2)
                .limit(10)
                .forEach(System.out::println);
        System.out.println();


        //sequencia de fibonacci: sempre soma o valor atual com o anterior
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        //agrupando os numeros: (0,1) (1, 1) (1, 2) (2, 3) (3, 5) ... -> pos 0 e 1 do array
        Stream.iterate(new int[]{0, 1}, num -> new int[]{num[1], num[0] + num[1]})
                .limit(10)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println();

        Stream.iterate(new int[]{0, 1}, num -> new int[]{num[1], num[0] + num[1]})
                .limit(10)
                .map(arr -> arr[0])
                .forEach(System.out::println);

        //GENERATE
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Stream.generate(() -> random.nextInt(1, 500))
                .limit(90)
                .forEach(System.out::println);

    }

}
