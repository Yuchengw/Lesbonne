import ReactDom from 'react-dom';
import React from 'react';
import App from '../app/app.js';
import Login from '../app/templates/homepage/login.js';
import Signup from '../app/templates/homepage/signup.js';

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

router.run(function (Handler) {
	ReactDom.render(<App/>, document.getElementById('app'));
});
