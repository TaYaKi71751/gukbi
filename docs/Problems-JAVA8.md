[pdf](../pdf/JAVA240812simple148.pdf)
# 변수 - 기본문법 3
1.입력
```java
int a=10; 
System.out.println(a); 
```
출력 
```
10 
```
2.입력 
```java
int b=30; 
System.out.println(b); 
```
출력
```
30
```
3.입력 
```java
int b=30; 
System.out.println(b+10); 
```
출력
```
40
```
4.입력
```java
int c=30; 
System.out.println(c+c); 
```
출력
```
60
```
5.입력 
```java
// 변수명hello에 50를 넣고 변수를 이용해서 80이 찍히도록 해보자
int hello = 50;
System.out.println(hello + 30);
```
출력 
```
80
``` 
6.입력 
```java
int d=30; 
System.out.println(d); 
d=60; 
System.out.println(d); 
//변경된 변수의 이전 값은 접근할 수 있는 방법이 없다. 
//프로그램 안에서 지속적인 접근이 필요 하다면 변수를 2개 선언해서 각각의 변수에 따로 저장해야 한다. 
```
출력 
```
30 
60
```
7.입력 
```java
int d=30; 
int c=60; 
System.out.println(c); 
System.out.println(d); 
```
출력 
```
60 
30 
```

8.입력 
```java
int i1=22; 
int i2=11; 
int i3=33; 
System.out.println(i1+i2+i3); 
```
출력 
```
66 
```

9.입력 
```java
int world = 5;
System.out.println(world); 
int a = 6;
System.out.println(world+a); 
```
출력 
```
5 
11 
```

10.입력 
```java
int world=5; 
System.out.println(world+5); 
```
출력 
```
10 
```

11.입력 
```java
int world=5; 
System.out.println(“world”+5); 
```
출력 
```
world5 
```

12.입력 
```java
int world=5; 
System.out.println(“world”+world); 
```
출력 
```
world5
```

13.입력 
```java
int a=5; 
int b=6; 
System.out.println(“a+b=”+a+b); 
```
출력 
```
a+b=56
```

14.입력 
```java
int a=5; 
int b=6; 
System.out.println(“a+b=”+(a+b));
```
출력
```
a+b=11
```

15.입력 
```java
int a=5; 
System.out.println(a); 
a=3; 
System.out.println(a); 
```
출력 
```
5 
3 
```

16.입력 
```java
int a=5;//처음 a를 선언할때는 자료형을 붙인다. 
System.out.println(a); 
a=6;//기존 a를 사용할때는 자료형을 붙이지 않는다. 
System.out.println(a); 
int b=5; 
System.out.println(a+b); 
```
출력
```
5
6
11
```

17.입력 
```java
int a=5; 
a=6; 
a=7; 
a=8; 
System.out.println(a); 
```
출력
```
8
```

// 소수점이 있는 실수는 double사용 문자열은 String사용 
18. 입력 
```java
int a=5; 
double b=5.1; 
String st= “hello”; 
System.out.println(a+b+st); 
System.out.println(st+b+a); 
System.out.println(“a+b=”+(a+b)+st); 
```
출력
```
10.1hello
hello5.15
a+b=10.1hello
```

19.입력 
```java
int a=5; 
a=a+2; 
System.out.println(a); 
```
출력 
```
7 
```

20.입력 
```java
int sum=0; 
sum=sum+1; 
System.out.println(sum); 
sum=sum+2; 
System.out.println(sum); 
sum=sum+3; 
System.out.println(sum); 
int a=5; 
sum=a+5; 
System.out.println(sum); 
a=7; 
sum=sum+a; 
System.out.println(sum); 
```
출력 
```
1 
3 
6 
10 
17
```
