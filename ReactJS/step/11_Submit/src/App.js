import React from 'react';
import AsyncComp from './Component/AsyncComp';
import FileUploadComp from './Component/FileUploadComp';
import OverlayComp from './Component/OverlayComp';
import PostList from './Component/PostList';

//npm install axios
const App = () => {

  return (
    <div>
      <AsyncComp/>
      <OverlayComp/>
      <FileUploadComp/>
    </div>
  );
};

export default App;