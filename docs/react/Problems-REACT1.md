# React
1. `<GreetingProps name="Tom" age=15 />`일때 `Tom의 나이는 15입니다.` 가 출력되도록 컴포넌트를 만들어 보자.
```javascript
function GreetingProps(props){
    return (
    <p>{props.name}의 나이는 {props.age}입니다.
    );
}
```
2. `+`,`-`,`리셋`,`100` 버튼이 있는 카운터를 React 를 사용하여 만들어 보자.(`+`를 누르면 카운터가 1 증가하고 `-`를 누르면 1 감소한다. `리셋`을 누르면 카운터가 0으로 설정된다. `100`버튼을 누르면 카운터가 100으로 설정된다. 초기 카운터 값은 0으로 한다.)
```jsx
import { useState } from 'react';
function App(){
    const [count,setCount] = useState(0);
    const increment = async () => {
        setCount(count + 1);
    };
    const decrement = async () => {
        setCount(count - 1);
    };
    const reset = async () => {
        setCount(0);
    }
    const hundred = async () => {
        setCount(100);
    }
    return (
    <div className="container">
        <div className="counter">{count}</div>
        <div className="buttons">
            <button onClick={increment}>Increment</button>
            <button onClick={decrement}>Decrement</button>
            <button onClick={reset}>Reset</button>
            <button onClick={hundred}>100</button>
        </div>
    </div>
    );
}
```
