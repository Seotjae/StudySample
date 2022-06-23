import React, { Component } from "react";

class StateBtn extends Component{
    //state 는 setState() 를 통해 변경이 가능
    //state 값이 변경되면 render() 가 실행된다.
    //state 는 class component 전용
    constructor(props){
        super(props);
        console.log(props); //상위 컴포넌트에서 보낸 props
        this.state = {count:0};
    }

    updateCount=()=>{
        this.setState({count:this.state.count+1});
    }

    render(){
        return(
            <div style={{margin:10}}>
                <button onClick={this.updateCount}>UP COUNT : {this.state.count}</button>
            </div>
        );
    }

}

export default StateBtn;