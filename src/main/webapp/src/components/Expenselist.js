import React from 'react'

const Expenselist = () => {
    const expenses = [
        {id:1231232,name:"Shopping",cost:50},
        {id:1231232,name:"Holiday",cost:300},
        {id:1231232,name:"Transportation",cost:70},
        {id:1231232,name:"Fuel",cost:40},
        {id:1231232,name:"Child Care",cost:500}
    ];
  return (
    <div>
        <ul>
            {expenses.map((expense) =>(
                <ExpenseItem 
                    id = {expense.id}
                    name = {expense.name}
                    cost = {expense.cost}
                />    
            ))}
        </ul>
    </div>
  )
}

export default Expenselist