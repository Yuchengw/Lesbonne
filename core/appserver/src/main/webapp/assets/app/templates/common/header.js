import React from 'react';
import AuthService from '../../modules/authentication/service/AuthService.js';
import LoginStore from '../../modules/authentication/login/LoginStore.js';
import Login from '../../modules/authentication/login/login.js';
import { Link } from 'react-router';
import AuthenticatedComponent from '../../global/components/AuthenticatedComponent.js'

class Header extends React.Component {

	constructor(props, context) {
	    super(props, context);
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
		let userProfile = <Login />;
		let logout = '';
		if (this.props.userLoggedIn) {
			userProfile = <li className="profile">
							<a href="#/useraccount" className="media-left">
		        				<img className="img-circle" src="http://placehold.it/20x20"></img>
		        				<span className="profile-name"> Hi, {this.props.user}</span>
		        			</a>
		        		  </li>;
        	logout = <li><a href="" onClick={this.logout}>Logout</a></li>;
		}
	    return (
	    		<header className="header">
	    		<nav className="navbar navbar-default navbar-fixed-top">
	    	      <div className="container">
	    	        <div className="navbar-header">
	    	          <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	    	            <span className="sr-only">Toggle navigation</span>
	    	            <span className="icon-bar"></span>
	    	            <span className="icon-bar"></span>
	    	            <span className="icon-bar"></span>
	    	          </button>
	    	          <a className="navbar-brand brand-logo" href="#">
	    	          	<img alt="Lesbonnes" src="/as/app/templates/homepage/images/logo.png">
	    	          	</img>
	    	          </a>
	    	          <a className="navbar-brand" href="#">Les Bonnes</a>
	    	        </div>
	    	        <div id="navbar" className="navbar-collapse collapse">
	    	          <ul className="nav navbar-nav navbar-right">
	    	            <li><a href="../navbar/">Explore</a></li>
	    	            <li><a href="../navbar-static-top/">How it works</a></li>
	    	            <li><a href="./">Become a chef</a></li>
	    	            {userProfile}
	    	            {logout}
	    	          </ul>
	    	        </div>
	    	      </div>
	    	    </nav>
	    	    </header>
	    );
	  }
};

Header.contextTypes = {
	router: React.PropTypes.func.isRequired
}

export default AuthenticatedComponent(Header);
