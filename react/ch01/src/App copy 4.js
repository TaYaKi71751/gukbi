import './App.css';
//1. 버튼 클릭 이벤트 추가하기

function ChildComponent(props) {
  return (
    <div>
	    ChildComponent<br/>
      <button onClick={props.onClick}>클릭하세요</button>
    </div>
  );
}
function App() {
  const handleHello=()=>{
    alert("hello");
  }
  const handleWorld=()=>{
    alert("World");
  }
  return <div>

    <ChildComponent onClick={handleHello}/><br></br>
    <ChildComponent onClick={handleWorld}/>
    <ChildComponent onClick={()=>{
        alert("arrow function")}
      }/>
  </div>;
}
export default App;

// 자식 컴포넌트에 클릭이벤트를 다르게 실행하고 싶을때
