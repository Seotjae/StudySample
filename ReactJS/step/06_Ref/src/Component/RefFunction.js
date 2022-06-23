import React from 'react';

const RefFunction = () => {
    
    //use... 는 React 의 속성이기 때문에 비구도 할당을 사용해도 되고 안해도 된다.
    const [text,setText]= React.useState('');

    const myref = React.useRef();

    
    const chgText = (e) =>{
        setText(e.target.value);
    }

    const txtFocus = () => {
        console.log(myref.current);
        setText('');
        //current 로 해당 요소에 접근하면 요소에 javascript 함수를 사용할 수 있다.
        myref.current.focus();
    };

    return (
        <div>
            <div>
                <h3>입력값 : {text}</h3>
                {/* 이벤트 객체는 기본적으로 주어지는 객체이므로 별도로 매개변수로 받지 않아도 된다. */}
                <input type="text" value={text} onChange={chgText} ref={myref}/>
                <button onClick={txtFocus}>초기화</button>
            </div>
        </div>
    );
};

export default RefFunction;