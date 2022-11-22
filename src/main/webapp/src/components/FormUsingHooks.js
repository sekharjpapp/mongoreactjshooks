import React, { useState } from 'react';
import './index.css';

const FormUsingHooks = () => {
  const [values, setValues] = useState({
    firstname: '',
    lastname: '',
    email: '',
  });
  const [submitted,setSubmitted] = useState(false);
  const [valid,setValid] = useState(false);

  const handleFirstNameInputChange = (event) => {
    setValues({ ...values, firstname: event.target.value });
  };
  const handleLastNameInputChange = (event) => {
    setValues({ ...values, lastname: event.target.value });
  };
  const handleMailInputChange = (event) => {
    setValues({ ...values, email: event.target.value });
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    if(values.firstname && values.lastname && values.email) {
        setValid(true);
    }
    setSubmitted(true);
  }
  return (
    <div className='form-container'>
      <form onSubmit={handleSubmit}>
      {submitted && valid? <div class='alert alert-success' role='alert'>
         Success! Thank you for Regestering 
        </div> :null}
        
        <div className='form-group'>
          <label for='exampleInputEmail1'>Firstname</label>
          <input
            onChange={handleFirstNameInputChange}
            value={values.firstname}
            type='text'
            className='form-control'
            name='firstname'
            id="name='firstname'"
            aria-describedby='emailHelp'
            placeholder='Enter firstname'
          />
          {submitted && !values.firstname ? <span>Please Enter a FirstName</span> : null}
        </div>
        <div className='form-group'>
          <label for='exampleInputEmail1'>Lastname</label>
          <input
            onChange={handleLastNameInputChange}
            type='text'
            value={values.lastname}
            className='form-control'
            name='lastname'
            id=" name='lastname'"
            aria-describedby='emailHelp'
            placeholder='Enter lastname'
          />
           {submitted && !values.lastname ? <span>Please Enter a lastname</span> : null}
        </div>
        <div className='form-group'>
          <label for='exampleInputEmail1'>Email address</label>
          <input
            onChange={handleMailInputChange}
            type='email'
            value={values.email}
            className='form-control'
            name='email'
            id="name='email'"
            aria-describedby='emailHelp'
            placeholder='Enter email'
          />
          {submitted && !values.email ? <span>Please Enter a Email</span> : null}
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
  );
};

export default FormUsingHooks;
