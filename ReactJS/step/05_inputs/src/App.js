import './App.css';
import { Component, Fragment } from 'react';
import Input from './Component/input';
import Inputs from './Component/inputs';

const App = () => ( 
  <Fragment>
    {/* 
    props : 하위 컴포넌트로 값을 보낸다. 
    */}
    <Input/>
    <br/>
    <hr/>
    <Inputs/>
  </Fragment>
);
  

export default App; //App 이라는 이름으로 공개하겠다. (public 개념)
