/**
 * @author Yucheng
 * @since 1
 */
import AuthActions from '../actions/AuthActions';

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