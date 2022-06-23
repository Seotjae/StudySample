import React, { useEffect, useState } from 'react';

const FuncComp = ({cnt}) => {

    const [number,setNum] = useState(parseInt(cnt));

    //1. componentDidMount - 화면에 컴포넌트가 그려졌을 때
    useEffect(()=>{
        console.log('컴포넌트가 화면에 나타났을 때 - function');
    });

    /*2. shouldComponentUpdate - 변화가 일어날 경우**
    useEffect(()=>{
        console.log('특정 state 에 변화가 일어날 경우 동작 - function');
        console.log('number : ',number);
    },[number]); //[] 안에는 감지할 state 입력 (입력안하면 어떠한 state 변화에도 동작 X)
    */

    //3. componentWillUnmont - 컴포넌트 수명이 다 되어 사라질 때 호출
    useEffect(function() {
        console.log('특정 state 에 변화가 일어날 경우 동작 - function');
        console.log('number : ',number);
        return () =>{
            //0. 이전 컴포넌트 지워질 때 호출...
            console.log('이전 컴포넌트가 사라질 때 실행된다.');
        }
    },[number]);



    const handleIncrease = () => {
        setNum(number+1);
    }

    const handleDecrease = () => {
        setNum(number-1);
    }

    
    return (
            <div style={{margin:30}}>
               <h1>Counter</h1>
               <div>Value : {number}</div>
               <button onClick={handleIncrease}> + </button>
               <button onClick={handleDecrease}> - </button>
            </div>
    );
};

export default FuncComp;