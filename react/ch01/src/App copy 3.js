import './App.css';
//1. 버튼 클릭 이벤트 추가하기

function ChildComponent() {
  const handleButtonClick = () => {
    alert("ChildComponent Button clicked!"); // 고정된 기능 추가
   };

  return (
    <div>
	    ChildComponent<br/>
      <button onClick={handleButtonClick}>클릭하세요</button>
    </div>
  );
}


function App() {
  const handlerClick=()=>{
    alert("클릭!");
  }
  return <div>
    Hello React!<br></br>
    <button onClick={handlerClick}>클릭</button>
    <ChildComponent/><br></br>
    <ChildComponent/>
  </div>;
}
export default App;

// 자식 컴포넌트에 클릭이벤트를 다르게 실행하고 싶을때
