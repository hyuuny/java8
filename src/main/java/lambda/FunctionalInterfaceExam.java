package lambda;

@FunctionalInterface
interface MyFunction {
    void run();
}

public class FunctionalInterfaceExam {

    static void execute(MyFunction function) { // 매가변수 타입이 MyFunction인 메서드
        function.run();
    }

    static MyFunction getMyFunction() { // 반환 타입이 MyFunction인 메서드
        MyFunction function = () -> System.out.println("function3.run()");
        return function;
    }

    public static void main(String[] args) {
        // 람디식으로 MyFunction의 run()을 구현한다.
        MyFunction function1 = () -> System.out.println("function1.run()");

        // 익명클래스로 run을 구현
        MyFunction function2 = new MyFunction() {
            @Override
            public void run() { // public을 반드시 붙여야한다.
                System.out.println("function2.run()");
            }
        };

        MyFunction function3 = getMyFunction();

        function1.run();
        function2.run();
        function3.run();

        execute(function1); // 매개 변수로 받는 Myfunction의 run을 실행한다.
        execute(() -> System.out.println("람다식을 매개변수로 지정"));
    }

}
