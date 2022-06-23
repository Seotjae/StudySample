import React from 'react';
import { Link, Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import First from './Component/First';
import Home from './Component/Home';
import Second from './Component/Second';
import Topics from './Component/Topics';

//npm install react-route-dom
const App = () => {

  return (
    <div>
      <Router>
        <div>
          {/* Link == a href */}
          <ul>
              <li><Link to="/">Home</Link></li>
              <li><Link to="/first">First</Link></li>
              <li><Link to="/second">Second</Link></li>
              <li><Link to="/topics">Topics</Link></li>
          </ul>
        </div>
        {/* 위의 링크로 전송시 받아줄 녀석 (Route) == controller */}
        <Routes>
          <Route path='/' element={<Home/>}></Route>
          <Route path='/first' element={<First/>}></Route>
          <Route path='/second' element={<Second/>}></Route>
          <Route path='/topics' element={<Topics/>}></Route>
        </Routes>
      </Router>
    </div>
  );
};

export default App;