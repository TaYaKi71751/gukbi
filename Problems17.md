[pdf](./pdf/JAVA240812simple148.pdf)
# 연습 문제

1) 지역변수와 전역변수를 설명해보자.
```
전역변수 : 
    프로그램 모든 곳에서 사용할 수 있는 변수이다. 
    클래스안에 static를 붙여서 변수를 선언하면 된다. 
    보통 클래스 내부 상단에 기술한다.
지역변수 : 
    메소드의 중괄호 안에 선언된 변수를 지역 변수라 한다. 
    해당 중괄호 블럭 안에서만 사용할 수 있다.
```
2) 다음 코드가 잘못된 이유를 설명하시오.
```
package com.human.ex;
public class JavaStart10 {
    public static int a=22;
    public static void main(String[] args) {
        int a=10;
        {
            int a=20;
            System.out.println(a);
        }
    }
}
```
```
main 함수 안에서 a 가 두번 선언 되었다
```
3) 다음 코드가 정상적인 코드 인지 아닌지 설명하고 정상적으로 고쳐보자.
```
package com.human.ex;
public class JavaStart10 {
    public static void main(String[] args) {
        {
            int a=21;
            System.out.println(a);
        }
        System.out.println(a);
        {
            int a=22;
        }
        System.out.println(a);
    }
}
```
```
정상적이지 않은 코드이다.
```
```
package com.human.ex;
public class JavaStart10 {
    public static void main(String[] args) {
        {
            int a=21;
            System.out.println(a);
        }
        {
            int a=22;
            System.out.println(a);
        }
    }
}
```
4) 다음 코드가 정상적인 코드 인지 아닌지 설명하고 정상적으로 고쳐보자.
```
package com.human.ex;
public class JavaStart10 {
    public static int a=22; // 전역변수는 모든 지역에서 사용할 수 있다.
    public static void main(String[] args) {
        {
            int a=21;
            System.out.println(a);
        }
        System.out.println(a);
        {
            int a=22;
            System.out.println(a);
        }
        System.out.println(a);
    }
}
```
```
정상적인 코드이다.
```
