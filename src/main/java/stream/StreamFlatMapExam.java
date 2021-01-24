package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMapExam {

    public static void main(String[] args) {

        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream); // flatMap으로 변환

        strStrm.map(String::toLowerCase) // 모두 소문자로 변환
                .distinct()             // 중복제거
                .sorted()               // 정렬
                .forEach(System.out::println); // 출력
        System.out.println();

        String[] lineArr = {
                "Believe or not It is ture",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // " +"는 정규식(하나 이상의 공백을 의미)
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }
}
