/**
 * @author Yucheng
 * @since 1
 */
import LoginActions from '../login/LoginAction.js';
import when from 'when';
import LOGIN_CONSTANTS from '../login/LoginConstants.js';
import request from 'reqwest';

class AuthService {
	login(useremail, password) {
		const sentData = JSON.stringify({"userEmail":useremail, "userPassword":password});
	    return this.handleLogin(when(request({
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
	
	signup(useremail, password, username) {
		const sentData = JSON.stringify({"userEmail":useremail, "userPassword":password, "userName":username});
	    return this.handleSignup(when(request({
	      url: LOGIN_CONSTANTS.SIGNUP_URL,
	      method: 'POST',
	      crossOrigin: true,
	      contentType: 'application/json',
	      type: 'json',
	      data: sentData
	    })));
	}
	
	handleLogin(loginPromise) {
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
	    	console.log("login failed");
	    });
	}
	
	handleSignup(signupPromise) {
	    return signupPromise
	      .then(function(response) { //TODO: need to figure out response.status, response.result to wrap the result
	    	if (response.userName && response.isEmailAuthorized) {
		        LoginActions.loginUser("temp_token", response.userName);
		        console.log("user Signup Success");
		        return true;
	    	} 
	    	return false;
	    })
	      .catch(function(error){
	    	console.log("signup failed");
	    });
	}
}

export default new AuthService()
