# CSS
## flexbox
```
CSS Flexbox (Flexible Box Layout)는 요소들을 행(row) 또는 열(column) 방향으로 배치하는 CSS의 레이아웃 시스템입니다. 
Flexbox는 요소들이 크기가 동적으로 변하더라도 유연하게 배치되도록 도와줍니다. 
이를 통해 float나 positioning과 같은 오래된 방법을 사용할 필요 없이 반응형 레이아웃을 쉽게 설계할 수 있습니다.
● Flexbox는 레이아웃을 설계할 때 부모 컨테이너의 크기에 맞춰 자식 요소들을 자동으로 정렬하고 배치합니다.
```
### flexbox 구성 요소
```
Flexbox는 두 가지 주요 요소로 구성됩니다:
● Flex Container (플렉스 컨테이너): Flexbox 레이아웃을 적용할 부모 요소입니다. 
  이 부모 요소에 display: flex;를 설정하면 그 안의 자식 요소들이 Flexbox 레이아웃에 따라 배치됩니다.
● Flex Items (플렉스 아이템): Flex 컨테이너 내부의 자식 요소들입니다. 
  Flex컨테이너 안에 있으면 자동으로 Flex 아이템으로 취급됩니다.
```
### flex-direction
#### flex-direction: row
```
기본값으로, 플렉스 아이템들이 수평(가로)로 배치됩니다.
첫 번째 <div>가 왼쪽에, 두 번째가 중간, 세 번째가 오른쪽에 배치됩니다.
```
#### flex-direction: column
```
아이템들이 수직(세로)로 배치됩니다. 
첫 번째 <div>가 상단, 두 번째가 중간, 세 번째가 하단에 배치됩니다.
```
#### flex-direction: row-reverse
```
아이템들이 수평으로 배치되지만, 순서가 반대로 배치됩니다. 
첫 번째 <div>가 오른쪽에, 두 번째가 중간, 세 번째가 왼쪽에 배치됩니다.
```
#### flex-direction: column-reverse
```
아이템들이 수직으로 배치되지만, 순서가 반대로 배치됩니다. 
첫 번째 <div>가 하단, 두 번째가 중간, 세 번째가 상단에 배치됩니다.
```
### flex-wrap
#### flex-wrap: nowrap
```
모든 아이템이 한 줄에 배치됩니다. 
컨테이너의 너비를 초과할 경우, 아이템들이 축소되어 한 줄로 배치됩니다.
```
#### flex-wrap: wrap
```
아이템들이 한 줄에 다 들어가지 않으면, 두 번째 줄로 넘어가서 배치됩니다. 
남은 공간에 맞게 아이템들이 여러 줄로 배치됩니다.
```
#### flex-wrap: wrap-reverse
```
wrap과 비슷하지만, 아이템들이 반대 순서로 배치됩니다. 
첫 번째 줄은 아래쪽에, 두 번째 줄은 그 위에 배치됩니다.
```
##### 각 속성의 차이
```
● nowrap: 모든 아이템이 한 줄에 배치됩니다.
● wrap: 공간을 넘어갈 경우 여러 줄로 아이템들이 배치됩니다.
● wrap-reverse: wrap과 같지만, 줄의 순서가 반대로 배치됩니다.
```
### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content)
#### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content): center
```
○ 아이템들이 컨테이너의 수평 중앙에 정렬됩니다.
```
#### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content): flex-start
```
○ 아이템들이 컨테이너의 시작점(왼쪽)으로 정렬됩니다.
```
#### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content): flex-end
```
○ 아이템들이 컨테이너의 끝점(오른쪽)으로 정렬됩니다.
```
#### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content): space-around
```
○ 아이템들 사이에 균등한 간격을 배분하되, 양 끝에도 동일한 간격을 제공합니다. 
  따라서 양 끝에도 여백이 있습니다.
```
#### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content): space-between
```
○ 첫 번째 아이템은 왼쪽 끝에, 마지막 아이템은 오른쪽 끝에 배치되고, 나머지 아이템들은 그 사이에 균등한 간격을 두고 배치됩니다.
```
#### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content): space-evenly
```
○ 아이템들 사이에 동일한 간격을 배분합니다. 양 끝도 포함하여 모든 간격이 동일합니다.
```
### [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items)
#### [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items): center
```
아이템들이 컨테이너의 수직 중앙에 정렬됩니다.
```
#### [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items): flex-start
```
아이템들이 컨테이너의 상단에 정렬됩니다.
```
#### [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items): flex-end
```
아이템들이 컨테이너의 하단에 정렬됩니다.
```
#### [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items): stretch
```
아이템들이 컨테이너의 높이에 맞춰 늘어나도록 합니다. 기본값입니다.
```
#### [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items): baseline
```
아이템들의 첫 번째 텍스트 라인이 기준이 되어 정렬됩니다.
```
#### [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items): normal
```
기본값이며, stretch와 비슷하게 동작합니다.
```
### [justify-content](https://developer.mozilla.org/ko/docs/Web/CSS/justify-content), [align-items](https://developer.mozilla.org/ko/docs/Web/CSS/align-items)
```
● center: 아이템들을 중앙에 정렬합니다.
● stretch: 아이템들이 컨테이너의 크기에 맞춰 늘어납니다. (기본값)
● flex-start: 아이템들이 시작 부분에 정렬됩니다.
● flex-end: 아이템들이 끝 부분에 정렬됩니다.
● space-around: 아이템들 사이에 동일한 간격을 배치합니다.
● space-between: 아이템들 사이에 동일한 간격을 배치하고, 첫 번째 아이템과 마지막 아이템은 컨테이너의 양 끝에 배치됩니다.
● space-evenly: 아이템들 사이에 균등한 간격을 배치합니다.
```
### order, flex-grow, flex-shrink, flex-basis, flex, align-self
● [order](https://developer.mozilla.org/ko/docs/Web/CSS/order): Flex 아이템의 순서를 지정합니다. 기본값은 0이며, 값이 작을수록 앞에, 클수록 뒤에 배치됩니다.
<br>
● [flex-grow](https://developer.mozilla.org/ko/docs/Web/CSS/flex-grow): 아이템이 남은 공간을 얼마나 차지할지를 정의합니다. 기본값은 0이며, 1 이상으로 설정하면 여유 공간을 비례적으로 나누어 가집니다.
<br>
● [flex-shrink](https://developer.mozilla.org/ko/docs/Web/CSS/flex-shrink): 아이템이 공간이 부족할 때 얼마나 줄어들지를 정의합니다. 기본값은 1이며, 0으로 설정하면 축소되지 않습니다.
<br>
● [flex-basis](https://developer.mozilla.org/ko/docs/Web/CSS/flex-basis): 아이템의 기본 크기를 설정합니다. 기본값은 auto입니다.
<br>
● [flex](https://developer.mozilla.org/ko/docs/Web/CSS/flex): flex-grow, flex-shrink, flex-basis를 한 번에 설정할 수 있는 속성입니다.
<br>
● [align-self](https://developer.mozilla.org/en-US/docs/Web/CSS/align-self): 개별 아이템의 수직 정렬을 조정합니다. 기본값은 auto로, 부모의 align-items 속성 값을 따릅니다.