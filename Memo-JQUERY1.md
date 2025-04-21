# jQuery
## Toggle
### [Toggle Example](https://tayaki71751.github.io/gukbi/jquery/jquery01.html)
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
### [Selector Example](https://tayaki71751.github.io/gukbi/jquery/jquery02.html)
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
## Animation
```javascript
$("#fadeInButton").click(function() {});
/*
이 코드는 "Fade In" 버튼을 클릭했을 때 
콜백 함수에서는 $("#element").fadeIn(1000);으로 선택한 요소(#element)를 
1초 동안 서서히 나타나게 하는 fadeIn 애니메이션을 실행합니다.
*/
$("#fadeOutButton").click(function() {});
/*
이 코드는 "Fade Out" 버튼을 클릭했을 때 
콜백 함수에서는 $("#element").fadeOut(1000);으로 선택한 요소(#element)를 
1초 동안 서서히 사라지게 하는 fadeOut 애니메이션을 실행합니다.
*/
$("#slideInButton").click(function() {});
/*
이 코드는 "Slide In" 버튼을 클릭했을 때 
콜백 함수에서는 $("#element").slideDown(1000);으로 선택한 요소(#element)를 
1초 동안 슬라이딩으로 나타나게 하는 slideDown 애니메이션을 실행합니다.
*/
$("#slideOutButton").click(function() {});
/*
이 코드는 "Slide Out" 버튼을 클릭했을 때 
콜백 함수에서는 $("#element").slideUp(1000);으로 선택한 요소(#element)를 
1초 동안 슬라이딩으로 사라지게 하는 slideUp 애니메이션을 실행합니다.
*/
$("#toggleButton").click(function() {});
/*
이 코드는 "Toggle" 버튼을 클릭했을 때 
콜백 함수에서는 $("#element").fadeToggle(1000);으로 선택한 요소(#element)를 
1초 동안 서서히 나타나거나 사라지게 하는 fadeToggle 애니메이션을 실행합니다. 
이것은 토글 형태의 애니메이션이 된다.
*/
$("#customAnimateButton").click(function() {});
/*
이 코드는 "Custom Animate" 버튼을 클릭했을 때 
콜백 함수에서는 $("#element").animate({}, 1000);으로 선택한 요소(#element)에 
대한 사용자 지정 애니메이션을 실행합니다. 
첫번째 매개변수는 변경정보를 json으로 넘겨주고, 
두번째 매개변수로는 변경 시간을 설정 한다. 
이 예제에서는 너비, 투명도, 좌우 여백을 변경하도록 설정되어 있으며, 1초 동안 실행됩니다.
*/
```
## HTML 조작
### [attr](https://api.jquery.com/attr/)
```javascript
$("#myLink").attr("href", (i, origValue) => {
    return origValue + "/newpath";
});
```
### remove
```javascript
// 선택한 요소와 하위 요소를 모두 제거 #myElement도 제거 된다.
$("#myElement").remove();
```
### empty
```javascript
// 선택한 요소 내의 모든 자식 요소를 제거 #myElement은 제거 되지 않는다.
$("#myElement").empty();
```
### append(), prepend()
```javascript
$("body").append(txt1, txt2, txt3); // 새로운 요소들을 문서에 추가
$("#container").prepend(newElement); // 부모 요소에 자식 요소 상단에 추가
var newElement = $("<p>New paragraph.</p>");
$("#container p:first").after(newElement); // 선택한 요소 뒤에 형제 요소로 추가
$("#container p:first").before(newElement); // 선택한 요소 앞에 형제 요소로 추가
```
### children(), find()
```
children() 메서드는 선택한 요소의 직계 자식 요소를 선택합니다. 이것은 요소의 바로 아래 단계의 자식들만 선택합니다.
find() 메서드는 선택한 요소 내의 모든 하위 요소를 선택합니다. 이것은 직계 자식 뿐만 아니라 모든 자손 요소를 선택합니다.
간단히 말하면, children()는 한 단계 아래의 자식을 선택하고, 
find()는 모든 하위 요소를 선택합니다.
```
### siblings(), next(), nextAll(), nextUntil(), prev() prevAll(), prevUntil()
```
siblings(): 선택한 요소의 형제 요소를 모두 선택합니다. 선택한 요소와 동일한 부모를 공유하는 다른 형제 요소를 모두 선택합니다.
next(): 선택한 요소의 다음 형제 요소를 선택합니다. 현재 요소의 다음에 위치한 형제 요소를 선택합니다.
nextAll(): 선택한 요소의 다음에 있는 모든 형제 요소를 선택합니다. 현재 요소 다음에 위치한 모든 형제 요소를 선택합니다.
nextUntil(): 선택한 요소의 다음에 있는 형제 요소 중에서 지정한 요소까지의 모든 형제 요소를 선택합니다. 현재 요소 다음에 위치한 형제 요소 중에서 특정 요소까지의 모든 형제 요소를 선택합니다.
prev(): 선택한 요소의 이전 형제 요소를 선택합니다. 현재 요소의 바로 앞에 위치한 형제 요소를 선택합니다.
prevAll(): 선택한 요소의 이전에 있는 모든 형제 요소를 선택합니다. 현재 요소 앞에 위치한 모든 형제 요소를 선택합니다.
```
#### [siblings(), next(), nextAll(), nextUntil(), prev() prevAll(), prevUntil() Usage](https://tayaki71751.github.io/gukbi/jquery/jquery05.html)
### first(), last(), eq(), filter(), not()
```
first(): 일치하는 요소 중 첫 번째 요소를 선택합니다. 주로 첫 번째 요소만을 선택하는 데 사용됩니다.
last(): 일치하는 요소 중 마지막 요소를 선택합니다. 주로 마지막 요소를 선택하는 데 사용됩니다.
eq(): 일치하는 요소 중 특정 인덱스의 요소를 선택합니다. 인덱스(0부터 시작)를 제공하여 특정 요소를 선택하는 데 사용됩니다.
filter(): 일치하는 요소 집합을 특정 조건이나 선택자와 일치하는 요소로 필터링합니다. 필터링 조건이나 함수를 제공하여 어떤 요소를 포함시킬지 결정하는 데 사용됩니다.
not(): 일치하는 요소 집합을 특정 조건이나 선택자와 일치하지 않는 요소로 줄입니다. 지정된 필터 조건이나 선택자와 일치하지 않는 모든 요소를 선택하는 데 사용됩니다.
```
#### [first(), last(), eq(), filter(), not() Usage](https://tayaki71751.github.io/gukbi/jqeury/jquery06.html)
## jQuery Project
### [Example 1](https://tayaki71751.github.io/gukbi/jquery/jquery07.html)