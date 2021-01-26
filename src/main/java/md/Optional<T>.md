## Optional

### Optional은 "T타입의 객체"를 감싸는 래퍼클래스. <br> 그래서 Optional타입의 객체에는 모든 타입의 객체를 담을 수 있다.

```java
public final class Optional<T>{
    private final T value; // T타입의 참조변수
    . . .
}
```

* 최종연산의 결과를 그냥 반환하는 것이 아니라 Optional객체에 담아서
반환하면, <u>반환된 결과가 null인지 매번 if문으로 체크하는 대신
  Optional에 정의된 메서드를 통해서 간단히 처리</u>할 수 있다.
  
* Optional을 이용하면, <u>널 체크를 위한 if문 없이도 NullPointerException이
발생하지 않는</u> 보다 간결하고 안전한 코드를 작성하는 것이 가능하다.

### Optional의 사용 이유
1. null을 직접 다루는 것은 위험하다 -> Optional객체로 감싼다.
2. null 체크 -> if문 필수 -> if문 없이 Optional에 정의된 메서드를 통해 간단히 처리 가능

* * *

### Optional객체를 생성할 때는 of() 또는 ofNullable()을 사용한다.

```java
String str = "abc";
Optional<String> optVal = Optional.of(str);
Optional<String> optVal = Optional.of("abc");
Optional<String> optVal = Optional.of(new String("abc"));
```

* 참조변수의 값이 <u>null일 가능성이 있으면, of()대신 ofNullable()을 사용</u>해야한다.
* of()는 매개변수의 값이 null이면 NullPointerException이 발생하기 때문

```java
Optional<String> optVal = Optional.of(null); // NullPointerException 발생
Optional<String> optVal = Optional.ofNullable(null); // OK
```

* Optional타입의 참조변수를 기본값으로 초기할 때는 empty()를 사용
* null로 초기화하는것이 가능하지만, empty()로 초기화 하는 것이 바람직하다.
```java
Optional<String> optVal = null; // null로 초기화, 바람직하지 않다.
Optional<String> optVal = Optional.empty(); // 빈 객체로 초기화
```

* * *

### Optional 객체 값 가져오기

| 메서드 | 특징 | 
|---|:---:|
| `get()` | 저장된 값을 반환, null일 경우 NoSuchElementExceptopn 발생 |
| `orElse()` | 저장된 값을 반환, null일 경우, ()안의 값을 반환한다. ex) (123) -> null이면 123을 반환|
| `orElseGet()` | 저장된 값을 반환, null일 경우 ()안의 값 반환한다. *()안에 람다식 지정 가능 |
| `orElseThrow` | null일 경우 지정된 예외를 발생시킨다. |

* * *
### isPresent()
* isPresent()는 <u>Optional객체의 값이 null이면 false를, 아니면 true를 반환</u>
* isPresent(Consumer block)는 값이 있으면 주어진 람다식을 실행하고, 없으면 아무일도 하지 않는다.
```java
    // null체크를 위한 기본 if문
    if(str != null){ 
        System.out.println(str);
    }
    
    // isPresent를 이용한 null 체크
    if(Optional.ofNullable(str).isPresent()){
        System.out.println(str);
    }
    
    // ifPresent()를 이용한 null 체크
    // null아니면 ()안의 내용을 실행하고, null이면 아무 일도 일어나지 않는다.
    Optional.ofNullable(str).ifPresent(System.out::priint);
```

* * *

### OptionalInt, OptionalLong, OptionalDouble

* IntStream과 같은 기본형 스트림의 최종 연산의 일부는 Optional대신
기본형을 값으로 하는 OptionalInt, OptionalLong, OptionalDouble을
  반환한다.
  * OptionalInt findAny()
  * OptionalInt findFirst()
  * OptionalInt reduce(IntBinaryOperator op)
  * OptionalInt max()
  * OptionalInt min()
  * OptionalDouble average()
  

* Q : Optional에 저장된 값이 0인 경우 아래 두 Optional객체는 같은 것일까?
```java
OptionalInt opt = OptionalInt.of(0); // OptionalInt에 0을 저장
OptionalInt opt2 = OptionalInt.empty(); // OptionalInt에 0을 저장
```

* A : 저장된 값이 없는 것(empty)과 저장된 값이 0을 구분할 땐 isPresent()라는 인스턴스
변수로 구분이 가능하다. isPresent()는 이 인스턴스 변수의 값을 반환한다.
```java
System.out.println(opt.isPresent()); // true
System.out.println(opt2.isPresent()); // false
System.out.println(opt.quals(opt2)); // false
```  





