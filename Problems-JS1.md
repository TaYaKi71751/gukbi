# 다음 연습문제를 구현해 보자.
1.사용자로부터 2개의 정수를 받아서 첫 번째 정수를 두 번째 정수로 나누었을 때의 몫과 나머지를 계산하는 프로그램을 작성하라.
```javascript
var a = Number(prompt("정수입력",""));
var b = Number(prompt("정수입력",""));
console.log("몫",(a / b));
console.log("나머지",(a % b));
```
2.사용자로부터 하나의 정수를 받아서 정수의 세제곱 값을 계산하여 출력하는 프로그램을 작성하라.
```javascript
var a = Number(prompt("정수입력",""));
console.log(a ** 3);
```
3.사용자로부터 3개의 정수를 받아서 변수 x, y, z에 저장하고 다음 수식 (x * y - z)의 결과를 출력하는 프로그램을 작성하라.
```javascript
var x = Number(prompt("정수입력",""));
var y = Number(prompt("정수입력",""));
var z = Number(prompt("정수입력",""));
console.log(x * y - z);
```
4.세 자리로 이루어진 숫자를 입력받은 후 각각의 자리수를 분리하고 이 자리수를 출력하는 프로그램을 작성하라.
```javascript
var input = Math.floor(Number(prompt("정수입력","")));
input = input % 1000;
console.log('백의자리', input.toString()[input.toString().length - 3] ?? '0');
console.log('십의자리', input.toString()[input.toString().length - 2] ?? '0');
console.log('일의자리', input.toString()[input.toString().length - 1] ?? '0');

```
5.다음 수식의 값을 계산하여 화면에 출력하라. x의 값은 사용자로부터 입력받는다.
```
f(x) = (x^3 - 20) / (x - 7)
```
```javascript
var x = Number(prompt("수 입력",""));
console.log((x ** 3 - 20) / (x - 7));
```
6.2차원 평면에서 두 점 사이의 거리를 계산하는 프로그램을 작성한다.
```javascript
var x1 = parseFloat(prompt("첫 번째 점 x1 입력:"));
var y1 = parseFloat(prompt("첫 번째 점 y1 입력:"));
var x2 = parseFloat(prompt("두 번째 점 x2 입력:"));
var y2 = parseFloat(prompt("두 번째 점 y2 입력:"));
var distance = Math.sqrt(((x2 - x1) ** 2) + ((y2 - y1) ** 2));
alert("거리는 " + distance);
```
