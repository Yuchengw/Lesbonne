/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import LoginStore from '../authentication/login/LoginStore.js';

export default (ComposedComponent) => {
  return class AuthenticatedComponent extends React.Component {

    static willTransitionTo(transition) {
      if (!LoginStore.isLoggedIn()) {
        transition.redirect('/');
      }
    }

    constructor(props) {
      super(props);
      this.state = this._getLoginState();
    }

    _getLoginState() {
      return {
        userLoggedIn: LoginStore.isLoggedIn(),
        user: LoginStore.getUser(),
        login_token: LoginStore.getloginToken()
      };
    }

    componentDidMount() {
      this.changeListener = this._onChange.bind(this);
      LoginStore.addChangeListener(this.changeListener);
    }

    _onChange() {
      this.setState(this._getLoginState());
    }

    componentWillUnmount() {
      LoginStore.removeChangeListener(this.changeListener);
    }

    render() {
      return (
      <ComposedComponent
        {...this.props}
        user={this.state.user}
        login_token={this.state.login_token}
        userLoggedIn={this.state.userLoggedIn} />
      );
    }
  }
};