import axios from 'axios';
import React, { useState } from 'react';

const OverlayComp = () => {

    const [text,setText] = useState('');

    const overlayChk = async () => {
        console.log('중복확인 : ',text);
        //get으로 보내기
        //let {data} = await axios.get('/main/overlay/'+text);
        //post 로 보내기 (parameter 를 JSON 형태로 보낸다)
        let {data} = await axios.post('/main/overlay/',{id:text});
        console.log(data);

        if (data.use) {
            alert('사용 가능한 아이디 입니다.');
        }else{
            alert('이미 사용중인 아이디 입니다.');
        }
    };

    return (
        <div>
            <input type="text" placeholder='아아디를 입력하세요' onChange={(e)=>{setText(e.target.value)}} value={text}/>
            <button onClick={overlayChk}>중복확인</button>        
        </div>
    );
};

export default OverlayComp;