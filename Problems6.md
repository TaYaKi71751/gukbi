# 연습문제
1. `함수`란? 
```
    반복되는 복잡한 코드를 미리 선언해 두고 필요할때 마다 호출해서 사용하는 코드 블럭을 의미
```
2. `상수`란? 
```
    변하지 않는 수를 의미
```
3. `변수`란?
```
    변하는 수를 의미
```
4. `메소드`란? 
```
    함수가 객체에서 사용된 것
```
5. `객체`란? 
```
    관련있는 데이터와 메소드를 묶어서 표현한것
```
6. `심볼릭 상수`란? 
```
    이름을 가지고 있는 상수
```
7. 각 자료형의 상수표현 방법을 설명하시오. 
```
    boolean => true,false
    int = > 1,2
    double => 1.2,3.4
    String => "ABCD"
```
8. 우선순위를 이야기해 보자. 
```
    곱하기 및 나누기가 먼저 실행 된다.
```
9. `“10”+10+10`, `10+10+“10”`, `10+10`, `“10+10”`, `“10”+ “10”` 다음 각각의 실행결과를 생각해보자.
```
    "10"+10+10 => "101010"
    10+10+"10" => "2010"
    10+10 => 20
    "10+10" => "10+10"
    "10" + "10" => "1010"
```
10. 다음 요구사항에 맞는 Java 클래스를 작성하세요. 
```
MAX_STUDENTS라는 심볼릭 상수를 정의하고, 값을 30으로 설정합니다. 
SCHOOL_NAME이라는 심볼릭 상수를 정의하고, 값을 "우리학교"로 설정합니다.
main 메소드에서 두 상수를 출력하세요. 
```
```
public class School { 
    // 여기에 심볼릭 상수를 정의하세요. 
    public static final int MAX_STUDENTS = 30;
    public static final String SCHOOL_NAME = "우리학교";
    public static void main(String[] args) { 
        // 여기에 상수를 출력하는 코드를 작성하세요. 
        System.out.println(School.MAX_STUDENTS);
        System.out.println(School.SCHOOL_NAME);
    } 
}
```

11. 다음 요구사항에 맞는 Java 클래스를 작성하세요. 
```
FAVORITE_COLOR라는 심볼릭 상수를 정의하고, 값을 "파란색"으로 설정합니다. 
FAVORITE_FOOD라는 심볼릭 상수를 정의하고, 값을 "피자"로 설정합니다. 
main 메소드에서 두 상수를 출력하세요. 
```
```
public class Favorites { 
    // 여기에 심볼릭 상수를 정의하세요. 
    public static final String FAVORITE_COLOR = "파란색";
    public static final String FAVORITE_FOOD = "피자";
    public static void main(String[] args) { 
        // 여기에 상수를 출력하는 코드를 작성하세요. 
        System.out.println(Favorites.FAVORITE_COLOR);
        System.out.println(Favorites.FAVORITE_FOOD);
    } 
}
```
