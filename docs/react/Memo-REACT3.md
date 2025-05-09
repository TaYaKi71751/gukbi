# React
## useState,onChange
### Example
```jsx
import React, { useState } from "react";

function Input() {
  const [text, setText] = useState("");

  const handleChange = (event) => {
    setText(event.target.value);
  };

  return (
    <div>
      <h1>입력 필드 이벤트</h1>
      <input type="text" onChange={handleChange} placeholder="입력하세요" />
      <p>입력한 값: {text}</p>
    </div>
  );
}

function App(){
    return (
    <div>
        <Input />
    </div>
    )
}
```
### Custom Event Example
```jsx
import React, { useState } from "react";

function Input(props) {
  let [text, setText] = useState("");
  if(typeof props?.text != 'undefined'){
      text = props.text;
  }

  const handleChange = typeof props?.onChange == 'function' ? props?.onChange : (event) => {
    setText(event.target.value);
  };

  return (
    <div>
      <h1>입력 필드 이벤트</h1>
      <input type="text" onChange={handleChange} placeholder="입력하세요" />
      <p>입력한 값: {text}</p>
    </div>
  );
}
function App(){
    const [text, setText] = useState("");
    return (
    <div>
        <Input onChange={(event) => {
            setText(event.target.value);
        }} text={text} />
    </div>
    )
}
```
### Usage (Quiz Game)
```jsx
import React, { useState } from "react";


const quizData = [
  { question: "지구는 태양을 돈다.", answer: "O" },
  { question: "1 + 1 = 3 이다.", answer: "X" },
  { question: "코끼리는 날 수 있다.", answer: "X" },
  { question: "물은 얼면 부피가 줄어든다.", answer: "X" },
];


function App() {
  const [currentIndex, setCurrentIndex] = useState(0);
  const [score, setScore] = useState(0);
  const [showResult, setShowResult] = useState(false);


  const handleAnswer = (userAnswer) => {
    if (userAnswer === quizData[currentIndex].answer) {
      setScore(score + 1);
      alert("정답입니다! ✅");
    } else {
      alert("틀렸습니다! ❌");
    }


    if (currentIndex + 1 < quizData.length) {
      setCurrentIndex(currentIndex + 1);
    } else {
      setShowResult(true);
    }
  };


  return (
    <div style={{ textAlign: "center", padding: "20px" }}>
      <h1>OX 퀴즈 게임 🏆</h1>


      {!showResult ? (
        <>
          <h2>{quizData[currentIndex].question}</h2>
          <button
            onClick={() => handleAnswer("O")}
            style={{ marginRight: "10px", padding: "10px 20px", fontSize: "18px" }}
          >
            O
          </button>
          <button
            onClick={() => handleAnswer("X")}
            style={{ padding: "10px 20px", fontSize: "18px" }}
          >
            X
          </button>
        </>
      ) : (
        <div>
          <h2>게임 종료!</h2>
          <p>당신의 점수: {score} / {quizData.length}</p>
          <button onClick={() => { setCurrentIndex(0); setScore(0); setShowResult(false); }}>
            다시 시작 🔄
          </button>
        </div>
      )}
    </div>
  );
}
```
## useState, onSubmit
### Example
```jsx
import React, { useState } from "react";

function App() {
  const [name, setName] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault(); // 기본 폼 제출 동작 방지
    alert(`제출된 이름: ${name}`);
  };

  return (
    <div>
      <h1>폼 제출 이벤트</h1>
      <form onSubmit={handleSubmit}>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} placeholder="이름 입력" />
        <button type="submit">제출</button>
      </form>
    </div>
  );
}
```
## useState, spread operator(...)
### Array Example
```jsx
import { useState } from 'react';
function App(){
    const [students, setStudents] = useState(["Alice","Bob"]);
    setStudents([...students, "Charlie"]);
}
```
### Object Example
```jsx
import { useState } from 'react';
function App(){
    const [students, setStudents] = useState({
        "Alice": 15,
        "Bob": 20
    });
    setStudents({
        ...students,
        "Charlie": 17
    });
}
```
### Example 1
```jsx
import React, { useState } from "react";

function App() {
  const [students, setStudents] = useState([
    { id: 1, name: "Alice", age: 21 },
    { id: 2, name: "Bob", age: 22 },
    { id: 3, name: "Charlie", age: 23 },
  ]);
  const [selectedStudent, setSelectedStudent] = useState(null);
  const [newStudent, setNewStudent] = useState({ name: "", age: "" });


  return (
    <div style={{ padding: "20px" }}>
      <h1>학생 목록</h1>
      <ul>
        {students.map((student) => (
          <li key={student.id}>
            <button onClick={() => setSelectedStudent(student)}>
              {student.name}
            </button>
            age : {student.age}
          </li>
        ))}
      </ul>


      {selectedStudent && (
        <div style={{ marginTop: "20px", border: "1px solid black", padding: "10px" }}>
          <h2>학생 정보</h2>
          <p>이름: {selectedStudent.name}</p>
          <p>나이: {selectedStudent.age}세</p>
        </div>
      )}


      <div style={{ marginTop: "20px" }}>
        <h2>새 학생 추가</h2>
        <input
          type="text"
          placeholder="이름"
          value={newStudent.name}
          onChange={(e) => setNewStudent({ ...newStudent, name: e.target.value })}
        />
        <input
          type="number"
          placeholder="나이"
          value={newStudent.age}
          onChange={(e) => setNewStudent({ ...newStudent, age: e.target.value })}
        />
        <button
          onClick={() => {
            const newId = students.length + 1;
            setStudents([...students, { id: newId, name: newStudent.name, age: newStudent.age }]);
            setNewStudent({ name: "", age: "" });
          }}>
          추가
        </button>
      </div>
    </div>
  );
}
```
### Example 2
#### [App.css](https://github.com/TaYaKi71751/react-01/blob/c75b52e3f1c970ea514543868d18f0e43b036464/src/App.css)
#### [App.js](https://github.com/TaYaKi71751/react-01/blob/c75b52e3f1c970ea514543868d18f0e43b036464/src/App.js)
