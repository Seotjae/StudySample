import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App'; //같은 폴더의 App.js 를 가져와 App 이라는 태그로 쓰겠다.
import reportWebVitals from './reportWebVitals';

//render 함수는 무언가를 그리는 함수
ReactDOM.render(
  <React.StrictMode>
    <App />   {/* App 태그는 App.js 에서 그린 내용을 표현해주는 태그 */}
  </React.StrictMode>,
  document.getElementById('root') //어디에 그릴 것인가? (public/index.html 의 id=root)
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
