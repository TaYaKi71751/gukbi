[pdf](../../pdf/JAVA240812simple148.pdf)
#  자료형과 연산출력 기본문법 2 

1. 입력 
```java
System.out.println(100); 
```
출력 
```
100
```
2. 입력 
```java
System.out.println(20+30); 
```
출력
```
50
```
3. 입력 
```java
System.out.println(“20+30”); 
```
출력
```
20+30
```
4. 입력
```java
System.out.println(15.4);
```
출력 
```
15.4 
```
4. 입력 
```java
System.out.println(“15.4”); 
```
출력
```
15.4
```
```
결과는 같지만 숫자가 아닌 문자로 출력한 것이다. 
```
5. 입력 
```java
System.out.println(“10”+10+20); 
```
출력
```
101020
```
```
문자+숫자는 문자가 되어 결과가 다음과 같다. 
```
6. 입력 
```java
System.out.println(10+10+ “20”); 
```
출력
```
2020
```
```
+연산은 앞에 두개씩 연산이 되어 10+10은 20이 된다.
, 다음에 숫자 +문자 연산된 것이다. 
```
7.입력 
```java
System.out.println(2+6*(4*2)); 
```
출력
```
50
```


연산자 우선순위를 생각해 보고 계산 결과를 얻어 보자. 

8.입력
```java
System.out.println(“2*(4+3+2)+(4+1*2)”); 
```
출력
```
2*(4+3+2)+(4+1*2)
```
11.입력 
```java
System.out.println(“(5+3)”); 
```
출력 
```
(5+3)
```
12.입력
```java
System.out.println(“7+3=”+(7+3)); 
```
출력 
```
7+3=10
```


일부 문자열과 정수 7과 3만 이용해서 다음과 같이 출력해보자. 

13.입력 
```java
System.out.println(“7+3=”+7+3); 
```
출력
```
7+3=73
```
다음 실행결과를 눈으로 예측해 보자. 
```java
System.out.println(50 + 25); 
System.out.println("50 + 25"); 
System.out.println("50” + “25"); 
System.out.println(12.3); 
System.out.println("12.3"); 
System.out.println("5" + 15 + 10); 
System.out.println(5 + 15 + "10"); 
System.out.println(3 + 5 * (2 + 4)); 
System.out.println("3 * (2 + 4) = " + (3 * (2 + 4))); 
System.out.println("5 + 3 = " + 5 + 3);
```
결과:
```
75
50 + 25
5025
12.3
12.3
51510
2010
43
3 * (2 + 4) = 24
5 + 3 = 8
```
