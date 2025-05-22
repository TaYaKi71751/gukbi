import './App.css';
import './styles.css';

function App2() {
  return <div className="container">Hello, World!</div>;
}
function App() {
  return <div>
    <div className="container">Hello, World!</div>
    <App2/>
    </div>;
}
export default App;

