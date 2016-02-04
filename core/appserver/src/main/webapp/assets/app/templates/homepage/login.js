/**
 * @author 
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';
import ButtonToolbar from 'react-bootstrap/lib/ButtonToolbar';
import Button from 'react-bootstrap/lib/Button';
import Overlay from 'react-bootstrap/lib/Overlay';
import Popover from 'react-bootstrap/lib/Popover';

export default class Login extends React.Component {
	
  constructor(...args) {
	    super(...args);
	    this.state = { show: false };
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

          </Popover>
        </Overlay>
      </ButtonToolbar>
    );
  }
}
