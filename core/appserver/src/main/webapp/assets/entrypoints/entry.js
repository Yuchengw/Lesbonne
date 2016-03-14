'use strict';

import ReactDom from 'react-dom';
import React from 'react';
import { Router, Route, IndexRoute, DefaultRoute, NotFoundRoute, hashHistory } from 'react-router';
import App from '../app/app.js';
import createHistory from "history/lib/createHashHistory";
import Login from '../app/modules/authentication/login/login.js';
import Signup from '../app/modules/authentication/signup/signup.js';
import LoginAction from '../app/modules/authentication/login/LoginAction.js';
//import RouterContainer from '../app/global/router/RouterContainer.js';
import UserProfile from '../app/templates/userprofile/userprofile.js';

require('bootstrap-loader');

var routes = (
		   <Route name="home" path="/" handler={App}>
		    	<Route name="userprofile" path="/userprofile" handler={UserProfile}/>
		  </Route>
);

//var router = Router.create({routes});
//RouterContainer.set(router);

let login_token = localStorage.getItem('login_token');
let login_user = localStorage.getItem('login_user');
if (login_token && login_user) {
  LoginAction.loginUser(login_token, login_user);
}

//router.run(function (Handler) {
//	ReactDom.render(<App />, document.getElementById('app'));
//});

ReactDom.render(<Router history={createHistory({ queryKey: false })}
onUpdate={() => window.scrollTo(0, 0)}>{routes}</Router>, document.getElementById('app'));