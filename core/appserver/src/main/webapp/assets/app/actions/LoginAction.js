/**
 * @author yucheng
 * @since 1
 */
import AppDispatcher from '../dispatcher/AppDispatcher.js';
import {LOGIN_USER, LOGOUT_USER} from '../constants/LoginConstants.js';
import RouterContainer from '../global_services/RouterContainer.js'

export default {
  loginUser: (login_token, login_user) => {
    const saved_login_token = localStorage.getItem('login_token');
    
    AppDispatcher.dispatch({
      actionType: LOGIN_USER,
      login_token: login_token,
      login_user: login_user
    });
    
    if (saved_login_token !== login_token) {
      localStorage.setItem('login_token', login_token);
      localStorage.setItem('login_user', login_user);
    }
  },
		  
  logoutUser: () => {
    RouterContainer.get().transitionTo('/');
    localStorage.removeItem('login_token');
    localStorage.removeItem('login_user');
    AppDispatcher.dispatch({
      actionType: LOGOUT_USER
    });
  }
  
}