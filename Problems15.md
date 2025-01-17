# 연습문제

1. 콘솔창이란?
```
실행 과정을 보여주는 곳
```
2. `java.util.Scanner scanner =new java.util.Scanner(System.in);` 의 의미는 무엇인가?
```
Scanner라는 자료형을 변수 scanner로 만들고 scanner 변수를 사용할 수 있도록 객체 생성하는 부분
```
3. `scanner.nextLine()`의 의미는 무엇인가?
```
사용자가 입력한 문자열을 프로그램 안으로 가져오는 역할
```
4. 프로그램에서 사용자가 입력한 데이터는 모두 어떤 자료형이 되는가?
```
문자열
```
다음 문제들을 사용자 입력을 받아서 처리 해보자. 기억나지 않는 수학공식은 웹에 검색해서 알아 보자.
5. 세로와 가로를 입력 받아 사각형의 넓이를 만드는 순서도와 프로그램을 만들어 보자.
```
java.util.scanner sc = new java.util.scanner(system.in);
int height = integer.parseint(sc.nextline());
int width = integer.parseint(sc.nextline());
system.out.println(height * width);
```
6. 세로 가로 높이를 입력 받아 사각기둥의 부피를 만드는 순서도와 프로그램을 만들어 보자.
```
java.util.scanner sc = new java.util.scanner(system.in);
int x = integer.parseint(sc.nextline());
int y = integer.parseint(sc.nextline());
int z = integer.parseint(sc.nextline());
system.out.println(x * y * z);
```
7. a 센치미터가 몇 미터 몇 센치인지 출력하는 프로그램을 구현 하시오. 100cm=1m
```
java.util.scanner sc = new java.util.scanner(system.in);
int a = Integer.parseInt(sc.nextLine());
System.out.println(a/100 + "m " + a%100 + "cm");
```
8. 잔디의 가격은 1 제곱 미터에 a원일 때 윗변이 b,아래변이 c, 높이d인 사다리꼴에 잔디를 심으려면 얼마의 비용이 드는지 구하는 순서도를 작성하시오.
```
java.util.scanner sc = new java.util.scanner(system.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
int c = Integer.parseInt(sc.nextLine());
int d = Integer.parseInt(sc.nextLine());
System.out.println((b + c) * d / 2 * a);
```
9. 이름 나이 키를 입력받은 화면에 출력하는 프로그램을 작성해 보자. 출력결과:
```
당신의 이름은 홍길동 입니다.당신의 나이는 23입니다. 당신의 키는 165.5 입니다.
```
```
java.util.scanner sc = new java.util.scanner(system.in);
String name = sc.nextLine();
int age = Integer.parseInt(sc.nextLine());
double height = Double.parseDouble(sc.nextLine());
System.out.println("당신의 이름은 " + name + " 입니다. 당신의 나이는 " + age + "입니다. 당신의 키는 " + height + " 입니다.")
```
10. 두수를 입력받아 두수의 차를 출력하는 프로그램을 작성해보자.
```
java.util.scanner sc = new java.util.scanner(system.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
System.out.println(a - b);
```
11. 다음은 국어,영어,수학 점수를 입력 받아 평균을 구하여 다음과 같이 출력하는 프로그램을 만들어보자. 
```
출력결과: 국어:80 영어:70 수학:90 평균:80
```
```
java.util.scanner sc = new java.util.scanner(system.in);
int kor = Integer.parseInt(sc.nextLine());
int eng = Integer.parseInt(sc.nextLine());
int math = Integer.parseInt(sc.nextLine());
int avg = (kor + eng + math) / 3;
System.out.println("국어:" + kor + " 영어:" + eng + " 수학:" + math + " 평균:" +avg);
```
12. 키를 m로 소수점 2째 자리까지 입력받아 cm로 바꿔주는 프로그램을 만들어 보자.
```
java.util.scanner sc = new java.util.scanner(system.in);
double m = Math.round(Double.parseDouble(sc.nextLine()), 2);
System.out.println((int)(m * 100));
```
13. 상자의 가로, 세로, 높이를 입력받아 부피를 구하는 프로그램을 만들어 보자.
```
java.util.scanner sc = new java.util.scanner(system.in);
int x = integer.parseint(sc.nextline());
int y = integer.parseint(sc.nextline());
int z = integer.parseint(sc.nextline());
system.out.println(x * y * z);
```
14. 연필 한박스에 12자루의 연필이 들어 있고 연필 1자루는 1000원 이다. 소비자가 몇 박스와 연필 몇자루를 구매할 것인지 입력 받아 지불해야 할 돈을 계산해주는 프로그램을 만들어 보자.
```
java.util.scanner sc = new java.util.scanner(system.in);
int box = Integer.parseInt(sc.nextLine());
int pencil = Integer.parseInt(sc.nextLine());
System.out.println(((box * 12) + pencil) * 1000 + "원");
```
15. 전체 박스 갯수, 한박스의 연필 갯수, 연필 가격을 입력 받아 전체비용를 계산해보자.
```
java.util.scanner sc = new java.util.scanner(system.in);
int box = Integer.parseInt(sc.nextLine());
int pencilPerBox = Integer.parseInt(sc.nextLine());
int pencilPrice = Integer.parseInt(sc.nextLine());
System.out.println(box * pencilPerBox * pencilPrice);
```
