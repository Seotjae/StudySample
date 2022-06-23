import axios from 'axios';
import React, { useState } from 'react';

const FileUploadComp = () => {

    const[fileInfo,setFileInfo] = useState(null);
    const[path,setPath] = useState(null);
    const fileSelect = (e) => {
        setFileInfo(e.target.files[0]);
    }

    const postSend = async (e) => {
        console.log(e);
        //파일을 보낼 때는 파라미터로 formData를 사용한다. (IE 9 이상부터 동작)
        const formData = new FormData();
        formData.append('file',fileInfo);
        const config = {headers:{"content-type":"multipart/form-data"}};

        //url, parameter, config
        let {data} = await axios.post('/main/upload',formData,config);
        console.log(data);
        setPath(data.path);
    }


    return (
        <div>
            <input type="file" name='photo' onChange={fileSelect}/>
            <button onClick={postSend}>UPLOAD</button>
            {path != null ?  <img src={path}/> : ''}
           
        </div>
    );
};

export default FileUploadComp;