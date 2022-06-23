import React, { Component } from 'react';

class ClassComp extends Component {

    state = {count:0};

    updateCount=() => {
        this.setState({count:this.state.count+1});
    }

    alertCount(){
        setTimeout(()=>{
            alert('You Clicked On : '+this.state.count);
        },3000);
    }

    render() {
        return (
            <div>
                <h3>You Click {this.state.count} Times</h3>
                <button onClick={this.updateCount}>Click me</button>
                {/**함수를 화살표 함수로 선언하지 않았다면 아래처럼 호출*/}
                <button onClick={()=>{this.alertCount()}}>Show Alert</button>
            </div>
        );
    }
}

export default ClassComp;