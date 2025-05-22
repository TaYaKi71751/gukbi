import React, { useState, useEffect } from 'react';




// TitleChanger 컴포넌트
const TitleChanger = () => {
    const [title, setTitle] = useState('Hello World!');
    const [clickCount, setClickCount] = useState(0);


    useEffect(() => {
        document.title = title; // 브라우저의 탭 제목을 변경합니다.
        console.log('컴포넌트가 렌더링되었습니다!');
        return () => {
            console.log('컴포넌트가 제거됩니다.');
        };
    }, [title]);


    const handleClick = () => {
        setClickCount(clickCount + 1);
        setTitle(`Hello World! (${clickCount + 1})`); // 클릭 수에 따라 제목 변경
    };


    return (
        <div>
            <p>title: {title}</p>
            <p>Button clicked: {clickCount} times</p>
            <button onClick={handleClick}>Change Title</button>
        </div>
    );
};


// App 컴포넌트
const App = () => {
    return (
        <div>
            <h1>Welcome to Title Changer App!</h1>
            <TitleChanger />  {/* TitleChanger 컴포넌트 포함 */}
        </div>
    );
};


export default App;