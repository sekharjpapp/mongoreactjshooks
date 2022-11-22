import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Layout from './components/Layout';
import Blogs from './components/Blogs';
import Showhide from './components/Showhide';
import Mainlayout from './components/Mainlayout';
import FormUsingHooks from './components/FormUsingHooks';


function App() {
  return (
    <div className='container'>
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route path='/showhide' element={<Showhide />} />
          <Route path='/blogs' element={<Blogs />} />
          <Route path='/mainlayout' element={<Mainlayout />} />
          <Route path='/formUsingHooks' element={<FormUsingHooks />} />
        </Route>
      </Routes>
      
    </div>
  );
}

export default App;
