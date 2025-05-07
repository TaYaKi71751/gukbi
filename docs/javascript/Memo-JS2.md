# JavaScript
## 함수
```
함수 : 반복되는 코드를 미리 기술해 놓고 필요할때 호출해서 사용하는 코드블록
```
### 함수선언부, 호출부
```
함수선언부, 호출부 : 함수를 사용하려면 함수선언부를 구현하고 사용하고 싶을 때마다 호출부를 이용해서 호출하여 사용한다.
```
```
// 선언부
function 함수명(){
함수내용구현
}
// 호출부
함수명();
```
## Timer
```
Timer(타이머)는 코드의 실행을 일정 시간 지연하거나 주기적으로 반복하는 데 사용된다.
Timer 함수에는 setTimeout 함수와 setInterval 함수 가 있다. 
두 함수는 매개변수로 실행할 함수와 실행될 시간을 받는다.
```
### setTimeout
```
다음 코드는 2초 후에 "안녕하세요!" 메시지를 콘솔에 출력합니다.
```
```javascript
setTimeout(function() {
    console.log("안녕하세요!");
}, 2000);
```
### setInterval
```
다음 코드는 1초마다 현재 시간을 콘솔에 출력합니다.
```
```javascript
setInterval(function() {
    var currentTime = new Date();
    console.log("현재 시간: " + currentTime);
}, 1000); // 1초마다 실행
```
