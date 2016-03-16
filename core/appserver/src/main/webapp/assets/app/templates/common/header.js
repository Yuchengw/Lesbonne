import React from 'react';
import AuthService from '../../modules/authentication/service/AuthService.js';
import LoginStore from '../../modules/authentication/login/LoginStore.js';
import Login from '../../modules/authentication/login/login.js';
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
		var headerCss = 'header';
		// we need to apply an additional css for homepage header
		if (window.location.hash === '#/') {
			headerCss = headerCss + ' homepage-header';
		}
		
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
	    		<header className={headerCss}>
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
