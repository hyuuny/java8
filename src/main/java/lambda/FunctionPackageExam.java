package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionPackageExam {

    public static void main(String[] args) {

        Supplier<Integer> s = () -> (int) (Math.random() * 100)+1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i%2 == 0;
        Function<Integer, Integer> f = i -> i/10*10; // i의 1의자리를 없앤다.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);

        printEvenNum(p, c, list);

        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    // 1의 자리를 없애는 람다식과 List를 매개변수로 받는다.
    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }

    // 짝수를 판단하는 람다식과 출력하는 람다식, List를 매개변수로 받는다.
    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i))
                c.accept(i);
        }
        System.out.println("]");
    }

    // 랜덤번호를 생성하는 람다식과 List를 매개변수로 받는다.
    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }


}
