package stream;

import java.io.File;
import java.util.stream.Stream;

public class StreamMapExam {

    public static void main(String[] args) {

        File[] fileArr = {new File("hey.java"), new File("hi.bak"),
                        new File("yo.java"), new File("no"), new File("yes.txt")};

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<File> fileStream = Stream.of(fileArr);
        fileStream.forEach(System.out::println);

        fileStream = Stream.of(fileArr); // 스트림 다시 생성

        fileStream.map(File::getName)                   // Stream<File> -> Stream<String>
                .filter(s -> s.indexOf('.') != -1)      // 확장자가 없는 것은 제외
                .peek(s -> System.out.printf("filename = %s%n", s)) // 파일명 출력
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
                .peek(s -> System.out.printf("extension = %s%n", s)) // 확장자만 출력
                .map(String::toUpperCase)               // 모두 대문자로 변환
                .distinct()                             // 중복 제거
                .forEach(System.out::print);            // JAVABAKTXT

    }
}