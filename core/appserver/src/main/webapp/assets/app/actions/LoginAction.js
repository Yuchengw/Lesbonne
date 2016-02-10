/**
 * @author yucheng
 * @since 1
 */
import AppDispatcher from '../dispatchers/AppDispatcher.js';
import {LOGIN_USER, LOGOUT_USER} from '../constants/LoginConstants.js';
import RouterContainer from '../globla_services/RouterContainer'

export default {
  loginUser: (login_token) => {
    var saved_login_token = localStorage.getItem('login_token');
    
    AppDispatcher.dispatch({
      actionType: LOGIN_USER,
      login_token: login_token
    });
    
    if (saved_login_token !== login_token) {
      var nextPath = RouterContainer.get().getCurrentQuery().nextPath || '/';
      RouterContainer.get().transitionTo(nextPath);
      localStorage.setItem('login_token', login_token);
    }
  },
  logoutUser: () => {
    RouterContainer.get().transitionTo('/');
    localStorage.removeItem('login_token');
    AppDispatcher.dispatch({
      actionType: LOGOUT_USER
    });
  }
}