package base.io;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author sannian
 * @Date 2021/5/17 16:45
 * @Version 1.0
 */

public class StreamTry {
    public static void main(String[] args) {
//        Random seed = new Random();
//        Supplier<Integer> random = seed::nextInt;
//        Stream.generate(random).limit(10).forEach(System.out::println);
//        //Another way
//        IntStream.generate(() -> (int) (System.nanoTime() % 100)).limit(10).forEach(System.out::println);

//        Stream.iterate(0,x -> x+1).limit(10).forEach(System.out::println);
        Stream.iterate(0,x -> x).limit(10).forEach(System.out::println);
    }
}
