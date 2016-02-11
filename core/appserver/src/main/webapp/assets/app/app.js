//let Router = require('react-router')
//let Route = Router.Route
//let Link = Router.Link
import React from 'react';
import Header from './templates/homepage/header.js';
import Hero from './templates/homepage/hero.js';
import Value from './templates/homepage/value.js';
import SearchContainer from './templates/homepage/search_container.js';
import AuthenticatedComponent from './global_components/AuthenticatedComponent.js'
import LoginStore from './stores/LoginStore.js'
import { Route, RouteHandler, Link } from 'react-router';
import AuthService from './global_services/auth_service.js'

require('../scss/app.scss');

export default class App extends React.Component {
  constructor() {
    super()
    this.state = this._getLoginState();
  }
  _getLoginState() {
    return {
      userLoggedIn: LoginStore.isLoggedIn()
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
  
  logout(e) {
    e.preventDefault();
    AuthService.logout();
  }
  
  render() {
    return (
    	<div className='homepage'>
    		<Header />
    		<Hero />
    		<Value />
    		<SearchContainer />
    	</div>
    );
  }
}
