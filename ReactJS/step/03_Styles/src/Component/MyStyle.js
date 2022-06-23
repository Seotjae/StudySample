import React from 'react';
import '../App.css';

//export default MyStyle 을 아래처럼 사용가능
/*
export default function MyStyle() {
    
    const styles = {
        fontSize:26,
        fontWeight:700,
        color:'blue',
        backgroundColor:'yellowgreen'
    };
    
    return(
        <div>
            <h1 style={{color:'red'}}>Hello Inline Style</h1>  직접 넣는 스타일 
            <p style={styles}>JavaScript Object Style</p>  자바스크립트 객체 스타일 
            
            css 파일 사용
            <h1 className='App-title'>Use ClassName</h1> 
            <span>Css Style</span>

        </div>
    );
}
*/

//화살표 함수로 변경
const MyStyle = () => {
    const styles = {
        fontSize:26,
        fontWeight:700,
        color:'blue',
        backgroundColor:'yellowgreen'
    };
    return(
        <div>
            <h1 style={{color:'red'}}>Hello Inline Style</h1>
            <p style={styles}>JavaScript Object Style</p>
            <h1 className='App-title'>Use ClassName</h1> 
            <span>Css Style</span>

        </div>
    );
}

export default MyStyle
