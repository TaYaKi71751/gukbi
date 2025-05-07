# JavaScript
## 배열
### 배열 생성
```javascript
var fruits = []; // 빈 배열 생성
var colors = ["빨강", "노랑", "파랑"];// 초기 값을 가진 배열 생성
```
### 배열 요소 접근
```javascript
console.log(colors[0]); // "빨강"
console.log(colors[1]); // "노랑"
```
### 배열 요소 수정
```javascript
colors[1] = "주황";
console.log(colors); // ["빨강", "주황", "파랑"]
```
### 배열 길이 확인
```javascript
console.log(colors.length); // 3
```
### 배열요소 뒤에 추가
```javascript
colors.push("녹색"); // ["빨강", "주황", "파랑", "녹색"]
```
### 배열요소 뒤에 제거
```javascript
var a=colors.pop(); // "녹색" 제거, ["빨강", "주황", "파랑"]
console.log(a);//녹색
```
### 배열에 요소 추가 (앞에서)
```javascript
colors.unshift("보라"); // ["보라", "빨강", "주황", "파랑"]
```
### 앞에서 제거
```
var colors = ["빨강", "주황", "파랑"];
var firstColor = colors.shift(); // firstColor는 "빨강"
console.log(colors); // ["주황", "파랑"] 빨강이 삭제됨
```
## Event
### [mouseover](https://developer.mozilla.org/en-US/docs/Web/API/Element/mouseover_event)
### [mouseout](https://developer.mozilla.org/en-US/docs/Web/API/Element/mouseout_event)
