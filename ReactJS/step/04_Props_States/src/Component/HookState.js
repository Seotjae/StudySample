import React, { useState } from "react";

export default function HookState(){

    //count 에 100을 할당, 고치고 싶을 경우 setCount 활용
    const[count,setCount]= useState(100);

    const updateCount = () => {
        console.log('down count');
        setCount(count-1);
    }

    return(
        <div style={{margin:10}}>
            <button onClick={updateCount}>down count : {count}</button>
            {/* 
                매개변수가 있는 경우와 같이 괄호가 필요할 경우는 아래와 같이 익명함수로 한번 더 감싸줘야 한다.
                <button onClick={()=>{updateCount()}}>down count</button>
            */}
        </div>
    );
}