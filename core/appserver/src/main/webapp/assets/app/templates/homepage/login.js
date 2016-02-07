/**
 * @author 
 * @since 1
 */

import React from 'react';
import AuthService from '../../global_services/auth_service.js';
import ReactDOM from 'react-dom';
import ButtonToolbar from 'react-bootstrap/lib/ButtonToolbar';
import Button from 'react-bootstrap/lib/Button';
import Overlay from 'react-bootstrap/lib/Overlay';
import Popover from 'react-bootstrap/lib/Popover';

export default class Login extends React.Component {
	
  constructor(props) {
	    super(props);
	    this.state = { 
	    	show: false,
		    email: '',
		    password: ''
	    };
  }
  
  login(e) {
	    e.preventDefault();
	    this.state.email = ReactDOM.findDOMNode(this.refs.email).value.trim();
	    this.state.password = ReactDOM.findDOMNode(this.refs.password).value.trim();
	    if (!this.state.email || !this.state.password) {
	    	return;
	    }
	    AuthService.login(this.state);
  }
	 
  render() {
    return (
      <ButtonToolbar>
        <a onClick={e => this.setState({ target: e.target, show: !this.state.show })}>
          Login
        </a>
        <Overlay
          show={this.state.show}
          target={()=> ReactDOM.findDOMNode(this.state.target)}
          placement="bottom"
          container={this}
          containerPadding={20}>
          <Popover title="Please Enter your username/email and password.">
	          <form role="form" className="loginForm">
		          <div className="form-group">
		            <label htmlFor="username">Email</label>
		            <input type="text" className="form-control" id="email" ref="email" placeholder="Email" />
		          </div>
		          <div className="form-group">
		            <label htmlFor="password">Password</label>
		            <input type="password" className="form-control" id="password" ref="password" placeholder="Password" />
		          </div>
	          <button type="submit" className="btn btn-default" onClick={this.login.bind(this)}>Submit</button>
	          </form>
          </Popover>
        </Overlay>
      </ButtonToolbar>
    );
  }
}
