# CSS
## 기본 선택자 확인하기
|선택자 이름|선택자 형태|설명|
|-|-|-|
|[전체 선택자](https://developer.mozilla.org/ko/docs/Web/CSS/Universal_selectors)|*|모든 태그에 스타일을 적용한다.<br>`* {속성:값;}`|
|태그 선택자([유형 선택자](https://developer.mozilla.org/ko/docs/Web/CSS/Type_selectors))|태그|기술한 태그에 스타일을 적용한다.<br>`h1 {속성:값;}`|
|[아이디선택자](https://developer.mozilla.org/ko/docs/Web/CSS/ID_selectors)|#아이디|특정 아이디가 적용된 태그에 스타일을 적용한다.<br>`#id1 {속성:값;}`|
|[클래스선택자](https://developer.mozilla.org/ko/docs/Web/CSS/Class_selectors)|.클래스|특정 클래스가 적용된 태그에 스타일을 적용한다.<br>`.class1 {속성:값;}`|
|태그 중 클래스|태그.클래스|선택된 태그 중 클래스를 가지고 있는 태그만 선택<br>`div.class1 {속성:값;}`|
|다중 태그([선택자 목록](https://developer.mozilla.org/ko/docs/Web/CSS/Selector_list))|태그,태그|여러 다른 태그에 스타일을 적용하고 싶을 때 사용<br>`p,h1 {속성:값;}`|
## 속성 선택자([특성 선택자](https://developer.mozilla.org/ko/docs/Web/CSS/Attribute_selectors)) 확인하기
|선택자 형태|설명|
|-|-|
|선택자[속성]|선택자에 의해서 선택된 태그중 해당 속성이 있는 태그만 선택 된다.<br>`a[href]`,`img[title]`,`*[class]`|
|선택자[속성=값]|선택된 태그 중 해당 속성이 있고 그 속성의 정의된 값과 동일한 값의 태그만 선택된다.|
|선택자[속성~="값"]|선택된 태그 중 속성의 값과 동일하거나 스페이스로 구분된 값 중 동일한 값이 있을 때 선택된다. <br>`img[title~="bb]` 일때 <br>`"aa bb cc"(O)`<br>`"bb"(O)`<br>`bbc(X)`<br>`"bb-cc"(X)`<br>`"abb bbb cc"(X)`|
|선택자[속성\|="값"]|선택된 태그 중 속성의 값과 동일 하거나 해당 값과 동일하게 시작하면서 다음에 `-`이 오는 경우 선택된다.<br>`img[title\|="aa"]` 일때 <br>`"aa"(O)`<br>`"aabb"(X)`<br>`"bbaa"(X)`<br>`"bb aa"(X)`<br>`"aa-bb"(O)`<br>`"bb-aa"(X)`|
|선택자[속성^="값"]|선택된 태그 중 속성의 값으로 시작하면 된다.<br>`img[title^="aa"]` 일때 <br>`"aa"(O)`<br>`"aabb"(O)`<br>`"bbaa"(X)`<br>`"bb aa"(O)`<br>`"aa-bb(X)`<br>`"bb-aa"(X)`|
|선택자[속성$="값"]|선택된 태그 중 속성의 값의 마지막 부분과 같을 때 선택된다.<br>`img[title$="aa"]` 일때 <br>`"aa"(O)`<br>`"aabb"(X)`<br>`"bbaa"(O)`<br>`"bb aa"(O)`<br>`"aa-bb"(X)`<br>`"bb-aa"(O)`함
|선택자[속성*="값"]|선택된 태그 중 속성의 값에 포함 되어 있을 때 선택된다.<br>`img[title*="aa"]` 일때 <br>`"aa"(O)`<br>`"aabb"(O)`<br>`"bbaa"(O)`<br>`"bb aa"(O)`<br>`"aa-bb"(O)`<br>`"bb-aa"(O)`<br>`"baac"(O)`|
