# React
## [useNavigate](https://api.reactrouter.com/v7/functions/react_router.useNavigate.html)
```
This returns function to redirect
```
### useNavigate Usage
```jsx
import { useNavigate } from 'react-router-dom';
function App(){
    const navigate = useNavigate();
    return (
        <button onClick={navigate('/main')}>Go to main page</button>
    );
}
```
