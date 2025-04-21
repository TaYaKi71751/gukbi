# JavaScript
## [classList](https://developer.mozilla.org/ko/docs/Web/API/Element/classList)
### [Example](https://tayaki71751.github.io/gukbi/javascript/javascript12.html)
## scope
```
var, let, const, 변수명만으로 변수선언
```
|변수선언 방법|스코프|
|-|-|
|var|함수스코프 형태의 변수 선언|
|let|블록스코프 형태의 변수 선언|
|const|블록스코프 형태의 상수 선언|
|변수명만으로선언|전역변수선언|
## [Slider Example](https://tayaki71751.github.io/gukbi/javascript/javascript13.html)
## [Chart](https://developers.google.com/chart)
### [Chart Example](https://tayaki71751.github.io/gukbi/javascript/javascript14.html)
## 정규식
```
// 정규식 표현 예시
/문자열패턴기술/추가정보
여기서 추가정보는 조합하여 사용할 수 있으며, 주로 다음과 같은 옵션이 사용됩니다:
i (insensitive): 대소문자를 구분하지 않고 검색
g (global) : 전체에서 여러 개의 일치하는 문자열 찾기
m (match): 줄당 시작하는 문자열이 같을 경우
```
### Input Usage
```html
<form>
 <input type="text" placeholder="4~10자리 입력" pattern="[A-Za-z0-9]{4,10}" maxlength="10" required>
 <button type="submit">확인</button>
</form>
```
### Replace Usage
```javascript
var str="visit Human ";
var result = str.replace(/human/i,"Microsoft");//6
console.log(str);//visit Human
console.log(result);//visit Microsoft
```
### Email Pattern
```javascript
var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //2. 이메일 정규식
```
### Phone Number Pattern
```javascript
var regExp = /^\d{3}-\d{3,4}-\d{4}$/; //3. 핸드폰번호 정규식
```
### Test Usage
```javascript
regExp.test(str)
```
## Event
### onsubmit Usage
```javascript
const forms = document.querySelectorAll('form');
forms.forEach((form) => {
    form.onsubmit = (event) => {
        event.preventDefault(); // 기존 폼 전송 막기
        form.action = 'submit_url';
        form.method = 'POST';

        form.submit();
    }
})
```
### [onkeypress](https://developer.mozilla.org/en-US/docs/Web/API/Element/keypress_event) Usage
#### [Example](https://tayaki71751.github.io/gukbi/javascript/javascript15.html)
```html
<html lang="en">

<head>
    <script>
        var map = [
            [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
            [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 2],
            [1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1],
            [1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1],
            [1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1],
            [1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1],
            [1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1],
            [1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1],
            [1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1],
            [1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1],
            [1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1],
            [1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1],
            [1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1],
            [1, 3, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1],
            [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        ];
        function madeTable(y, x) {
            var str = "";
            str += "<table border=1>";
            for (var i = 0; i < y; i++) {
                str += "<tr>";
                for (var j = 0; j < x; j++) {
                    str += `<td id=y${i}x${j} width=25 height=25>`;
                    str += "</td>";
                }
                str += "</tr>";
            }
            str += "</table>";
            return str;
        }
        function drawArray(arr) {
            var y = arr.length;
            var x = arr[0].length;
            for (var i = 0; i < y; i++) {
                for (var j = 0; j < x; j++) {
                    //str+=`<td id=y${i}x${j}>`;
                    switch (arr[i][j]) {
                        case 1:
                            document.getElementById("y" + i + "x" + j).setAttribute("bgcolor", "red");
                            break;
                        case 2:
                            document.getElementById("y" + i + "x" + j).setAttribute("bgcolor", "yellow");
                            break;
                        case 3:
                            document.getElementById("y" + i + "x" + j).innerHTML = "<img src = 'img/k.jpg' width = 20 height = 20 > ";
                            break;
                    }
                }
            }
        }
        function isMove(y, x) {
            //이동 가능하면 true , false
            if (map[y][x] == 1) {
                return false;//이동 불가하면 false
            } else {
                return true;//이동 가능하면 true
            }
        }
        function replayFunction() {
            document.getElementById(`y${unitY}x${unitX}`).innerHTML = "";
            unitX = replayX.shift();
            unitY = replayY.shift();
            document.getElementById(`y${unitY}x${unitX}`).innerHTML
                = "<img src='img/k.jpg' width=20 height=20>";
            if (replayX.length == 0) {
                clearInterval(replayTimer); //타이머 종료
                alert("replay종료"); //최단경로
            }
            //얕은 복사
            // var a=[1,2,3];
            // var b=a;
            // b[1]=100;
            // console.log(a);
            // console.log(b);
            // //깊은 복사
            // var a=[1,2,3];
            // var b=a.slice();
            // b[1]=100;
            // console.log(a);
            // console.log(b);
        }
        var replayTimer;
        var unitY = 13;
        var unitX = 1;
        var endY = 1;
        var endX = 14;
        var replayX = [];
        var replayY = [];
        window.onload = function () {
            //replay배열에 유닛의 시작위치 저장
            replayX.push(unitX);
            replayY.push(unitY);
            //테이블 만들기
            document.body.innerHTML = madeTable(map.length, map[0].length);
            //테이블 칠하기
            drawArray(map);
            //키보드 이벤트 처리
            document.body.onkeypress = function () {
                //alert(event.keyCode);
                //up 56 right 54 left 52 down 50
                //이동하려면 현재위치에 unit를 지운다.
                //이동할 위치를 계산한다. 위로이동하려면 y=y-1
                //이동할 위치에 unit를 그린다.
                //switch값으로 4개중 하나를 확인해서 이동시킨다.
                switch (event.keyCode) {
                    case 56://up
                        if (isMove(unitY - 1, unitX)) {
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML = "";
                            unitY = unitY - 1;
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML =
                                "<img src='img/k.jpg' width=20 height=20>";
                        }
                        break;
                    case 54://right
                        if (isMove(unitY, unitX + 1)) {
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML = "";
                            unitX = unitX + 1;
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML =
                                "<img src='img/k.jpg' width=20 height=20>";
                        }
                        break;
                    case 52://left
                        if (isMove(unitY, unitX - 1)) {
                            120
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML = "";
                            unitX = unitX - 1;
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML =
                                "<img src='img/k.jpg' width=20 height=20>";
                        }
                        break;
                    case 50://down
                        if (isMove(unitY + 1, unitX)) {
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML = "";
                            unitY = unitY + 1;
                            document.getElementById(`y${unitY}x${unitX}`).innerHTML =
                                "<img src='img/k.jpg' width=20 height=20>";
                        }
                        break;
                }
                replayX.push(unitX);
                replayY.push(unitY);
                // var replay=[];
                // replayT={};
                // replayT.x=unitX;
                // replayT.y=unitY;
                // replay.unshift(replayT);
                //게임 종료 조건
                if (unitX == endX && unitY == endY) {
                    alert("게임종료");
                    console.log(replayX);
                    replayTimer = setInterval(replayFunction, 500);
                }
            }
        }
    </script>
</head>

<body>
</body>

</html>
```
