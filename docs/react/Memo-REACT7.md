# React
## supabase
### [supabase Example](https://github.com/iamshaunjp/Supabase-Tutorial-for-Beginners/tree/lesson-9)
```bash
npm install @supabase/supabase-js
```
## [useNavigate](https://api.reactrouter.com/v7/functions/react_router.useNavigate.html)
### navigate without create history
```
const navigate = useNavigate();
navigate('/', { replace: true }); // This not creates history
navigate('/'); // This creates history
```
