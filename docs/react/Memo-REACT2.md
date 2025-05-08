# React
## 🎯
- JSX에서 태그를 사용할때 꼭 닫아 주어야 한다.
- JSX에서 속성은 HTML과 비슷하게 작성되지만 class의 경우 className처럼 JavaScript의 관습에 따라 작성된다.
- 변수의 경우 중괄호`{}`를 통해 접근 할 수 있다.
- 여러 요소를 렌더링 할 경우 map함수를 사용 할 수 있다. (React 에서 반복되는 태그를 만들 경우에는 유니크한 값을 갖는 `key` 프로퍼티를 추가하는 것을 강력히 권장한다.)
```jsx
/**
 * map Example
  */
function NumberList(props){
    const {numbers} = props;
    const listItems = numbers.map((number) => 
        <li key="number-list-1-{number}">
            {number}
        </li>
    );
    return (
        <ul>{listItems}</ul>
    );
}
function App(){
    return <NumberList numbers={[1,2,3,4,5]}>;
}
```
```jsx
/**
 * Props Example 1
 */
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
```jsx
/**
 * Props Example 2
 */
function Greeting(props){
    if(props.isLoggedIn){
        return <h1>Welcome back!</h1>;
    } dlse {
        return <h1>Please sign up.</h1>;
    }
}
function App(){
    const userIsLoggedIn = true;
    return (
    <div className="App">
     <Greeting isLoggedIn={userIsLoggedIn}/>
    </div>
    );
}
```

## Export
### [Export Example](https://github.com/TaYaKi71751/react-01/blob/ddc18bb6fad5c1c53904b7cf3117ee094aba3dbd/src/App.js)
## [useState](https://react.dev/reference/react/useState)
### [useState Example](https://github.com/TaYaKi71751/react-01/blob/822a644c467a786d7b59ceb2789b3287eef7914a/src/Counter.jsx)
