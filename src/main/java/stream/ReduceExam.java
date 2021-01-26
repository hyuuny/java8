package stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceExam {

    public static void main(String[] args) {

        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .parallel().forEach(System.out::println); // parallel() : 병렬스트림, 순서 유지 X

        boolean noEmptyStr = Stream.of(strArr).noneMatch(x -> x.length() == 0); // strArr 요소중 길이가 0인 요소가 있는가
        Optional<String> sWord = Stream.of(strArr)
                                        .filter(s -> s.charAt(0) == 's').findFirst(); // strArr 요소중 s로 시작하는 단어를 저장

        System.out.println("noEmptyStr : " + noEmptyStr);
        System.out.println("sWord : " + sWord.get());

        // Stream<String>을 IntStream으로 변환. IntStream 기본형 스트림.
        // Stream<Integer>와 같으나, 성능때문에 IntStream 사용
        IntStream intStream = Stream.of(strArr).mapToInt(String::length);
        int count = intStream.reduce(0, (a, b) -> a + 1);
        System.out.println("count : " + count);


        intStream = Stream.of(strArr).mapToInt(String::length);
        int sum = intStream.reduce(0, (a, b) -> a + b);
        System.out.println("sum : " + sum);

        intStream = Stream.of(strArr).mapToInt(String::length);
        OptionalInt max = intStream.reduce(Integer::max);
        System.out.println("max : " + max.getAsInt());

        intStream = Stream.of(strArr).mapToInt(String::length);
        OptionalInt min = intStream.reduce(Integer::min);
        System.out.println("min : " + min.getAsInt());
    }
}
