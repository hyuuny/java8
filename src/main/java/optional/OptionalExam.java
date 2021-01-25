package optional;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalExam {

    public static void main(String[] args) {

        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length); // strOpt의 길이가 저장된다.
        System.out.println("optStr : " + optStr.get());
        System.out.println("optInt : " + optInt.get());

        int result1 = Optional.of("123")
                        .filter(x -> x.length() > 0) // x의 길이는 0보다 커야한다.
                        .map(Integer::parseInt).get(); // map을 통해 String -> Integer로 변경한다.

        int result2 = Optional.of("")
                        .filter(x -> x.length() > 0)
                        .map(Integer::parseInt).orElse(-1);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);

        Optional.of("456").map(Integer::parseInt)
                        .ifPresent(x -> System.out.printf("result3 : %s%n", x)); // null이 아니면 출력

        OptionalInt optInt1 = OptionalInt.of(0); // 0을 저장
        OptionalInt optInt2 = OptionalInt.empty(); // 빈 객체를 저장

        System.out.println(optInt1.isPresent()); // true
        System.out.println(optInt2.isPresent()); // false

        System.out.println(optInt1.getAsInt()); // 0
//        System.out.println(optInt2.getAsInt()); // NoSuchElementException
        System.out.println("optInt1 : " + optInt1);
        System.out.println("optInt2 : " + optInt2);
        System.out.println("optInt1.equals(optInt2)?" + optInt1.equals(optInt2));

    }
}
