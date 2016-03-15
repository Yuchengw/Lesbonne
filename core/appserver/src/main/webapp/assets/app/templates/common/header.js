import React from 'react';
import AuthService from '../../modules/authentication/service/AuthService.js';
import LoginStore from '../../modules/authentication/login/LoginStore.js';
import Login from '../../modules/authentication/login/login.js';
import AuthenticatedComponent from '../../global/components/AuthenticatedComponent.js'

export default AuthenticatedComponent(class Header extends React.Component {
	constructor(props) {
	    super(props);
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
		if (this.props.userLoggedIn) {
			var userProfile = 
				<li className="profile">
        			<a className="media-left" href="#">
        				<img alt="Steve" className="img-circle" src="http://placehold.it/20x20"></img>
        				<span className="profile-name"> Hi {this.props.user}</span>
        			</a>
        		</li>;
        	var logout = <li><a href="" onClick={this.logout}>Logout</a></li>;
		} else {
			var userProfile =
				<Login/>;
			var logout = '';	
		}
		
	    return (
	    		<div className="header">
	    		<nav className="navbar navbar-default navbar-static-top">
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
	    	    </div>
	    );
	  }
})