import { Container } from '@mui/system';
import React, { Component } from 'react';

export class DivElementhide extends Component {
  constructor(props) {
    super(props);
    this.state = { value: '' };
  }
  onChange = (e) => {
    this.setState({ value: e.target.value });
  };
  setGender(event) {
    console.log(event.target.value);
  }

  render() {
    const { value } = this.state;
    return (
      <React.Fragment>
        <Container>      
          <div className='row'>
            <div className='col-sm-6'>
              <h4 className='mt-3'>Show/Hide div on radio button </h4>
              <h5>Current Value {value}</h5>
              <div className='form-group row'>
                <label className='col-sm-3 col-form-label'>Name</label>
                <div className='col-sm-9'></div>
                <input
                  type='text'
                  className='form-control'
                  id='inputPassword'
                  placeholder='Enter your name'
                />
              </div>
              <div onChange={this.setGender.bind(this)}>
                <input type='radio' value='MALE' name='gender'   onChange={this.onChange}/> Male
                <input type='radio' value='FEMALE' name='gender' /> Female
              </div>
              <div className='form-group row'>
                <label className='col-sm-3 col-form-label'>Full Address</label>
                <div className='col-sm-2 mt-2'>
                  Yes
                  <input
                    type='radio'
                    className='mx-2 mt-1'
                    name='isyes'
                    value='1'
                    onChange={this.onChange}
                  />
                </div>
                <div className='col-sm-2 mt-2'>
                  No
                  <input
                    type='radio'
                    className='mx-2 mt-1'
                    name='isno'
                    value='0'
                    onChange={this.onChange}
                  />
                </div>
                {value === '1' && (
                  <div className='form-group row mb-3'>
                    <label className='col-sm-3 col-form-label'>
                      Full Details
                    </label>
                    <div className='col-sm-9'></div>
                    <textarea
                      type='text'
                      className='form-control'
                      id='details'
                      placeholder='Enter your name'
                    />
                  </div>
                )}
                {value === '1' && (
                  <div className='form-group row mb-3'>
                    <label className='col-sm-3 col-form-label'>Email</label>
                    <div className='col-sm-9'></div>
                    <input
                      type='text'
                      className='form-control'
                      id='details'
                      placeholder='Enter your name'
                    />
                  </div>
                )}
                {value === 'MALE' && (
                  <div className='form-group row mb-3'>
                    <label className='col-sm-3 col-form-label'>Email</label>
                    <div className='col-sm-9'></div>
                    <input
                      type='text'
                      className='form-control'
                      id='details'
                      placeholder='Enter your name'
                    />
                  </div>
                 )} 
                 
                <div className='form-group row mt-5 text-center'>
                  <label className='form-check-labecol-sm-2 col-form-label'></label>
                  <div className='col-sm-10 mt-2'>
                    <button type='submit' class='btn btn-primary'>
                      Submit
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </Container>
      </React.Fragment>
    );
  }
}

export default DivElementhide;
