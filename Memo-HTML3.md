# HTML input
## Form
```
form태그는 사용자 입력을 받아 처리하는 태그이다.
form태그 안에 input태그를 기술하고 type속성에 필요한 종류의 사용자 입력을 선택하여 기술해 사용한다.
사용자 입력들은 반드시 form태그 안에 기술하여야 한다.
```
```
다음 html을 확인 해 보자.
```
```html
<form>
 <label for="username">Username</label>
 <input type="text" id="username" name="username" size="20" value="1234">
 <br>
 <label for="password">Password</label>
 <input type="password" id="password" name="password">
 <br>
 <input type="reset" value="리셋">
 <input type="submit" value="전송">
</form>
```
```
label태그의 for 속성은 해당 태그의 content인 문자열 "Username"가 클릭되면 for속성의 값 username과 Username가 동일한 사용자 입력 태그에 입력할 수 있도록 선택 되어 해당 컨트롤이 사용자 입력을 받을 수 있도록 커서가 생긴다.

name속성은 사용자가 입력한 데이터를 받아서 처리하는 페이지에서 식별자로 사용된다.

size속성은 화면에 보여줄 박스의 크기를 표현한다.
들어갈 수 있는 글자 수 만큼의 크기.

value는 reset이나 submit에서는 버튼의 이름으로 사용되는데 다른 입력 태그에서는 사용자가 입력할 값을 미리 입력하는 용도로 사용된다.

reset버튼을 클릭하면 사용자가 입력한 모든 내용이 삭제되어 사용자 입력을 다시 받을 수 있게 된다.

submit버튼을 클릭하면 사용자가 입력한 데이터를 쿼리스트링을 이용하여 다른 페이지로 전송해 준다.

쿼리스트링(queryString)이란? 
사용자가 입력한 데이터가 다른 페이지로 전달 될 경우 만들어지는 데이터를 담은 문자열을 의미한다.

쿼리스트링의 모양은?
다음에 전송할 데이터 이름과 값을 =으로 연결하여 기술한다.
ex)?데이터이름=데이터값 
여기서 데이터이름은 해당 입력 태그의 name속성값에 해당하고 데이터값은 사용자가 해당컨트롤에 입력한 값에 해당한다.
ex)?username=1234

사용자 입력이 여러개이면 '데이터이름=데이터값'과 같은 결과물들을 &로 연결하여 여러개의 사용자 입력 데이터를 전송 할 수 있다.
상위 코드에서 사용자 입력을 둘 다 1234를 입력한 다음 submit버튼을 누르면 쿼리스트링으로 '?username=1234&password=1234' 이 만들어 진다.
```
```
사용자가 입력한 데이터는 submit버튼을 이용해서 사용자 입력을 처리 할 수 있는 페이지로 쿼리스트링을 가지고 이동한다.
사용자 입력은 상위에서 배운 방법을 사용하면 되고, 처리하는 페이지는 html로 할 수 없고 php,asp,jsp같은 서버 프로그램을 사용해야 한다.

다음 코드에서 action과 method속성을 이용해서 사용자 입력을 처리 할 페이지와 전송 방식을 결정 할 수 있다.
```
## Action
```html
<form action="http://www.daum.net" method="get">
    <label for="username">Username</label>
    <input type="text" id="username" name="username" size="20" value="1234">
    <br>
    <label for="password">Password</label>
    <input type="password" id="password" name="password">
    <br>
    <input type="reset" value="Reset">
    <input type="submit" value="Submit">
</form>
```
```
action속성은 사용자가 입력한 데이터를 처리할 주소를 넣으면 되는데,
일단 우리가 서버단 프로그램을 공부하지 않아서 다음 페이지 주소를 넣었다.
날라온 데이터를 처리 하지는 않지만,
다음 사이트를 이동 할 때의 쿼리스트링을 확인을 할 수 있다.

name속성은 사용자가 입력한 데이터를 데이터 처리 페이지에서 식별 할 때 사용한다.

method속성은 전송방법을 기술 할 수 있는데 get과 post방식이 있다.

get방식은 url뒤에 쿼리스트링으로 데이터가 전달되어 눈으로 확인 할 수 있다.
? 뒤에 key = value형태로 & 로 연결해 여러개의 데이터를 전송 할 수 있다.
2048글자 이상의 데이터는 전송 할 수 없어 대용량 전송이 불가능 하다.

post방식은 쿼리스트링 처럼 전송상태를 눈으로 확인 하는 것이 불가능 하여 보안이 필요한 데이터 이용시 사용한다.
대용량 전송이 가능하다.
```
## UserInputMethod
```
다음은 다양한 사용자 입력 방법을 기술한 것이다. 확인 해 보자.
```
|사용자 입력 방법|설명|
|-|-|
|`<label></label>`|여러 컨트롤에 대한 설명을 기술하기 위해 사용|
|`<input type="text">`|사용자로부터 문자를 입력 받을 때 사용|
|`<input type="password">`|타입 text와 동일 하나 화면에 입력한 데이터 대신 *로 보여줌|
|`<input type="time">`|시간 관련 데이터|
|`<input type="date">`|년월일 데이터 입력|
|`<input type="month">`|YYYY-MM 형태의 년월 데이터 입력|
|`<input type="datetime-local">`|년월일시분 데이터 입력|
|`<input type="range">`|범위 데이터|
|`<textarea></textarea>`|사용자 입력을 여러 줄 받을 때 사용|
|`<input type="radio">`|여러개의 데이터 중 한개의 데이터를 선택하는 라디오 박스 사용자 입력을 만들 때 사용|
|`<input type="checkbox">`|여러개의 데이터 중 여러개의 데이터를 선택하는 체크 박스 사용자 입력을 만들 때 사용|
|`<input type="file">`|파일 정보를 얻어 올 수 있는 파일 선택 창 사용|
|`<input type="reset">`|form태그 안에 사용자가 입력한 데이터를 초기화 한다.|
|`<input type="submit">`|form태그 안에 사용자가 입력한 데이터를 전송 한다.|
|`<input type="button">`|사용자에게 버튼 입력을 받을 때 사용<br>실행 내용은 자바스크립트로 onClick을 재정의 하여야 사용 가능|
|`<input type="hidden">`|화면에 보이지 않으나 다른 페이지에 데이터를 보낼 때 데이터를 담는 목적으로 사용한다.|
|`<select></select>`|드롭다운 형태의 사용자 입력태그|
## Radio
```
다음은 라디오 버튼 사용 방법이다. form태그 안에 기술하면 된다.
```
```html
<label>Gender</label>
<!-- 알파벳 순 -->
<input id="female" type="radio" name="gender" value="female">
<label for="female">Female</label>
<input id="male" type="radio" name="gender" value="male">
<label for="male">Male</label>
<input id="rather_not_say" type="radio" name="gender" value="rather_not_say" checked>
<label for="rather_not_say">Rather not say</label>
```
```
라디오 버튼은 여러개의 값 중 하나를 선택 할 때 사용한다.
원하는 값을 클릭하면 여러 개 중 1개가 선택 된다.
name속성이 같아야 같은 그룹이 된다.
value속성은 해당 속성을 클릭 하였을 때 다른 페이지로 전송 될 값에 해당한다.
checked속성은 라디오 박스를 미리 선택하고 싶을 때 사용한다.
상위 내용을 쿼리스트링으로 전송하면 Rather not say가 선택된 상태여서 ?gender=rather_not_say 가 된다.

name속성이 gender로 같아 같은 그룹 인 것을 알 수 있다.
```
# CheckBox
```
다음 체크박스를 확인해 보자.
```
```html
<label>Hobby</label>
<input id="read" type="checkbox" name="hobby" value="read" checked>
<label for="read">Reading</label>
<input id="game" type="checkbox" name="hobby" value="game">
<label for="game">Gaming</label>
<input id="movie" type="checkbox" name="hobby" value="movie" checked>
<label for="movie">Watch Movies</label>
```
```
체크박스는 하나의 그룹에서 여러개의 값을 선택하여 전송 할 때 사용 한다.
위 코드를 확인 해 보고 전송하게 되면 쿼리스트링은 다음과 같다.
```
```
?hobby=read&hobby=movie
```
# Select
```
다음은 셀렉트 박스(select)이다.
속성size는 화면에 3개 보여줄 수 있는 만큼의 크기가 잡힌다.
multiple속성은 여러개의 데이터를 선택하고자 할 때 사용한다.
하나만 선택하고 싶다면 삭제하면 된다.
컨트롤을 누른 상태에서 여러개 마우스 클릭을 하면 여러개 선택이 된다.
쿼리스트링은 다음과 같다.
```
```
?phone=1&phone=3
```
```html
<label>Phone Number</label>
<select name="phone" size="3" multiple>
    <option value="1" selected>SKT</option>
    <option value="2">KT</option>
    <option value="3" selected>LGU+</option>
</select>
```
```
optgroup태그 label속성을 이용하여 원하는 그룹의 타이틀을 만들 수 있다.
```
```html
<select name="phone" size="8" multiple>
    <optgroup label="Carrier">
        <option value="1" selected>SKT</option>
        <option value="2">KT</option>
        <option value="3" selected>LGU+</option>
    </optgroup>
    <optgroup label="Fruit">
        <option value="4" selected>Peach</option>
        <option value="5">Orange</option>
        <option value="6">Apple</option>
    </optgroup>
</select>
```
```
상위 html의 쿼리스트링은 다음과 같다.
```
```
?phone=1&phone=4
```
## Hidden
```
hidden속성을 확인 해 보자.
```
```html
<form>
    <input type="hidden" name="n1" value="h1"/>
    <input type="hidden" name="n2" value="h2"/>
    <input type="submit" value="Submit">
</form>
```
```
hidden속성은 화면에 아무것도 보이지 않지만 다른 페이지에 데이터를 전송하고 싶을 때 사용 한다.
Submit버튼을 누르면 쿼리스트링은 다음과 같다.
```
```
?n1=h1&n2=h2
```
## File
```
file은 file을 선택 할 때 사용 한다.
```
```html
<form>
    <input type="file" name="f1" multiple>
    <input type="submit" value="Submit">
</form>
```
## Button
```
다음은 버튼 태그이다.
Button을 클릭하면 onclick속성에 기술한 자바스크립트가 실행된다.
자바스크립트를 배운 후에는 좀 더 자세히 이해 할 수 있을 것 이다.
지금은 onclick의 속성의 값으로 온 자바스크립트가 `Click` 메시지를 알림 창으로 보여 준다고 생각하면 된다.
```
```html
<button onclick="alert('Click')">Button</button>
```
## TextArea
```
다음은 textarea이다.
여러줄의 문자열을 입력 받을 때 사용한다.
rows와 cols는 입력할 창의 크기를 설정 할 때 사용한다.
cols가 넓이,
rows가 높이에 해당한다.
해당 태그의 값은 value로 접근 할 수 없다.
```
```html
<textarea name="textarea" rows="10" cols="50">Text</textarea>
```
# MultimediaTag
## audio
```
audio태그는 브라우저에서 mp3 같은 소리 관련 파일을 제공한다.
```
```html
<audio src="file.mp3" autoplay controls loop></audio>
```
```
와 같은 방법으로 사용하며 src는 실행파일 controls는 화면에 플레이어 표시 여부 autoplay는 자동 재생 loop는 무한 반복 지정 관련 속성들이다.
브라우저에 따라 적용되지 않는 속성이 존재할 수 있다.
```
## video
```
video태그는 브라우저에서 동영상 파일을 보여줄 때 사용한다.
src는 실행파일 controls는 화면에 플레이어 표시 여부 autoplay는 자동 재생 loop는 무한 반복 지정 width는 너비 height는 높이를 지정하는 속성들이다.
여러개의 source태그중 첫번째 source가 재생되고 해당 소스의 코덱이 없어서 재생이 안되면 다음에 정의된 source태그가 실행 된다.
```
```html
<video with="100" height="50" controls autoplay>
    <source src="file.mp4" type="video/mp4">
    <source src="file.webm" type="video/webm">
    <source src="file.ogg" type="video/ogg">
</video>
```
# div,span
```
div와 span태그는 대표적인 공간 분할 태그이다.
div는 블록 형태의 공간을 분할 할때 사용하고,
span은 인라인 형태의 공간을 분할 할때 사용한다.
인라인 형태의 태그에는 
span,a,img,input,select
등이 있으며
블록형태 태그에는
div,h1,p,ul,form
등이 있다.
```
```
인라인 태그는 글씨 쓰듯 옆으로 배치되고,
블록 태그는 세로로 블록을 쌓는 듯 배치된다.
```
```
span태그 내에서 블럭 태그를 사용하면 문제가 발생 한다는 것을 기억하자.
```
```html
<span>Text1</span>
<span>Text2<img src="img/flower.jpg" width="100" height="100"></span>
<img src="img/flower.jpg" width="100" height="100">
<h3>Block Tag1</h1>
<div>Block Tag2</div>
<p><span>Inline in Block2<img src="img/flower.jpg" width="100" height="100"></span></p>
```
## div
```
웹 브라우저 전체 공간에 대해 분할
블록(block) 형식으로 분할
```
## span
```
웹 브라우저의 일부 영역만 분할
인라인(inline) 형식으로 분할
```
## div와 span 태그로 공간 분할 하기
```html
<h3>div</h3>
<div style="background-color: #FFFF00">First div</div>
<div style="background-color: #00FF00">Second div</div>
<div style="background-color: #FF00FF">Third div</div>
<h3>span</h3>
<span style="background-color: #FFFF00">First span</span>
<span style="background-color: #00FF00">Second span</span>
<span style="background-color: #FF00FF">Third span</span>
```
## div 태그와 span 태그를 조합하여 공간 분할 하기
```html
<h3>div/span</h3>
<div style="height: 70px; background-color: #FFFF00;">머리말 영역</div>
<div style="height: 50px; background-color: #FF00FF;">본문 영역</div>
<span style="background-color: #FF0000;">왼쪽 텍스트 영역</span>
<span style="background-color: #FFFFFF;">가운데 텍스트 영역</span>
<span style="background-color: #0000FF;">오른쪽 텍스트 영역</span>
<div style="height: 40px; background-color: #FFFF00;">꼬리말 영역</div>
```
# SemanticTag
## header
```
문서나 섹션의 맨 위에 있는 제목이나 로고와 같은 정보를 가리킵니다.
```
## nav
```
웹 사이트의 메뉴나 내비게이션 링크를 감싸는 컨테이너로, 사용자가 웹 페이지 내에서 이동 할 수 있는 링크들을 포함합니다.
```
## section
```
문서 내에서 콘텐츠를 그룹화 하는 데 사용 되며, 각 섹션은 서로 다른 주제나 내용을 나타내도록 돕습니다.
```
## article
```
웹 페이지에서 독립적으로 읽을 수 있는 콘텐츠, 예를 들면 뉴스 기사나 블로그 글과 같은 것을 말합니다.
```
## aside
```
주 콘텐츠와는 연관이 적거나 독립적인 정보를 담고 있으며, 사이드바, 광고, 관련 링크를 표시하는 데 사용됩니다.
```
## footer
```
문서나 섹션의 맨 아래에 있는 정보로, 저작권 정보나 연락처 정보와 같은 내용을 제공합니다.
```
# 입력 양식의 주요 속성
## readonly
```
텍스트 상자에 쓰기를 제한하고 오직 읽기만 가능하게 설정
```
## disabled
```
텍스트 상자를 비활성화
```
## autocomplete
```
사용 했던 데이터를 기준으로 입력 중인 텍스트에 자동 완성 기능을 적용할 수 있음
```
## autofocus
```
현재 페이지가 로드 될 때 처음으로 입력하고자 하는 폼을 선택하는 속성
```
## placeholder
```
현재 폼에 입력해야 하는 텍스트를 희미하게 보여주는 속성
```
## required
```
반드시 데이터가 입력되어야 하는 폼을 지정하는 속성
```
## spellcheck
```
입력되는 문장의 오타를 실시간으로 점검
```
```html
<input type="text" pattern="정규식" title="오류 시 표시 될 메시지">
```
## pattern
```
HTML5 정규식을 입력합니다.
브라우저가 이를 기준으로 입력을 유효성 검사합니다.
```
## title
```
유효성 검사가 실패할 경우 표시될 툴팁 메시지 입니다.
```
## required
```
입력값이 필수인지 여부를 지정합니다.
```
## type="text"
```
입력 타입을 지정합니다.
email, url 같은 타입에서도 사용 할 수 있습니다.
```
```html
<input type="text" pattern="\d+" title="숫자만 입력해 주세요" required />
<input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="올바른 이메일 형식을 입력해 주세요" required />
<input type="text" pattern="[a-z0-9]+" title="영문 소문자와 숫자만 입력해 주세요" required />
<input type="password" pattern="(?=.*[a-zA-Z])(?=.*\d).{8,}" title="8자 이상, 문자와 숫자를 포함해야 합니다" required />
```