# jQuery
## Toggle
### [Toggle Example](./jquery/jquery01.html)
## Selector
### Selector Usage
```javascript
$("*") // :웹 페이지의 모든 HTML 요소를 선택합니다.
$(this) // : 선택된 현재 HTML 요소를 선택합니다.
$("p.intro") // : class 속성이 "intro"인 모든 <p> 요소를 선택합니다.
$("p:first") // : 첫 번째 <p> 요소를 선택합니다.
$("[href]") // : href 속성을 가진 모든 요소를 선택합니다.
$("a[target='_blank']") // : target 속성 값이 "_blank"인 모든 <a> 요소를 선택합니다.
$("a[target!='_blank']") // : target 속성 값이 "_blank"가 아닌 모든 <a> 요소를 선택합니다.
$(":button") // : 모든 <button> 요소와 type 속성이 "button"인 <input> 요소를 선택합니다.
$("tr:even") // : 짝수 번째 테이블 행(<tr>) 요소를 선택합니다.
$("tr:odd") // : 홀수 번째 테이블 행(<tr>) 요소를 선택합니다.
$("tr:nth-child(2n)") // : 짝수 번째 테이블 행(<tr>) 요소를 선택합니다. 
$("tr:nth-child(2n+1)") // : 홀수 번째 테이블 행(<tr>) 요소를 선택합니다.
```
### [Selector Example](./jquery/jquery02.html)
## DOM function
```javascript
var text = $('body').text(); // get innerText
$('body').text('new text'); // set innerText
text = $('input[type="txet"]').val(); // get Value
$('input[type="text"]').val('new text input'); // set Value
$('body').css('color','red');
$('body').css({
    'background-color':'red',
    'color':'black'
});
var html = $('div').html(); // get innerHTML
$('div').html("<p>New Inner Html</p>"); // set innerHTML

$('body').addClass("클래스이름");// 클래스 추가
$('body').removeClass("클래스이름");// 클래스 제거
$('body').toggleClass("클래스이름");// 토글 (추가되어 있으면 제거, 없으면 추가)
```
## Event
### Mouse Event
```
click: 요소를 마우스로 클릭했을 때 발생하는 이벤트
dblclick: 요소를 빠르게 더블 클릭했을 때 발생하는 이벤트
mouseenter: 마우스 커서가 요소 안으로 이동했을 때 발생하는 이벤트
mouseleave: 마우스 커서가 요소에서 빠져나갈 때 발생하는 이벤트
```
```javascript
$(document).ready(function(){
    //클릭 이벤트 처리
    $("#clickMe").click(function(){
        $(this).css("background-color", "yellow");
    });
    //더블 클릭 이벤트 처리
    $("#dblClickMe").dblclick(function(){
        $(this).css("background-color", "green");
    });
    //마우스 진입 이벤트 처리
    $("#enterMe").mouseenter(function(){
        $(this).text("마우스 진입!");
    });
    //마우스 빠져나감 이벤트 처리
    $("#leaveMe").mouseleave(function(){
        $(this).text("마우스 빠져나감!");
    });
});
```
### Keyboard Event
```
keypress: 키보드 키를 눌렀을 때 발생하는 이벤트입니다. 일반적으로 문자 입력을 처리하는 데 사용됩니다.
keydown: 키보드 키를 누르고 있는 동안 계속해서 발생하는 이벤트입니다. 긴 키를 누르고 있을 때 처리를 수행하는 데 사용됩니다.
keyup: 키보드 키를 놓았을 때 발생하는 이벤트입니다. 키를 놓을 때 처리를 수행하는 데 사용됩니다.
```
```javascript
$(document).ready(function(){
    //키 누름 이벤트 처리
    $("#keyPressExample").keypress(function(event){
        //누른 키의 코드를 가져와서 화면에 표시
        var keyCode = event.key;
        $("#keyPressResult").text("키 코드: " + keyCode);
    });
//키 다운 이벤트 처리
    $("#keyDownExample").keydown(function(event){
        //누른 키의 코드를 가져와서 화면에 표시
        var keyCode = event.key;
        $("#keyDownResult").text("키 코드: " + keyCode);
    });
    //키 놓음 이벤트 처리
    $("#keyUpExample").keyup(function(event){
        //놓은 키의 코드를 가져와서 화면에 표시
        var keyCode = event.key;
        $("#keyUpResult").text("키 코드: " + keyCode);
    });
});
```
### Form Event
```
submit: 폼이 제출되었을 때 발생하는 이벤트입니다. 주로 폼 검증 및 서버로 데이터 제출에 사용됩니다.
change: 입력 필드 값이 변경되었을 때 발생하는 이벤트입니다. 주로 입력 값의 변경을 감지하고 처리하기 위해 사용됩니다.
event.preventDefault(): 기본적으로 제공되는 이벤트를 막아 실행되지 않게 한다. 기본적으로 제공되는 이벤트에는 a태그의 페이지이동, form태그의 submit 등이 있다.
```
```javascript
$(document).ready(function(){
    //폼 제출 이벤트 처리
    $("#myForm").submit(function(event){
        event.preventDefault(); //폼 제출 기본 동작을 중지
        alert("폼이 제출되었습니다!");
    });
    //입력 필드 값 변경 이벤트 처리
    $("#nameInput").change(function(){
        var newValue = $(this).val();
        $("#changeResult").text("변경된 값: " + newValue);
    });
});
```
### Document/Window Event
```
load: 문서 또는 웹 페이지가 모두 로드된 후 추가 작업을 수행하는 데 사용됩니다.
resize: 창 크기가 변경됐을 때 발생하는 이벤트입니다.
focus: 주로 입력 필드나 버튼 등의 요소가 선택 되었을때 사용됩니다.
blur: 요소가 포커스를 잃었을 때 발생하는 이벤트입니다.
unload: 문서가 언로드(닫힘)될 때 발생하는 이벤트입니다. 현재 브라우저에서 지원해주지 않는다.
이벤트 이름 함수로 이벤트를 실행하는 것보다는 on 함수를 사용하여 이벤트 등록을 한다.
ex) 다음은 윈도우 객체에 load이베트를 추가하는 예제이다.
.on(이벤트,이벤트 핸들러)
$(window).on("load",()=> {})
```
```javascript
$(document).ready(function(){
    //문서 로드 이벤트 처리
    $(window).on("load", function(){
        // window.onload 이벤트가 끝난 후에 document.ready가 실행되므로 실행 되지 않을 것
        alert("문서 및 모든 콘텐츠가 로드되었습니다.");
    });
    //창 크기 변경 이벤트 처리
    $(window).on("resize", function(){
        var newWidth = $(window).width();
        var newHeight = $(window).height();
        $("#resizeResult").text("w"+newWidth+" h "+ newHeight);
    });
    //포커스 이벤트 처리
    $("#focusInput").focus(function(){
        $(this).css("background-color", "lightblue");
    });
    //포커스 잃음 이벤트 처리
    $("#blurInput").blur(function(){
        $(this).css("background-color", "white");
    });
});
```
