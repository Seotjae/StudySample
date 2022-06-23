import React, { Component } from 'react';
import $ from 'jquery';

class ClassComp extends Component {
    //모든 컴포넌트가 다 읽히면 제이쿼리 기능 수행
    componentDidMount(){
        //버튼을 누르면... h3 에 '제이쿼리 불러오기' 문구가 생기고
        //글자 색상은 빨간색으로 변경된다.
        $('#class_btn').on('click',()=>{
            console.log('버튼클릭');
            $('#cls_msg').html('제이쿼리 불러오기');
            $('#cls_msg').css({'color':'red'});
        });
    }
    render() {
        return (
            <div>
                <h3 id="cls_msg"></h3>
                <button id='class_btn'>클래스 버튼</button>
            </div>
        );
    }
}

export default ClassComp;