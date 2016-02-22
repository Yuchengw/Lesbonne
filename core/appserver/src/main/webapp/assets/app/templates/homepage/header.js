import React from 'react';
import ReactDom from 'react-dom';

import AuthService from '../../global_services/auth_service.js';
import LoginStore from '../../stores/LoginStore.js';
import Login from './login.js';
import AuthenticatedComponent from '../../global_components/AuthenticatedComponent.js'


export default AuthenticatedComponent(class Header extends React.Component {
  constructor() {
    super()
    this.state = this._getLoginState();
  }

  _getLoginState() {
    return {
      userLoggedIn: LoginStore.isLoggedIn(),
      userName: LoginStore.getUser()
    };
  }
  
  logout(e) {
    e.preventDefault();
    AuthService.logout();
  }
  
  render() {
	if (this.state.userLoggedIn) {
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
		          <li>Hey, {this.state.userName}</li> 
		          <li><a href="" onClick={this.logout}>Logout</a></li>
		        </ul>
		      </nav>
		    </header>)
	} else {
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
		          <li className="login"><Login /></li> 
		        </ul>
		      </nav>
		    </header>)
		}
	}
});
