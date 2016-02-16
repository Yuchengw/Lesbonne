/**
 * @author Yucheng
 * @since 1
 */
import LoginActions from '../actions/LoginAction.js';
import when from 'when';
import LOGIN_CONSTANTS from '../constants/LoginConstants.js';
import request from 'reqwest';

class AuthService {
	login(useremail, password) {
		const sentData = JSON.stringify({"userEmail":useremail, "userPassword":password});
	    return this.handleAuth(when(request({
	      url: LOGIN_CONSTANTS.LOGIN_URL,
	      method: 'POST',
	      crossOrigin: true,
	      type: 'json',
	      data: sentData
	    })));
	}

	logout() {
	    LoginActions.logoutUser();
	}
	
	signup(useremail, password) {
		const sentData = JSON.stringify({"userEmail":useremail, "userPassword":password});
	    return this.handleAuth(when(request({
	      url: LOGIN_CONSTANTS.SIGNUP_URL,
	      method: 'POST',
	      crossOrigin: true,
	      contentType: 'application/json',
	      type: 'json',
	      data: sentData
	    })));
	}
	
	handleAuth(loginPromise) {
	    return loginPromise
	      .then(function(response) {
	        const login_token = response.login_token;
	        LoginActions.loginUser(login_token);
	        return true;
	    })
	      .catch(function(error){
	    	console.log("user Login failed");
	    });
	}
}

export default new AuthService()
