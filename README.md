# Java8

## 람다식

```
int[] arr = new int[5];
Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1);

위의 람다식 (i) -> (int)(Math.random()*5)+1을 메서드로 표현하면,
int method(int i){
  return (int)(Math.random()*5)+1;
}
과 같다.
```
* 람다식은 메서드를 하나의 식(expression)으로 표현한 것이다.  
* 람다식은 매서드의 매개변수로 전달되는 것도 가능하고, 메서드의 결과로 반환될 수도 있다.
* 람다식으로 인해 메서드를 변수처럼 다루는 것이 가능해진 것이다.
 
  * * *
  


## 람다식 작성
> 메서드에서 이름과 반환타입을 제거하고 매개변수 선언부와 몸통{} 사에에 '->'를 추가하기만 하면 된다.  
> 반환값이 있는 메서드의 경우, return문 대신 식으로 대신 할 수 있다. 식의 연산결과가 자동으로 반환값이 된다. 이때 끝에 ';'를 붙이지 않는다.

* 메서드
```
int max(int a, int b){
  return a>b ? a:b;
}
```
  
* 람다식(위 메서드를 람다식으로 표현하면 이렇게 간결해진다.)
```
(a, b) -> a > b ? a : b;
```


  * * *


* [java.util.function패키지][functionpackage]

[functionpackage]:https://github.com/setge/java8/blob/master/src/main/java/md/java.utilfunction%ED%8C%A8%ED%82%A4%EC%A7%80.md

* [Predicate의 결합][Predicate의 결합]

[Predicate의 결합]:https://github.com/setge/java8/blob/master/src/main/java/md/Predicate%EC%9D%98%20%EA%B2%B0%ED%95%A9.md

* [메서드 참주][메서드 참조]

[메서드 참조]:https://github.com/setge/java8/blob/master/src/main/java/md/%EB%A9%94%EC%84%9C%EB%93%9C%20%EC%B0%B8%EC%A1%B0.md

* [스트림(Stream)][스트림]

[스트림]:https://github.com/setge/java8/blob/master/src/main/java/md/%EC%8A%A4%ED%8A%B8%EB%A6%BC%EC%9D%98%20%ED%8A%B9%EC%A7%95.md

* [스트림 만들기][스트림 만들기]

[스트림 만들기]:https://github.com/setge/java8/blob/master/src/main/java/md/%EC%8A%A4%ED%8A%B8%EB%A6%BC%20%EB%A7%8C%EB%93%A4%EA%B8%B0.md

* [스트림의 중간연산][스트림의 중간연산]

[스트림의 중간연산]:https://github.com/setge/java8/blob/master/src/main/java/md/%EC%8A%A4%ED%8A%B8%EB%A6%BC%20%EC%A4%91%EA%B0%84%EC%97%B0%EC%82%B0.md






  
