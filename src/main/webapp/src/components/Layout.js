import React from 'react'
import { Outlet, Link } from "react-router-dom";

const Layout = () => {
  return (
    <>
    <nav>
      <ul className="navbar-nav mr-auto">
        <li className="nav-item">
          <Link to="/">Showhide </Link>  | 
        </li>
        <li className="nav-item">
          <Link to="/blogs">Blogs</Link>  | 
        </li>
        <li className="nav-item">
          <Link to="/contact">Contact</Link>
        </li>
        <li className="nav-item">
          <Link to="/mainlayout">Mainlayout</Link>
        </li>
        <li className="nav-item">
          <Link to="/formUsingHooks">FormUsingHooks</Link>
        </li>
        
      </ul>
    </nav>

    <Outlet />
  </>

  )
}

export default Layout