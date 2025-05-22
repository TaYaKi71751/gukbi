import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import DayList from './components/DayList';
import Day from './components/Day';
import EmptyPage from './components/EmptyPage';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import CreateWord from './components/CreateWord';
import CreateDay from './components/CreateDay';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <Header/>  
      <Routes>
        <Route path="/" element={<DayList/>}/>
        <Route path="/day/:day" element={<Day></Day>}/>
        <Route path="/create_word" element={<CreateWord/>}/>
        <Route path="/create_day" element={<CreateDay/>}/>
        <Route path="*" element={<EmptyPage></EmptyPage>}/>
      </Routes>    
    </div>
    </BrowserRouter>
  );
}
export default App;
