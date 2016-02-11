'use strict';

import ReactDom from 'react-dom';
import React from 'react';
import Router from 'react-router';
var { Route, DefaultRoute, NotFoundRoute} = Router;
import App from '../app/app.js';
import Login from '../app/templates/homepage/login.js';
import Signup from '../app/templates/homepage/signup.js';
import RouterContainer from '../app/global_services/router_container.js';

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
if (login_token) {
  LoginActions.loginUser(login_token);
}

router.run(function (Handler) {
	ReactDom.render(<App/>, document.getElementById('app'));
});