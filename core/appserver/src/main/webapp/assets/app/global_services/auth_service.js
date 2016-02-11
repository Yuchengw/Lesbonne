/**
 * @author Yucheng
 * @since 1
 */
import LoginActions from '../actions/LoginActions.js';
import when from 'when';
import {LOGIN_URL, SIGNUP_URL} from '../constants/LoginConstants.js';
import request from 'reqwest';

class AuthService {
	login(username, password) {
	    return this.handleAuth(when(request({
	      url: LOGIN_URL,
	      method: 'POST',
	      crossOrigin: true,
	      type: 'json',
	      data: {
	        username, password
	      }
	    })));
	}

	logout() {
	    LoginActions.logoutUser();
	}
	
	signup(username, password, useremail) {
	    return this.handleAuth(when(request({
	      url: SIGNUP_URL,
	      method: 'POST',
	      crossOrigin: true,
	      type: 'json',
	      data: {
	        username, password, useremail
	      }
	    })));
	}
	
	handleAuth(loginPromise) {
	    return loginPromise
	      .then(function(response) {
	        const login_token = response.login_token;
	        LoginActions.loginUser(login_token);
	        return true;
	    });
	}
}

export default new AuthService()
