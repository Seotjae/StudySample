import React from "react";

//props 는 상위 컴포넌트로부터 받으면, 스스로 변경이 불가능하다.
const PropBtn = ({name}) =>{
    const sendMsg = (name) => {
        alert(name);
    }

    return(
        <div style={{margin:10}}>
            {/* 함수가 바로 실행되는 것을 방지하려면 함수로 한번 더 감싸줘야 한다. */}
            <button onClick={function(){sendMsg(name)}}>{name}</button>
        </div>
    );
}

export default PropBtn;