import React, { Component } from 'react';

class ClassComp extends Component {

    state = {number:0};

    constructor(props){
        super(props);
        console.log('컴포넌트 생성자 : ',props);
        this.state.number=parseInt(props.cnt,10);
    }

    componentDidMount(){
        console.log('컴포넌트가 화면에 나타났을 때 호출');
        //$(document).ready(function(){});
        //react 에서 외부 라이브러리 호출시 종종 사용
    };

    //중요!
    shouldComponentUpdate(nextProps,nextState){
        console.log('변화가 감지되면 실행');
        //기존값, 변화한 값 비교
        console.log(this.state,nextState);

        //특정한 상황에서만 랜더링 시켜 과부화를 막는 용도
        if (nextState.number%5 === 0) {
            return false;
        }
        return true; //false 면 랜더링을 시키지 않는다.
    };

    getSnapshotBeforeUpdate(nextProps,nextState){
        //render() 실행과 UI 업데이트 사이에 실행
        console.log('render 와 UI 업데이트 사이');
        return{'msg':'특정한 값을 반환할 수 있다.'};
    };

    //render() 호출하고 업데이트가 끝난 후에 호출
    //getSnapshotBeforeUpdate() 반환 값을 받는다
    componentDidUpdate(nextProps,nextState,snapshot){
        console.log('snapshot : ',snapshot);
        console.log('Component Update 끝');
    };

    handleIncrease=()=>{
        this.setState({number:this.state.number+1});
    };

    handleDecrease=()=>{
        //this.setState({number:this.state.number-1});
        //뭔가 복잡한 처리를 요할 때
        this.setState(
            ({number})=>{
                //로직처리
                return {number:number-1}; //반환
            }
        );
    };

    render() {
        return (
            <div style={{margin:30}}>
               <h1>Counter</h1>
               <div>Value : {this.state.number}</div>
               <button onClick={this.handleIncrease}> + </button>
               <button onClick={this.handleDecrease}> - </button>
            </div>
        );
    }
}

export default ClassComp;