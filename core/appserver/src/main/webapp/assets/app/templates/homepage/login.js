/**
 * @author 
 * @since 1
 */

import React from 'react/addons';
import ReactMixin from 'react-mixin';
import AuthService from '../../global_services/AuthService';
import ReactDOM from 'react-dom';
import ButtonToolbar from 'react-bootstrap/lib/ButtonToolbar';
import Button from 'react-bootstrap/lib/Button';
import Overlay from 'react-bootstrap/lib/Overlay';
import Popover from 'react-bootstrap/lib/Popover';

export default class Login extends React.Component {
	
  constructor(...args) {
	    super(...args);
	    this.state = { 
	    	show: false,
		    email: '',
		    password: ''
	    };
  }
  
  login(e) {
	    e.preventDefault();
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
	          <form role="form">
		          <div className="form-group">
		            <label htmlFor="username">Email</label>
		            <input type="text" valueLink={this.linkState('email')} className="form-control" id="email" placeholder="Email" />
		          </div>
		          <div className="form-group">
		            <label htmlFor="password">Password</label>
		            <input type="password" valueLink={this.linkState('password')} className="form-control" id="password" ref="password" placeholder="Password" />
		          </div>
	          <button type="submit" className="btn btn-default" onClick={this.login.bind(this)}>Submit</button>
	          </form>
          </Popover>
        </Overlay>
      </ButtonToolbar>
    );
  }
}
