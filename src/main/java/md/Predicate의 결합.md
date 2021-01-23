## Predicate의 결합  

* 여러 조건식을 논리 연산자인 &&(and), ||(or), !(not)으로 를
  연결해서 하나의 식을 구성할 수 있는 것처럼, 여러 Predicate를 
  and(), or(), negate()로 연결해서 하나의 새로운 Predicate로 
  결합할 수 있다.

```java
Predicate<Integer> p = i -> i < 100;
Predicate<Integer> q = i -> i < 200;
Predicate<Integer> r = i -> i%2 == 0;
Predicate<Integer> notp = p.negate(); // i >= 100

// 100 <= i && (i < 200 || i%2==0)
Predicate<Integer> all = notP.and(q.or(r));
System.out.println(all.test(150)); // true
```
* 이처럼 and(), or(), negate()로 여러 조건식을 하나로 합칠 수 있다.  
  
  * * *  
  
  
### static메서드인 <u>isEqual()은 두 대상을 비교</u>하는 Predicate를 만들 때 사용한다.

+ isEqual()의 매개변수로 비교대상을 하나 지정하고, 
  또 다른 비교 대상은 test()의 매개변수로 지정한다.

```java
Predicate<String> p = Predicate.isEqual(str1);
boolean result = p.test(str2); // str1.equals(str2)와 같다.

// 위의 두 문장을 합치면 아래와 같다.
boolean result = Predicate.isEqual(str1).test(str2);
```

* 여러 문장을 Predicate를 사용하여 표현하면 코드가 간결하고 이해하기 더 쉬워진다.

  
