# CSS
## viewport
```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 이 라인은 모바일 기기에서 페이지가 화면 너비에 맞게 비율100%로 표시되도록 설정합니다. -->
```
## 반응형 웹
```html
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .example {
            padding: 20px;
            color: white;
        }

        /* 초소형 기기 ( 스마트폰, 600px 이하 ) */
        @media only screen and (max-width: 600px) {
            .example {
                background: red;
            }
        }

        /* 소형 기기 ( 태블릿 세로 모드 및 대형 스마트폰, 600px 이상 ) */
        @media only screen and (min-width: 600px) {
            .example {
                background: green;
            }
        }

        /* 중형 기기 ( 태블릿 가로 모드, 768px 이상 ) */
        @media only screen and (min-width: 768px) {
            .example {
                background: blue;
            }
        }

        /* 대형 기기 ( 노트북/ 데스크탑, 992px 이상 ) */
        @media only screen and (min-width: 992px) {
            .example {
                background: orange;
            }
        }

        /* 초대형 기기 ( 큰 노트북 및 대형 데스크탑, 1200px 이상 ) */
        @media only screen and (min-width: 1200px) {
            .example {
                background: pink;
            }
        }
    </style>
</head>

<body>
    <h2>일반적인 미디어 쿼리 브레이크포인트</h2>
    <p class="example">브라우저 창 크기를 조절하여 이 문단의 배경색이 다른 화면
        크기에서 어떻게 변경되는지 확인하세요.</p>
</body>

</html>
```
