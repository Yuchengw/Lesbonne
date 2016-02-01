/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDom from 'react-dom';
import Login from './login.js';
import Signup from './signup.js';

export default class Header extends React.Component{
	render() {
		return (
		    <header>
		      <nav className="container">
		        <h1 className="site-name">
		          <span></span> LesBonnes
		        </h1>
		        <ul>
		          <li>Explore test</li>
		          <li>How it works</li>
		          <li>Become a chef</li>
		          <li className="login"> <Login /> </li> 
		          <li className="signup"> <Signup /> </li>
		        </ul>
		      </nav>
		    </header>
		);
	}
}
