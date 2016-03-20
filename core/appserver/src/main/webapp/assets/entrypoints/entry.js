'use strict';

import ReactDom from 'react-dom';
import React from 'react';
import { Router, Route, IndexRoute, DefaultRoute, NotFoundRoute, useRouterHistory } from 'react-router';
import { createHashHistory } from 'history'
import App from '../app/app.js';
import Login from '../app/modules/authentication/login/login.js';
import Signup from '../app/modules/authentication/signup/signup.js';
import LoginAction from '../app/modules/authentication/login/LoginAction.js';
import RouterContainer from '../app/global/router/RouterContainer.js';
import UserAccount from '../app/templates/useraccount/useraccount.js';
import HomePage from '../app/templates/homepage/homepage.js';
import ExploreFood from '../app/templates/explorefood/explore.js';

require('bootstrap-loader');

let login_token = localStorage.getItem('login_token');
let login_user = localStorage.getItem('login_user');
if (login_token && login_user) {
  LoginAction.loginUser(login_token, login_user);
}

const appHistory = useRouterHistory(createHashHistory)({ queryKey: false })

ReactDom.render((
		<Router history={appHistory}>
			<Route path="/" component={App}>
		 		<IndexRoute component={HomePage} />
		 		<Route path="/explorefood" component={ExploreFood} />
		 		<Route path="/useraccount" component={UserAccount} />
		 	</Route>
	    </Router>
		), document.getElementById('app'));