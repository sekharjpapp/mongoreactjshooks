import React from 'react';
import Budget from './Budget';
import Remaining from './Remaining';
import ExpenseTotal from './ExpenseTotal';
import 'bootstrap/dist/css/bootstrap.min.css';

const Mainlayout = () => {
  return (
    <div>
      <h1 className='mt-3'> My Budget Planner </h1>
      <div className='row mt-3'>
        <div className='col-sm'>
          <Budget />
        </div>
        <div className='col-sm'>
          <Remaining />
        </div>
        <div className='col-sm'>
          <ExpenseTotal />
        </div>
      </div>
      <h3 className='mt-3'>Expenses</h3>
    </div>
  );
};

export default Mainlayout;
