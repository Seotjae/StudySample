import './App.css';
import { Component, Fragment } from 'react';
import { render } from '@testing-library/react';


class App2 extends Component{

  constructor(props){
    super(props);
  }

  //클래스에서는 함수나 변수 선언시 키워드를 쓰지 않는다.

  render(){
    //함수 안에서만 키워드 사용가능
    var name ='최성재'; //함수영역 변수
    const gender = '남자';//상수
    let age = 29; //블록 영역 변수

    //css 파일이 아닌 js 파일에서 쓰는 css 는 사용방법이 조금 다르다.
    const style = {
      backgroundColor:'black',
      padding:'16px',
      color:'white',
      fonSize:'16px'
    }

    return(
      <Fragment> {/*div 대신 쓸 수 있는 태그, 아무 의미 없이 묶어주는 역할만 수행*/}
        <div className="App">
          <h1>안녕하세요 리액트에 잘 오셨습니다.</h1>
        </div>
        <div style={style}>
          {name} / {gender} / {age} {/*자바 스크립트의 문법은 {} 안에서 사용가능*/}
        </div>
        <div>
          {/* 렌더 함수 안에서는 if 문을 사용할 수 없다. (3항 연산자 사용) */}
          {1+1 === 2 ? (<p>맞습니다.</p>) : (<p>틀립니다.</p>)}
          {//3항 연산자가 아니라 꼭 if 를 써야겠다 한다면
            (() => {
              if (age === 11) {return(<div>열하나</div>)}
              if (age === 20) {return(<div>스물</div>)}
              if (age === 29) {return(<div>스물아홉</div>)}
            })()

          }
        </div>
      </Fragment>
    );
  }
}


//위 내용을 함수형태로 바꿔보자
function App() {
  var name ='최성재';
  const gender = '남자';
  let age = 29;

  const style = {
    backgroundColor:'black',
    padding:'16px',
    color:'white',
    fonSize:'16px'
  }
  return(
    <div>
      <div className="App">
        <h1>안녕하세요 리액트에 잘 오셨습니다. 함수</h1>
      </div>
      <div style={style}>
        {name} / {gender} / {age}
      </div>
      <div>
        {1+1 === 2 ? (<p>맞습니다.</p>) : (<p>틀립니다.</p>)}
        {
          (() => {
            if (age === 11) {return(<div>열하나</div>)}
            if (age === 20) {return(<div>스물</div>)}
            if (age === 29) {return(<div>스물아홉 함수</div>)}
          })()

        }
      </div>
    </div>
    
  );
}


export default App; //App 이라는 이름으로 공개하겠다. (public 개념)
