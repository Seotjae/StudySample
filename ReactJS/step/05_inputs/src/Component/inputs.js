import react, { useState } from "react";
import { Fragment } from "react/cjs/react.production.min";

export default function Inputs() {

    const [inputs,setInputs] = useState({id:'',nick:''});

    //비 구조 할당 객체의 속성이 곧 변수명이 된다.
    //해당 변수명을 호출하면 그 객체의 속성값을 가져온다.
    const {id,nick} = inputs;

    const reset = () =>{
        setInputs({id:'',nick:''});
        
    };

    const typing =(key,e)=>{
        //var obj = {key:value};
        //var obj.key = value;
        //var obj[key] = value;
        //리액트에서는 객체를 변형할 때 그냥 변형하지 말고 기존 객체를 복사한 다음에 변형하도록 권고
        //... 을 spread 라고 부른다.
        //spread 를 사용하지 않고 속성 변경시 일부 속성만 변경될 경우 나머지 속성이 초기화될 수 있다.
        setInputs({
            ...inputs
            ,[key]:e.target.value
        });

    };


    return(
        <Fragment>
            아이디 : <input id="userId" type="text" onChange={(e)=>{typing('id',e)}} value={id}/><br/>
            닉네임 : <input id="nickName" type="text" onChange={(e)=>{typing('nick',e)}} value={nick}/><br/>
            <button onClick={reset}>초기화</button>
            <h3>아이디 : {id} / 닉네임 : {nick}</h3>
        </Fragment>
    );
}