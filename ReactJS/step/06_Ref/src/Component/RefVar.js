import { render } from '@testing-library/react';
import React, { useRef, useState } from 'react';

const RefVar = () => {

    //ref 에는 요소뿐만 아니라 특정한 값을 넣을수도 있다.
    //ref에 저장된 값은 컴포넌트 전 생애주기 동안 유지되며 렌더링 상황에 영향 받지 않는다.

    const [count,setCount]=useState(0);
    const refVal = useRef(0);

    const updateState = () => {
        setCount(count+1);
    };

    //렌더링에 영향을 주지 않기 때문에, 아무리 값이 변경되어도 UI가 변하지 않는다.
    const updateRef = () => {
        refVal.current += 1;
        console.log(refVal);
    };

    return (
        <div>
            <button onClick={updateState}>state count : {count}</button>
            <button onClick={updateRef}>ref count : {refVal.current}</button>
        </div>
    );
};

export default RefVar;