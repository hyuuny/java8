package lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateCombiExam {

    public static void main(String[] args) {

        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // 매개변수(String)를 받아 16진수로 반환
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i); // 매개변수(Integer)를 받아 2진수로 반환

        Function<String, String> h = f.andThen(g); // f를 실행하고 g를 실행하는 함수를 h에 저장
        Function<Integer, Integer> h2 = f.compose(g); // g를 실행하고 h를 실행하는 함수를 h2에 저장

        System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));   // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x; // 항등 함수(넣은 값이 그대로 출력된다)
        System.out.println(f2.apply("AAA")); // "AAA"가 그대로 출력된다.

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate(); // negate(not) i >= 100

        Predicate<Integer> all = notP.and(q.or(r)); // i>=100 && i < 200 || i%2 ==0
        System.out.println(all.test(150)); // all 함수에 매개변수로 150을 넣는다. 결과는 true

        String str1 = "abc";
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
//        Predicate<String> p2 = Predicate.isEqual(str1);
//        boolean result = p2.test(str2); // str1.equals(str2)와 같음
        boolean result = Predicate.isEqual(str1).test(str2); // 위 두 줄을 이렇게 한 줄로 표현 가능
        System.out.println(result);

    }

}
