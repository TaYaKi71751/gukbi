[pdf](../../pdf/JAVA240812simple148.pdf)
# 연습문제
1. `=`,`+=`,`-+` 연산자를 설명해 보자.
```
a = 1; // => a 에 1 을 넣는다.
a += 1; // => a 에 1을 더한 후 넣는다.
a -= 1; // => a에 1을 뺀 후 넣는다.
```
2. `++` 전위 후위 연산자에 대해서 설명해 보자.
```
++a // => a에 1을 더한 것을 대입후 a를 리턴
a++ // => a를 리턴 후 a에 1 을 더한 것을 대입
```
3. `3=2;` `7=7;`이 에러인이유는?
```
상수에 대입 불가
```
4. `z=z+4;`의 의미는 무엇인가?
```
z에 z+4를 대입한다
```
5. `a-=10; c*=10;`의 의미는 무엇인가?
```
a-=10; // => a = a - 10;
c*=10; // => a = a * 10;
```
6. `++a, a++, --a, a--;` 의 의미를 설명하시오.
```
++a // => a에 1을 더한 것을 대입후 a를 리턴
a++ // => a를 리턴 후 a에 1 을 더한 것을 대입
--a // => a에 1을 뺀 것을 대입후 a를 리턴
a-- // => a를 리턴 후 a에 1 을 뺀 것을 대입
```
7. `10++`이 `컴파일 오류`가 나는 이유를 설명하시오.
```
상수에 대입 할 수 없음
```
8. `삼항 연산자`가 어떤것이 있으며 어떻게 사용하는지 설명하시오.
```
(a == b) ? (true일때 대입될 변수,상수,함수) : (false일때 대입될 변수,상수,함수)
```
9. 6개의 `비교 연산자`를 설명하시오?
```
>= (왼쪽이) 크거나 같다
<= (왼쪽이) 작거나 같다
> (왼쪽이) 크다
< (왼쪽이) 작다
== 같다
!= 다르다
```
