[pdf](./JAVA240812simple254.pdf)
# 다음 문제를 확인해 보자.
1. 숫자를 하나 입력 받아 홀수 인지 짝수 인지 구하는 프로그램을 구하여라.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
System.out.println(a % 2 == 0 ? "짝수" : "홀수");
```
2. 숫자 2개를 입력 받아 첫번째 숫자가 두번째 숫자의 배수인지 아닌지 출력하는 프로그램을 구하여라.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
System.out.println(a % b == 0 ? "배수이다." : "배수가 아니다.");
```
3. a 원을 동전으로 바꾸면 500원짜리 몇 개 100원짜리 몇 개가 되는가?
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int _500 = a / 500;
int _100 = (a % 500) / 100;
System.out.println("500원 " + _500 + "개");
System.out.println("100원 " + _100 + "개");
```
4. 500원짜리 n개 100원짜리 m개 총 얼마인가?
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int n = Integer.parseInt(sc.nextLine());
int m = Integer.parseInt(sc.nextLine());
System.out.println((n * 500) + (m * 100) + "원"); 
```

5. n초를 입력 받아 시분초로 바꿔보자.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int input = Integer.parseInt(sc.nextLine());
int seconds = input % 60;
int minutes = (input / 60) % 60;
int hours = input / 60 / 60;
System.out.println(hours + "시간 " + minutes + "분 " + seconds + "초");
```
6. n시간 m분 l초는 총 몇초인가?
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int hours = Integer.parseInt(sc.nextLine());
int minutes = Integer.parseInt(sc.nextLine());
int seconds = Integer.parseInt(sc.nextLine());
int result = (hours * 60 * 60) + (minutes * 60) + seconds;
System.out.println(result + "초");
```
