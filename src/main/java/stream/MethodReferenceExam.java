package stream;

import java.util.function.Function;

public class MethodReferenceExam {

    public static void main(String[] args) {

//        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
//        System.out.println(f.apply("100") + 200); // apply : 배열 또는 값 목록을 반환

        // 위 람다식을 메서드 참조로 변환
        Function<String, Integer> f = Integer::parseInt; // 메서드 참조(클래스이름::메서드이름)
        System.out.println(f.apply("100") + 200);


        // Supplier는 입력 X, 츨력 O
//        Supplier<MyClass> s = () -> new MyClass(); // s에 MyClass 객체를 반환하는 기능을 저장
//        Supplier<MyClass> s = MyClass::new; // 생성자를 호출하는 메서드 참조

//        System.out.println(s.get()); // s에 저장된 요소를 꺼낸다.
//        System.out.println(s.get()); // 위와 다른 MyClass객체를 꺼낸다.

//        Function<Integer, MyClass> f2 = (i) -> new MyClass(i);
        Function<Integer, MyClass> f2 = MyClass::new; // 생성자를 호출하는 메서드 참조

        MyClass mc;
        System.out.println(f2.apply(500).iv); // 위와 다른 MyClass객체를 꺼낸다.


        // 배열
//        Function<Integer, int[]> f3 = i -> new int[i];
        Function<Integer, int[]> f3 = int[]::new; // 메서드 참조로 변경
        int[] intArr = f3.apply(15);
        System.out.println(intArr.length);
    }
}

class MyClass{
    int iv;

    public MyClass(int iv) {
        this.iv = iv;
    }
}
