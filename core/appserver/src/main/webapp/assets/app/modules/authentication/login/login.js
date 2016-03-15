/**
 * @author 
 * @since 1
 */

import React from 'react';
import AuthService from '../service/AuthService.js';
import ReactDOM from 'react-dom';
import ButtonToolbar from 'react-bootstrap/lib/ButtonToolbar';
import Button from 'react-bootstrap/lib/Button';
import Overlay from 'react-bootstrap/lib/Overlay';
import Popover from 'react-bootstrap/lib/Popover';

require ("./login.scss");

export default class Login extends React.Component {
	
  constructor(props) {
    super(props);
    this.state = { 
    	show: false,
	    name: '',
	    password: ''
    };
  }
  
  login(event) {
    event.preventDefault();
    this.state.email = ReactDOM.findDOMNode(this.refs.email).value.trim();
    this.state.password = ReactDOM.findDOMNode(this.refs.password).value.trim();
    this.setState({show: !this.state.show});
    AuthService.login(this.state.email, this.state.password)
    .catch(function(err) {
    	console.log('Error for login : ', err);
    });
  }

	render() {
	    return (
	    	<ButtonToolbar>
		        <a onClick={e => this.setState({ target: e.target, show: !this.state.show })}>
		          Login
		        </a>
		          	<div className="login-block">
				        <Overlay 
				          show={this.state.show}
				          target={()=> ReactDOM.findDOMNode(this.state.target)}
				          placement="bottom"
				          container={this}>
				          <Popover placement="bottom" positionLeft={500} title="Please Enter your username/email and password.">
					          <form role="form" className="loginForm">
						          <div className="form-group">
						            <input type="text" className="form-control" id="email" ref="email" placeholder="Email" />
						            <input type="password" className="form-control" id="password" ref="password" placeholder="Password" />
						          	<button type="submit" className="btn btn-default" onClick={this.login.bind(this)}>Submit</button>
						          </div>
						     </form>
				          </Popover>
				        </Overlay>
			        </div>
	        </ButtonToolbar>);
  }
}
