import './App.css';
import { Component, Fragment } from 'react';
import ClassComp from './Component/ClassComp';
import FuncComp from './Component/FuncComp';


const App = () => ( 
  <Fragment>
    <ClassComp cnt="1"/>
    <FuncComp cnt="1"/>
  </Fragment>
);
  

export default App; //App 이라는 이름으로 공개하겠다. (public 개념)
