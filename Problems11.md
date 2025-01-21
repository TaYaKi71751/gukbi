[pdf](./JAVA240812simple148.pdf)
# 연습문제

1. 변수이름 지을때 유의사항 6가지를 이야기해 보자.
```
1.대소문자를 구분한다.
int a; int A; 다른 변수 2개를 선언한 것이다.
2.int double과 같은 예약어, 키워드를 사용하면 안된다.
int int=10; //안된다.
키워드는 자바 문법으로 사용하는 약속된 문자열을 의미한다. 예약어는 키워드로 예약되어 있는 문자열이다.
3.숫자로 시작해서는 안된다.
int 1a=10;//안된다. 
int a1a=20; //된다. 
int a1=50;된다.
4.특수문자는 _ $ 두 가지만 허용된다. int _a=5; //된다. 되도록 사용하지 말자.
5.이미 선언된 변수명이나 메소드명 등 을 사용할 수 없다. 식별자는 하나만 존재해야 한다.
int a; int a; //안된다.
int main; //main메소드가 이미 식별자로 존재해서 안된다.
6. 나중에 배울 메소드와 클래스, 배열 등도 변수 명명법을 따른다.
결국, 알파벳 대소문자, 소문자, 숫자로 기술하는데 반드시 알파벳으로 시작해야 한다.
```
2. 변수 이름 지을때 관용적으로 지켜야 할 것들 4가지를 기술해 보자.
```
1.대소문자를 구분한다.
int a; int A; // 다른 변수 2개를 선언한 것이다.
2.int double과 같은 예약어, 키워드를 사용하면 안된다.
int int=10; //안된다.
키워드는 자바 문법으로 사용하는 약속된 문자열을 의미한다. 예약어는 키워드로 예약되어 있는 문자열이다.
3.숫자로 시작해서는 안된다.
int 1a=10;//안된다. 
int a1a=20; //된다. 
int a1=50; //된다.
4.특수문자는 `_` `$` 두 가지만 허용된다. 
int _a=5; //된다. 되도록 사용하지 말자.
```
3. 다음 변수가 정상인지 잘못 되었는지 판별하고 이유를 설명 하시오.
```
int 3i=5;//x starting with number
int i3i=5;//o 
int __hello=55;//o
int hello=5.3;//x type mismatch
int i+j=4;//특수기호는 x 
int public=5;//키워드 x
int i#2=5;//x  특수문자
int MyCatAge=10;//관용적 X 
int mycatage=20;//관용적 X
public class myCat(){}//관용적 X
```
4. 이름:홍길동 나이:29 키:170.1를 변수에 넣어서 화면에 출력하는 프로그램을만들어보자.
```
String name = "홍길동";
int age = 29;
double height = 170.1;
System.out.println(name + "\n" + age + "\n" + height);
```
5. 다음 자료형이 무슨 자료형 상수인지 확인해 보자.
```
10 => int, 
1. => double, 
6F => float, 
.23 => double, 
‘a’ => char
```
6. 다음을 실행시켜 결과를 출력해 보자. `a`에 `5`,`b=10`를 넣은 다음 `a`,`b`의 합을 화면에 출력해 보자.
```
int a = 5;
int b = 10;
System.out.println(a + b);
```
7. 다음을 변수명,클래스명,상수명으로 만들어보자.
해석: My computer specifications
```
변수:myComputerSpecifications
클래스:MyComputerSpecifications
상수:MY_COMPUTER_SPECIFICATIONS
```
해석: Play with the cat
```
변수:playWithTheCat
클래스:PlayWithTheCat
상수:PLAY_WITH_THE_CAT
```
