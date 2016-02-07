/**
 * @author Yucheng
 * @since 1
 */
import AuthActions from '../actions/auth_actions.js';

class AuthService {

  login(user) {
    AuthActions.login();
    //TODO: api call
  }

  logout() {
    AuthActions.logout();
   //TODO: api call
  }

  signup(user) {
    AuthActions.signup();
    //TODO: api call
  }
}

export default new AuthService()
