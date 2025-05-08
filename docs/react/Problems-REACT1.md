# React
1. `<GreetingProps name="Tom" age=15 />`일때 `Tom의 나이는 15입니다.` 가 출력되도록 컴포넌트를 만들어 보자.
```javascript
function GreetingProps(props){
    return (
    <p>{props.name}의 나이는 {props.age}입니다.
    );
}
```
