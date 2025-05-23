# React
## [useState](https://react.dev/reference/react/useState)
### `setValue(cb:((value:any) => any):void` Usage
```jsx
import { useState } from 'react';

function App () {
    const [student,setStudent] = useState({});
    setStudent((prev) => ({...prev, name: "Alice" }));
}
```
## [useEffect](https://react.dev/reference/react/useEffect)
### useEffect Example
#### [App.js](https://github.com/TaYaKi71751/react-01/blob/aa9042b0e72e904ef8fef3525b3a9d4971b3b3b8/src/App.js)
#### Timer
```jsx
import React, { useEffect } from 'react';

function TimerComponent() {
  useEffect(() => {
    // Setup logic here
    const interval = setInterval(() => {
      console.log('1초마다 실행됨');
    }, 1000);

    return () => {
      // Cleanup logic runs when component unmounts
      clearInterval(interval);
      console.log('타이머 제거됨');
    };
  }, []);

  return <div>타이머가 실행 중입니다. 콘솔을 확인하세요.</div>;
}
export default TimerComponent;
```
## React Router
### Install
```bash
# NPM
npm install react-router-dom
```
```bash
# PNPM
pnpm install react-router-dom
```
### [Router Example](https://github.com/TaYaKi71751/react-02)
```jsx
import { BrowserRouter, Route, Routes } from 'react-router-dom';
function App(){
    return (
        <BrowserRouter basename={process.env.PUBLIC_URL}> /* This use homepage of package.json as root path, This is required for GitHub Pages */
            <Routes>
                <Route path="/" element={'This is root page'} />
                <Route path="/hello" element={'This is hello'} />
                <Route path="/user/:userId" element={'This is user page of userId, variable as userId'} />
                <Route path="*" element={'This is else page'} />
            </Routes>
        </BrowserRouter>
    )
}
```
