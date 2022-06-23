import './App.css';
import { Component, Fragment } from 'react';
import PropBtn from './Component/PropBtn';
import StateBtn from './Component/StateBtn';
import HookState from './Component/HookState';

const App = () => ( 
  <Fragment>
    {/* props : 하위 컴포넌트로 값을 보낸다. */}
    <PropBtn name="This is Button"/>
    <StateBtn value="props value"/>
    <HookState/> 
  </Fragment>
);
  

export default App; //App 이라는 이름으로 공개하겠다. (public 개념)
