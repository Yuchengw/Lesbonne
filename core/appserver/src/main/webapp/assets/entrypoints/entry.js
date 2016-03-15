'use strict';

import ReactDom from 'react-dom';
import React from 'react';
import { Router, Route,  hashHistory, IndexRoute, DefaultRoute, NotFoundRoute, useRouterHistory } from 'react-router';
import { createHashHistory } from 'history';
import App from '../app/app.js';
import Login from '../app/modules/authentication/login/login.js';
import Signup from '../app/modules/authentication/signup/signup.js';
import LoginAction from '../app/modules/authentication/login/LoginAction.js';
import RouterContainer from '../app/global/router/RouterContainer.js';
import UserProfile from '../app/templates/userprofile/userprofile.js';

require('bootstrap-loader');

//var routes = (
//	   <Route name="home" path="/" component={App}/>
//	   <Route name="userprofile" path="/userprofile" component={UserProfile}/>
//);

//var router = Router.create({routes});
//RouterContainer.set(router);

let login_token = localStorage.getItem('login_token');
let login_user = localStorage.getItem('login_user');
if (login_token && login_user) {
  LoginAction.loginUser(login_token, login_user);
}

const appHistory = useRouterHistory(createHashHistory)({	queryKey: false })

ReactDom.render((
		<Router history={appHistory}>
		 	<Route name="home" path="/" component={App}/>
		 	<Route name="userprofile" path="/userprofile" component={UserProfile}/>
		</Router>
		), document.getElementById('app'));