'use strict';

import ReactDom from 'react-dom';
import React from 'react';
import Router from 'react-router';
var { Route, DefaultRoute, NotFoundRoute} = Router;
import App from '../app/app.js';
import Login from '../app/authentication/login/login.js';
import Signup from '../app/authentication/signup/signup.js';
import LoginAction from '../app/authentication/login/LoginAction.js';
import RouterContainer from '../app/global_router/RouterContainer.js';

require('bootstrap-loader');

const routes = (
		  <Route handler={App}>
		    <Route name="login" handler={Login}/>
		    <Route name="signup" handler={Signup}/>
		    <Route name="main" path="/" handler={App}/>
		  </Route>
);

const router = Router.create({routes});
RouterContainer.set(router);

let login_token = localStorage.getItem('login_token');
let login_user = localStorage.getItem('login_user');
if (login_token && login_user) {
  LoginAction.loginUser(login_token, login_user);
}

router.run(function (Handler) {
	ReactDom.render(<App />, document.getElementById('app'));
});