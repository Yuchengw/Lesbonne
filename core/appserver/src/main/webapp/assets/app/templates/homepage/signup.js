/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import AuthService from '../../global_services/auth_service.js';

export default class Signup extends React.Component {
	
	 constructor(props) {
		 super(props);
		 this.signup = this.signup.bind(this);
	     this.state = {
	         email: '',
	         password: '',
	         fullname: ''
	     };
     }

	 signup(event) {
	   event.preventDefault();
	   this.state.fullname = React.findDOMNode(this.refs.fullname).value.trim();
	   this.state.email = React.findDOMNode(this.refs.email).value.trim();
	   this.state.password = React.findDOMNode(this.refs.password).value.trim();
	   AuthService.signup(this.state);
	 }
	  
	 render() {
		console.log("Signup");
	    return (
	      <div>
		      <div className="float-right signup-block">
			      <div className="signup-block-header">
			        <h3>Get First Meal Free</h3>
			        <p className="mb-0">by signing up now</p>
			      </div>
			      <div className="signup-block-content">
			        <div className="signup-social">
			          <p>Sign Up with Social Connect</p>
			          <div>
			            <button className="btn-social btn-facebook">Facebook</button>
			            <button className="btn-social btn-googleplus">Google</button>
			          </div>
			          <span>We will not send you spam with this</span>
			        </div>
			        <form role="form">
				        <div className="signup-email">
				          <p>Or, Sign Up with Email</p>
				          <input type="text" refs='fullname' placeholder="Your Full Name"/>
				          <input type="text" refs='email' placeholder="Password"/>
				          <input type="text" refs='password' placeholder="Email"/>
				        </div>
				        <input type="submit" onClick={this.signup.bind(this)} className="navy-btn" value="Sign Up"> </input>
			        </form>
			     </div>
		     </div>
	      </div>
	    );
	 }
}
