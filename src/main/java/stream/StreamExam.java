package stream;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExam {

    public static void main(String[] args) {

        /**
         * Stream
         * 1. 스트림 생성
         * 2. 중간연산(0~n번)
         * 3. 최종연산(0~1번)
         */

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream(); // 스트림 생성

        intStream.forEach(System.out::print);
//        intStream.forEach(System.out::print); // 에러, 스트림은 1회용이다. 최종연산을 수행하면 stream이 닫힘.

        intStream = list.stream(); // list로부터 stream을 생성
        intStream.forEach(System.out::print); // 정상출력

        System.out.println();

        // 배열을 소스로하는 스트림
//        Stream<String> strStream = Stream.of("a", "b", "c");
//        String[] strArr = new String[]{"a", "b", "c","d"} ;
        Stream<String> strStream = Stream.of(new String[]{"a", "b", "c","d"}); // 위 배열 선언을 한 줄로
        strStream.forEach(System.out::println);

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream2 = Arrays.stream(intArr);
        System.out.println("count : " + intStream2.count());

        // count도 최종연산이므로 intStream을 사용하기 위해선 새로 스트림을 만들어야한다.
        intStream2 = Arrays.stream(intArr);
        System.out.println("sum : " + intStream2.sum());

        intStream2 = Arrays.stream(intArr);
        System.out.println("Average : " + intStream2.average());


        // 임의의 수 스트림
//        IntStream intStream3 = new Random().ints(1, 46); // 무한 스트림
//        intStream3.limit(5).forEach(System.out::println); // 5개만 잘라서 출력

        IntStream intStream3 = new Random().ints(1, 46);
        intStream3.distinct().limit(6).sorted().forEach(System.out::println);

        // iterate(), generate()

        // iterate(T seed, UnaryOperator f) 단항 연산자
        Stream<Integer> intStream4 = Stream.iterate(2, n -> n + 2); // seed값 2부터 시작해서 람다식으로 계산된 결과를 다시 seed값으로 하여 계산을 반복한다.
        intStream4.limit(10).forEach(System.out::println); // 10번 반복

        // generate(Supplier s) : 입력 X, 반환 O
        intStream4 = Stream.generate(() -> 1); // 1만 반환
        intStream4.limit(10).forEach(System.out::println);


        // 빈 스트림
        Stream emptyStream = Stream.empty();
        System.out.println(emptyStream.count()); // 스트림이 비어 있으므로 값은 0

    }
}
