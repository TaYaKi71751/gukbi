# React
## 요점
- JSX에서 태그를 사용할때 꼭 닫아 주어야 한다.
- JSX에서 속성은 HTML과 비슷하게 작성되지만 class의 경우 className처럼 JavaScript의 관습에 따라 작성된다.
- 변수의 경우 중괄호`{}`를 통해 접근 할 수 있다.
```javascript
function GreetingProps(props){
    return (
    <h1>Hello, {props.name}({props.age})</h1>
    );
}
function App(){
    return (
    <GreetingProps name="John" age="15" />
    );
}
```

## Export
### [Export Example](https://github.com/TaYaKi71751/react-01/blob/ddc18bb6fad5c1c53904b7cf3117ee094aba3dbd/src/App.js)
## [useState](https://react.dev/reference/react/useState)
### [useState Example](https://github.com/TaYaKi71751/react-01/blob/822a644c467a786d7b59ceb2789b3287eef7914a/src/Counter.jsx)
