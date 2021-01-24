package stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamSortedExam {

    public static void main(String[] args) {

        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 100)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan) // 반별로 정렬
                        .thenComparing(Comparator.naturalOrder())) // 기본 정렬
                        .forEach(System.out::println);


    }
}

class Student implements Comparable<Student>{

    String name;        // 이름
    int ban;            // 반
    int totalScore;     // 총 점수

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    // 총점 내림차순을 기본 정렬로 한다.
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
