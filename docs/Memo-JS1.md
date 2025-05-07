# JavaScript
## 표현식
```
표현식(Expressions)은 프로그래밍에서 의미를 가지는 가장 작은 코드 단위를 나타냅니다.
표현식을 모아서 하나의 문장(Statement)을 만들 수 있으며, 이러한 문장은 프로그램의 명령어가 됩니다.
```
### 숫자
```
11은 숫자 표현식이며, 값 11을 나타냅니다.
```
### 연산자
```
+는 덧셈 연산자를 나타내며, 두 개의 피연산자를 더하는 연산을 표현합니다.
```
### 문자열
```
'hi'는 문자열 표현식이며, 문자열 "hi"를 나타냅니다
```
### 변수
```
var는 변수를 선언하는 표현식입니다.
```
### 조건문
```
if는 조건문을 시작하는 표현식입니다.
```
## 키워드
```
키워드(Keywords): 키워드는 프로그래밍 언어에서 특별한 의미가 부여된 단어로, 변수, 함수, 제어 구조 등을 정의하거나 조작하는 데 사용됩니다. 
JavaScript의 키워드에는 var, if, else, for, function 등이 있습니다.
```
## 예약어
```
예약어는 현재는 사용되지 않지만 나중에 키워드로 예약된 단어를 의미합니다.
```
## \<script\> 태그 사용
```
JavaScript 코드를 HTML 문서에서 실행하려면 <script> 태그안에 기술
한다.
```
## 세미콜론 (;) 사용
```
JavaScript에서는 일반적으로 문장의 끝에 세미콜론을 붙입니다. 
이것은 문법적으로 필수는 아니지만, 코드의 가독성을 높이고 오류를 방지하는 데 도움이 됩니다. 
따라서 생략 가능하지만 세미콜론을 붙이는 것이 권장됩니다.
```
## 주석(Comments)
```
주석은 코드에 대한 설명이나 메모를 추가할 때 사용됩니다. 
JavaScript에서는 한 줄 주석(//)과 여러 줄 주석(/* */) 두 가지 주석 형식을 지원합니다. 
주석은 코드 실행에 영향을 미치지 않으며, 주로 코드를 이해하기 쉽게 만들거나 다른 개발자와 코드를 공유할 때 유용합니다.
```
## 상수
### 숫자(Number) 상수
```
3, 4 ,10, 123.2 정수와 실수로 구성되어 있다.
```
### 문자열(String) 상수
```
'' 또는 ""로 묶어서 문자열을 표현한다. ‘123’, “안녕”
```
### 불린(Boolean) 상수
```
true: 참(참값을 나타내는 상수) false: 거짓(거짓값을 나타내는 상수)
```
## 변수
```
JavaScript에서 변수는 자료형에 관계없이 var 키워드로 선언합니다. 
JavaScript는 동적으로 자료형을 결정하므로 변수에 값이 할당되면 해당 값의 자료형을 결정합니다.
상수는 값을 변경할 수 없지만 변수는 할당 연산자를 이용해서 값을 변경할 수 있다.
```
```javascript
var a=10; var b= “hello”; //var a; a=10; 변수선언 및 값 할당
document.write(a); document.write(b);//변수를 통한 값 출력
document.write(10); document.write(“world”);//상수를 통한 값 출력
a= “hello”; b=10; //변수의 자료형과 값을 변경
document.write(a); document.write(b);//변경된 변수의 값 출력
```
## typeof
```
typeof는 다음에 오는 데이터의 자료형이 어떤 자료형인지 문자열이 생성된다.
```
### Number
```javascript
// 숫자형 (Number): 정수와 실수를 다루는 자료형입니다.
document.write(10, typeof(10), "<br>"); // 출력: 10 number
document.write(10.1, typeof(10.1), "<br>"); // 출력: 10.1 number
var myNum = 10;
document.write(myNum, typeof(myNum), "<br>");
// 출력: 10 number
myNum = 10.1;
document.write(myNum, typeof(myNum), "<br>"); // 출력: 10.1 number
```
### Boolean
```javascript
// 불리언 (Boolean): true와 false 두 가지 값을 가지는 자료형입니다.
var myBoolean = true;
document.write(myBoolean, typeof(myBoolean), "<br>"); // 출력: true boolean
myBoolean = false;
document.write(myBoolean, typeof(myBoolean), "<br>"); // 출력: false boolean
```
### String
```javascript
// 문자열 (String): 작은 따옴표 ('') 또는 큰 따옴표 ("")로 묶어서 문자열을 표현합니다.
var myString = "hello";
document.write(myString, typeof(myString), "<br>"); // 출력: hello string
```
### Array
```javascript
// 배열 (Array): 여러 값을 하나의 변수에 저장하는 자료형입니다. 대괄호 [ ]를 사용하여 정의하며, 각 요소는 쉼표로 구분됩니다.
var myArray = ["A", "B", "C"];
document.write(myArray[0], "<br>"); // 출력: A
myArray[0] = "D";
document.write(myArray[0], "<br>"); // 출력: D
document.write(myArray, typeof(myArray), "<br>"); // 출력: [D, B, C] object
```
### Object
```javascript
// 객체 (Object): 자바스크립트 객체를 json이라고 한다. 키-값 쌍으로 구성된 복합 자료형입니다. 중괄호 { }를 사용하여 정의합니다.
var myPerson = {
firstName: "John",
age: 40,
8
eyeColor: "blue"
};
document.write(myPerson.firstName, myPerson.age, myPerson.eyeColor, "<br>"); // 출력: John 40 blue
myPerson.age = 50;
document.write(myPerson.firstName, myPerson.age, myPerson.eyeColor, "<br>");
document.write(myPerson, typeof(myPerson), "<br>"); //John 50 blue object
// 객체의 내용을 명확히 알고 싶다면 console.log로 찍으면 자세히 확인할 수 있다.
```
### Function
```
함수 (Function): 함수는 반복되는 코드 블록을 미리 정의해두고, 
필요할 때 해당 블록을 호출하여 실행하는 방법입니다. 
코드의 선언부는 반복되는 작업을 수행하는 코드 블록을 의미하며, 
호출부는 선언된 코드 블록을 실행시키는 부분입니다. 
이러한 호출은 필요할 때마다 반복됩니다.
함수를 사용하면 코드를 논리적으로 나누고, 
재사용성을 높일 수 있어서 코드를 더 효율적으로 관리할 수 있습니다.
```
```javascript
var myFunction = function () {//선언부
 alert('hello'); alert('world');
};
document.write(myFunction, typeof(myFunction)); // 출력: function
myFunction(); // 'hello' 알림이 표시됨 // 호출부
myFunction();
myFunction();
```
### undefined
```
undefined: 자료형이 결정되지 않고 값이 할당되지 않은 상태를 나타냅니다.
```
```javascript
var a;
document.write(a, typeof(a), "<br>"); // 출력: undefined
```
## backtick
```javascript
// ` 백틱으로 문자열을 감싸면 일반적인 문자열과 동일한 문자열을 생성할 수 있습니다.
const name = "Alice";
const greeting = `안녕하세요, ${name}!`;
console.log(greeting); // "안녕하세요, Alice!"
// 여러 줄에 걸친 문자열을 쉽게 생성할 수 있습니다.
const multiLineText = `
이것은
멀티라인
문자열입니다.
`;
console.log(multiLineText);
/*
이것은
멀티라인
문자열입니다.
*/
// ${}를 사용하여 변수나 표현식을 문자열 중간에 삽입할 수 있습니다.
const num1 = 5;
const num2 = 10;
const result = `더하기: ${num1 + num2}`;
console.log(result); // "더하기: 15"
```
## 연산자
### 산술 연산자
```javascript
// 1. 산술 연산자 (Arithmetic Operators): 수학적 계산을 실행하는 연산
// + : 덧셈 - : 뺄셈 * : 곱셈 / : 나눗셈 % : 나머지 연산 ** : 거듭제곱
var addition = 5 + 3; // 5 + 3 = 8
var subtraction = 10 - 4; // 10 - 4 = 6
var multiplication = 6 * 2; // 6 * 2 = 12
var division = 20 / 4; // 20 / 4 = 5
var modulus = 17 % 5; // 17 % 5 = 2
var exponentiation = 2 ** 3; // 2^3 = 8
```
### 할당 연산자
```javascript
// 2. 할당 연산자 (Assignment Operators): 변수에 값을 할당하는 연산
// = : 값 할당 += : 덧셈 후 할당 -= : 뺄셈 후 할당
// *= : 곱셈 후 할당 /= : 나눗셈 후 할당 %= : 나머지 연산 후 할당
var x = 10; //x에 10을 넣는다.
x += 5; // x = x + 5 = 15 계산된 결과를 x에 넣는다.
var y = 20; //y에 20를 넣는다.
y -= 8; // y = y - 8 = 12
```
### 비교 연산자
```javascript
// 3. 비교 연산자 (Comparison Operators): 두 개의 값을 비교하여 조건의 참 또는 거짓을
// 판단하는 연산자 연산결과 boolean자료형의 true false가 생성된다.
// == : 값이 같은지 비교 (동등 연산자)
// != : 값이 다른지 비교 (부등 연산자)
// === : 값과 타입이 모두 같은지 비교 (일치 연산자)
// !== : 값 또는 타입이 다른지 비교 (불일치 연산자)
// > : 크다 < : 작다 >= : 크거나 같다 <= : 작거나 같다
// ‘1’==1 ‘1’은 형변환 한 값이 1이므로 true이고 ‘1’==1은 자료형이 다르므로 false이다.
var x=15; var y=10;
var isEqual = x == y; // false
var isNotEqual = x != y; // true
var isStrictEqual = x === 15; // true
var isNotStrictEqual = y !== '12'; // true
var isGreater = x > y; // true
var isLess = x < y; // false
var isGreaterOrEqual = x >= y; // true
var isLessOrEqual = y <= 12; // true
```
### 논리 연산자
```javascript
// 4. 논리 연산자 (Logical Operators):
// 두 개의 boolean 자료형 값을 연산하여 하나의 결과를 얻는 연산자에는 여러 종류가 있습니다.
// 일반적으로, 두 조건이 모두 true일 때 true를 반환하는 && 연산자, 둘 중 하나만 true여도 true를 반환하는 || 연산자, 그리고 true면 false , false 면 true로 반전시키는 ! 연산자가 있습니다. 
// 이 연산자들을 사용하여 boolean 값을 조작할 수 있습니다.
// 진리표를 웹에서 검색해서 좀더 자세한 연산 결과를 확인해 보자.
// && : 논리적 AND (그리고) || : 논리적 OR (또는) ! : 논리적 NOT (부정)
var condition1 = true;
var condition2 = false;
var logicalAnd = condition1 && condition2; // false
var logicalOr = condition1 || condition2; // true
var logicalNot = !condition1; // false
// !false===true 의 결과는 true가 된다.
```
### 삼항 연산자
```javascript
// 5. 삼항 연산자 (Ternary Operator):
// condition ? “condition이 true일때실행”: “condition이 false일때실행”; condition이 상태에 따라 두 가지 표현식 중 하나가 선택이 된다.
var age = 18;
var isAdult = age >= 18 ? '성인' : '미성년자'; // '성인'
```
### 증감 연산자
```javascript
// 6. 증감 연산자
// 증감 연산자는 변수의 값을 1만큼 증가(++)시키거나 1만큼 감소(--)시키는 데 사용
// 증감 연산자의 위치에 따라 연산 결과가 달라질 수 있다.
// 전치 연산 (++count, --count): 변수의 값을 증가시키거나 감소시킨 후, 그 값을 반환합니다.
var a = 5;
var b = ++a; // a의 값을 1 증가시킨 후, b에 6을 할당 
// 후치 연산 (count++, count--): 변수의 값을 반환한 후, 그 값을 증가시키거나 감소시킵니다.
var x = 10;
var y = x--; // x의 값을 y에 할당한 후, x의 값을 1 감소시킴 실행후 x=11,y=10
```
## 내장 함수
```javascript
//Number(),parseFloat(),parseInt(),String(),toFixed()
//Number는 문자열을 숫자 데이터로 변경한다.
//parseFloat는 문자열을 실수로 변환한다.
//parseInt는 문자열을 숫자로 변환한다.
//String 다른 자료형을 문자열로 변환한다.
//toFixed(2) 실수를 소수점 2자리로 반올림 한다.
```
```javascript
var result=prompt("성적은?","여기입력");
document.write(result,"<br>");
document.write(result+10,"<br>");// 사용자입력은 문자열
document.write(typeof result,"<br>");
result=Number(result);
document.write(result+10,"<br>");
document.write(typeof result,"<br>");
```
```javascript
var result='14.5';
document.write(Number(result),"<br>");
document.write(parseFloat(result),"<br>");
document.write(parseInt(result),"<br>");
document.write(String(result),"<br>");
```
```javascript
var result='14';
document.write(Number(result),"<br>");
document.write(parseFloat(result),"<br>");
document.write(parseInt(result),"<br>");
document.write(String(result),"<br>");
```
```javascript
var result='14.5원';
document.write(Number(result),"<br>");
document.write(parseFloat(result),"<br>");
document.write(parseInt(result),"<br>");
document.write(String(result),"<br>");
var word=window.confirm("true or false")?true:false;
document.write(word,"<br>");
```
```javasccript
//toFixed
var number = 3.14159265;
//소수점 두 자리로 반올림한 문자열 "3.14"
var roundedNumber=number.toFixed(2);
document.write(roundedNumber,"<br>");
```
## 조건문
### if
```
if 문: 특정 조건이 참일 경우에 코드 블록을 실행합니다.
if (조건) {
// 조건이 참일 때 실행되는 코드
}
```
```javascript
var temperature = 25;
if (temperature > 30) {
console.log("더워요!");
}
```
### if-else
```
if-else 문: 특정 조건이 참이면 첫 번째 코드 블록을 실행하고, 그렇지 않으면 두 번째 코드 블록을 실행합니다.
if (조건) {
// 조건이 참일 때 실행되는 코드
} else {
// 조건이 거짓일 때 실행되는 코드
}
```
```javascript
var age = 17;
if (age >= 18) {
console.log("성인입니다.");
} else {
console.log("미성년자입니다.");
}
```
### else-if
```
else if 문: 여러 개의 조건을 동시에 체크하여 위에서 아래로 처음 조건에 맞는 하나의 코드 블럭을 실행한다. 일치하는 것이 없으면 else에 기술된 코드 블럭이 실행 된다.
if (조건1) {
// 조건1이 참일 때 실행되는 코드
20
} else if (조건2) {
// 조건2가 참일 때 실행되는 코드
} else {
// 위의 모든 조건이 거짓일 때 실행되는 코드
}
```
```javascript
var score = 75;
if (score >= 90) {
console.log("A 학점");
} else if (score >= 80) {
console.log("B 학점");
} else if (score >= 70) {
console.log("C 학점");
} else {
console.log("D 학점");
}
```
### switch
```
switch문 : else if문중 비교 대상이 1:1 매칭이면 switch문을 만들 수 있다.
switch (변수) {
case 값1:
// 표현식이 값1과 일치할 때 실행되는 코드
break;
case 값2:
// 표현식이 값2와 일치할 때 실행되는 코드
break;
// 추가적인 case문들...
default:
// 모든 case에 해당하지 않을 때 실행되는 코드
}
switch 뒤 () 중괄호 안에 비교할 변수를 넣는다.
각 case는 비교할 변수의 값과 일치할 때 실행될 코드 블록입니다.
break 문은 각 case 블록의 끝에서 사용되어 해당 case에서 코드 실행을 중단하고 switch문을 빠져나갑니다.
case문 안에 break문이 없으면 다음 case문이 실행된다.
default는 어떤 case에도 일치하지 않을 때 실행될 코드 블록입니다. default는 선택사항이며
생략할 수 있습니다.
```
```javascript
var day = "월요일";
switch (day) {
case "월요일":
console.log("열심히 시작하는 월요일!");
break;
case "수요일":
console.log("이제 절반을 향해 가는 수요일!");
break;
case "금요일":
console.log("주말이 곧 다가오는 금요일!");
break;
default:
console.log("일주일의 중간일 것 같습니다.");
}
```
