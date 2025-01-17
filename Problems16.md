# 연습문제
1. 메소드와 매개변수란?
```
메서드란? 미리 만들어 놓은 코드 블럭을 호출해서 사용하는 것을 의미
매개변수는 메소드에서 필요한 기능을 실행할 때 필요한 데이터를 넘겨줄때 사용
```
2. `String.format()`은 어디에 사용하는 메소드 인지 기술하고 %s,%d,%f에 매칭되는 자료형은 무엇인지 기술하시오.
```
매개변수를 가지고 실행결과 새로운 문자열을 만들어 주는 일을 하는 메소드
%s => 문자열을 대입
%d => 정수를 대입
%f => 실수를 대입
```
3. `int age=156, String name = “hong”, double height=175.3` 다음 데이터와 `String.format`를 이용해서 문자열로 만들어 출력해 보자.
```
int age = 156;
String name "hong";
double height = 175.3;
System.out.println(String.format("이름 : %s \n나이: %d \n키: %f"),name,age,height);
```
4. 사용자로부터 2개의 정수를 받아서 첫번째 정수를 두번째 정수로 나누었을때의 몫과 나머지를 계산하는 프로그램을 작성하시오. 
```
ex)실행결과: 몫은 2 이고, 나머지는 1이다.
```
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
System.out.println("몫은 " + (a / b) + " 이고, 나머지는 " + (a % b) + " 이다.");
```
5. 3자리 숫자를 입력하여 각자리의 숫자를 출력하시오. 힌트) %연산자와 /연산자를 이용하여 만들수 있다. 
```
423를 100으로 나누면 몫은 4고 나머지는 23이다. 
23를 10으로 나눈 몫은 2이고 나머지는 3이다. 
```
```
ex)423를 입력하였다면 백의 자리:4 십의 자리:2 일의 자리:3 이 출력 되도록 만들어 보자.
```
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
System.out.println(a + "를" + b +" 으로 나누면 몫은 " + (a / b) + " 이고, 나머지는 " + (a % b) + " 이다.");
```
```
java.util.Scanner sc = new java.util.Scanner(System.in);
String a = sc.nextLine();
System.out.println("백의 자리:" + a.charAt(a.length() - 3) + "십의 자리:" + a.charAt(a.length() - 2) + "일의 자리:" + a.charAt(a.length() - 1));
```
6. 두점을 입력 받아 두점의 거리를 구하는 프로그램을 만들어보자. 
두점의 거리를 구하는 방법을 웹에서 검색해보자. 
```
힌트) Math.sqrt(25)=5 이다. x제곱은 x*x 이다.
```
```
java.util.Scanner sc = new java.util.Scanner(System.in);
String point1 = sc.nextLine();
int x1 = Integer.parseInt(point1.split(",")[0]);
int y1 = Integer.parseInt(point1.split(",")[1]);

String point2 = sc.nextLine();
int x2 = Integer.parseInt(point2.split(",")[0]);
int y2 = Integer.parseInt(point2.split(",")[1]);

int x = x1 > x2 ? x1 - x2 : x2 - x1;
int y = y1 > y2 ? y1 - y2 : y2 - y1;
System.out.println(Math.sqrt((double)(x*x)+(double)(y*y)));
```
