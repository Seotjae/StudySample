import React, { Component, Fragment } from "react";

/*
function Input() {
    const[text,setText] = useState("초기값");

    const updateText = val => {
        console.log(val);
        //변경 내용이 UI에 적용 되려면 state 에 저장되어야 한다.
        setText(val);
    }
    return(
        <Fragment>
            <h3>입력 내용 : {text}</h3>
            <input type="text" placeholder="아무거나 입력하세요" onChange={(e)=>{updateText(e.target.value)}}/>
        </Fragment>
    );
}
*/

class Input extends Component{

    constructor(props){
        super(props);
        this.state = {text:'초기값'};
    }

    updateText = e => {
        //console.log(e.target.value);
        this.setState({text:e.target.value});
    }

    render(){
        return(
            <Fragment>
                <h3>입력 내용 : {this.state.text}</h3>
                <input type="text" placeholder="아무거나 입력하세요" onChange={(e)=>{this.updateText(e)}}/>
            </Fragment>
        );
    }

}



export default Input;