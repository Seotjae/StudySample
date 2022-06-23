import React from 'react';
/* alert 은 렌더링을 비롯한 기본 흐름을 막는 기능이 있다.
 * 이때 render() 는 제대로 동작하지 못한다.
 * 그래서 render 함수 안에 있는 변수는 state 의 변화를 받아들이지 못한다.
 * 1. alert() 이 실행되는 동안 render() 함수는 멈춰있는 상태다.
 * 2. render() 안에 있는 변수는 제대로 동작하지 못한다.
 * 3. alert() 에서 사용 되는 count 변수는 변경된 내용을 받지 못한다.
 * 이경우 render() 에 영향받지 않는 Ref 를 사용하면 된다.
 */

const FuncComp = () => {

    const [count,setCount] = React.useState(0);
    const refVal = React.useRef(0);

    const updateCount=() => {
        //setCount(count+1);
        refVal.current += 1;   
        //state 값에 ref 값을 넣음으로써 UI 에도 변화가 생기도록
        setCount(refVal.current);     
    }

    const alertCount=() => {
        setTimeout(()=>{
            //alert('You Clicked On : '+count);
            alert('You Clicked On : '+refVal.current);
        },3000);
    }

    return (
        <div>
            <h3>You Click {count} Times</h3>
            <button onClick={updateCount}>Click me</button>
            <button onClick={()=>{alertCount()}}>Show Alert</button>
        </div>
    );
};

export default FuncComp;