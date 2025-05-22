import logo from './logo.svg';
import './App.css';
import utils from './utils';
import {helper1,helper2} from './utils';
import Button from './Button';
import Counter from './Counter';

function Greeting(){
  return <h1>hello,world</h1>
}
function GreetingProp(props){
  return <h1>{props.name}</h1>
}
// 문제1)
// <GreetingProps name= “Tom” age=15/>일때 “Tom의 나이는 15입니다.” 가 출력 되도록 컴포넌트를 만들어 보자.

function App() {
  const name='john';
  const element=<h1>Hello,{name}!</h1>
  return (
    <div className="App">
      Hello React!<br/>
      <Button/><Button/><Button/><br></br>
      <Counter/><br/>
      {element}{element}<br></br>
      <Greeting/><Greeting/>
      <GreetingProp name="Tom"/><GreetingProp name="Alice"/>
      
    </div>
  );
}

export default App;
