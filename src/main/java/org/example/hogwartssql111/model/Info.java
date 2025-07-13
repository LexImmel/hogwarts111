package org.example.hogwartssql111.model;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Info {

    public static void main (String[] args) {

        long startInt = System.currentTimeMillis();
        int sumInt = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, Integer::sum);
        long endInt = System.currentTimeMillis()- startInt;
        System.out.println("Сумма с потерей значений с типом int без распараллеливания " + sumInt + " посчитана за время " + (endInt) + " мс");

        long startIntParallel = System.currentTimeMillis();
        int sumIntParallel = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, Integer::sum);
        long endIntParallel = System.currentTimeMillis()- startIntParallel;
        System.out.println("Сумма с потерей значений с типом int и распараллеливанием " + sumIntParallel + " посчитана за время " + (endIntParallel) + " мс");

        long startLong = System.currentTimeMillis();
        long sumLong = LongStream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, Long::sum);
        long endLong = System.currentTimeMillis()- startLong;
        System.out.println("Сумма без потери значений с типом long без распараллеливания " + sumLong + " посчитана за время " + (endLong) + " мс");

        long startLongParallel = System.currentTimeMillis();
        Long sumLongParallel;
        sumLongParallel = Stream.iterate(1L, a -> a + 1L)
                .limit(1_000_000)
                .parallel()
                .reduce(0L, Long::sum);
        long endLongCountParallel = System.currentTimeMillis()- startLongParallel;
        System.out.println("Сумма без потери значений с типом long и распараллеливанием " + sumLongParallel + " посчитана за время " + (endLongCountParallel) + " мс");

        System.out.println("Итог - при распараллеливании int теряет в скорости, long сам по себе быстрее, чем int, и с распараллеливанием быстрее, чем распараллеленный int.");


    }



}
