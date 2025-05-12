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
