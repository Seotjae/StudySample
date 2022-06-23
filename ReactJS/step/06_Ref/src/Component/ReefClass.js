import React, { Component, createRef } from 'react';

class ReefClass extends Component {
    //state 는 class 내장 속성 (꼭 생성자 안에 만들 필요는 없다.)
    state = {
        name:'',
        phone:''
    };

    //아래 변수들에 ref 를 담을 수 있도록 선언
    nameInput = createRef();
    phoneInput = createRef();

    regist = () =>{
        //해당 요소는 current 속성 아래에 있다.
        console.log(this.nameInput);
        console.log(this.phoneInput);
        this.setState({name:this.nameInput.current.value,phone:this.phoneInput.current.value});
    }

    render() {
        return (
            <div>
                <h3>NAME : {this.state.name} / PHONE : {this.state.phone}</h3>
                {/* ref 는 요소를 담는 변수이다/ */}
                <input type="text" ref={this.nameInput} placeholder='이  름'/>
                <input type="text" ref={this.phoneInput} placeholder='전화번호'/>
                <button onClick={this.regist}>입력</button>
            </div>
        );
    }
}

export default ReefClass;