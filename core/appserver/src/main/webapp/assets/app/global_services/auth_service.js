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
	    	if (response.status === 200 && response.statusText == "OK") {
		        LoginActions.loginUser(response.getResponseHeader('LOGIN-TOKEN'), response.getResponseHeader('USER-NAME'));
		        console.log("user Login Success");
		        return true;
	    	} 
	    	return false;
	    })
	      .catch(function(error){
	    	console.log("user Login failed");
	    });
	}
}

export default new AuthService()
