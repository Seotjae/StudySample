import './App.css';
import { Component, Fragment } from 'react';
import ReefClass from './Component/ReefClass';
import RefFunction from './Component/RefFunction';
import RefVar from './Component/RefVar';

const App = () => ( 
  <Fragment>
    <ReefClass/>
    <RefFunction/>
    <RefVar/>
  </Fragment>
);
  

export default App; //App 이라는 이름으로 공개하겠다. (public 개념)
