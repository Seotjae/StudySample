import React from 'react';
import BlogList from './Component/BlogList';
import NumberList from './Component/NumberList';

const App = () => {

  const number = [1,2,3,4,5];
  const posts = [
    {id:1,title:'React.js 시작', content:'리액트란 무엇인가?'},
    {id:2,title:'React.js 설치', content:'리액트 설치부터 실행까지'},
    {id:3,title:'React.js 개념', content:'리액트의 컨셉'},
    {id:4,title:'React.js 주요개념', content:'props,state,component'}
  ];

  return (
    <div>
      <NumberList numbers={number}/>
      <BlogList posts={posts}/>
    </div>
  );
};

export default App;