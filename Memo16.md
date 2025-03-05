# HTML
## 위치 이동
```html
<a id="식별자">이동후 위치</a>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a href="#식별자">이동전 위치</a>
```
```html
<a id="top1">top1</a>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a id="top2">top2</a>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a href="#top1">top1 이동</a>
<a href="#top2">top2 이동</a>
```
## h1,h2,...,h6 태그
```html
<h1>Daum 영어사전</h1>
<h2>서비스 메뉴</h2>
<h2>검색</h2>
<h2>관련 서비스</h2>
<h2>어학사전 본문</h2>
<h3>검색결과</h3>
<h4>단어, 숙어</h4>
<h4>예문</h4>
<h4>번역</h4>
<h3>많은 사람이 찾은 단어</h3>
<h3>내가 찾은 단어</h3>
<h2>서비스 이용정보</h2>
```
## ul,ol,dl
```html
<ul>
 <li>
  <ol>
   <li>
   </li>
  </ol>
 </li>
 <li>
  <dl>
   <dt>
   </dt>
   <dd>
   </dd>
  </dl>
 </li>
</ul>
```
## table
```
<!-- 표 선 없음 -->
<table>
</table>
<!-- 표 선 있음 -->
<table border="1">
 <tr>
  <th>1</th>
  <th>2</th>
  <th>3</th>
  <th>4</th>
 </tr>
 <tr>
  <td>5</td>
  <td>6</td>
  <td>7</td>
  <td>8</td>
 </tr>
 <tr>
  <td>9</td>
  <td>10</td>
  <td>11</td>
  <td>12</td>
 </tr>
</table>
<!-- 표 선 두꺼움 -->
<table border="2">
</table>
```
```html
<!-- 이름 나이 표 -->
<table border="1">
 <tr>
  <th>이름</th>
  <th>나이</th>
 </tr>
 <tr>
  <td>홍길동</td>
  <td>21</td>
 </tr>
 <tr>
  <td>홍길남</td>
  <td>18</td>
 </tr>
 <tr>
  <td>홍길수</td>
  <td>33</td>
 </tr>
<table>
```
```html
<!-- 시간표 -->
<table border="2">
 <tr>
  <th>월</th>
  <th>화</th>
  <th>수</th>
  <th>목</th>
  <th>금</th>
 </tr>
 <tr>
  <td>미술</td>
  <td>국어</td>
  <td>화학</td>
  <td>영어</td>
  <td>기술</td>
 </tr>
 <tr>
  <td>사회</td>
  <td>체육</td>
  <td>도덕</td>
  <td>수학</td>
  <td>영어</td>
 </tr>
</table>
```
```html
<!-- 이미지 표 -->
<table>
 <tr>
  <th>
   <img src="img/돌탑이미지/1.jpg">
  </th>
  <th>
   <img src="img/돌탑이미지/2.jpg">
  </th>
 </tr>
 <tr>
  <td>
   <img src="img/돌탑이미지/3.jpg">
  </td>
  <td>
   <img src="img/돌탑이미지/4.jpg">
  </td>
 </tr>
 <tr>
  <td>
   <img src="img/돌탑이미지/3.jpg">
  </td>
  <td>
   <img src="img/돌탑이미지/4.jpg">
  </td>
 </tr>
</table>
```
```javascript
// 찾을 경우 반드시 table > thead > tr, table > tbody > tr, table > tfoot > tr
document.querySelectorAll("table > thead > tr, table > tbody > tr, table > tfoot > tr");
// tbody 가 없을경우 tbody가 자동으로 들어감
```
```
<table / tr / td 태그 공통 속성>
align="정렬 방식" (left/right/center 등)
width="숫자" (가로길이px 또는 %로 입력)
height="숫자" (세로길이px 또는 %로 입력)
background="파일경로" (배경 이미지 설정)
bgcolor="색상" (배경 색 설정)

<table 태그 속성>
border="숫자" (테이블 테두리 두께 지정)
cellspadding="숫자" (셀 내부 여백 지정)
cellspacing="숫자" (셀 사이의 간격을 지정)
```
```html
<table border="1">
 <tr>
  <td width="100px" height="100px" align="left">1</td>
  <td height="100px" align="left">2</td>
  <td height="100px" align="left">3</td>
  <td height="100px" align="left">4</td>
 </tr>
 <tr bgcolor="yellow">
  <td align="left">5</td>
  <td bgcolor="red" align="left">6</td>
  <td align="left">7</td>
  <td align="left">8</td>
 </tr>
 <tr>
  <td align="left">9</td>
  <td align="left">10</td>
  <td align="left">11</td>
  <td align="left">12</td>
 </tr>
</table>
```
|속성|설명|
|-|-|
|rowspan|테이블의 td를 세로로 합칠때 사용한다.|
|colspan|테이블의 td를 가로로 합칠때 사용한다.|
```html
<table border="1">
 <tr>
  <th>1</th>
  <th>2</th>
  <th>3</th>
  <th>4</th>
 </tr>
 <tr>
  <td rowspan="2">5</td>
  <td colspan="3">6</td>
 </tr>
 <tr>
  <td>10</td>
  <td>11</td>
  <td>12</td>
 </tr>
</table>
```
