/**
 * @author Yucheng
 * @since 1
 */
import LoginActions from '../actions/LoginActions.js';

class AuthService {
  login(user) {
	return when(request({
		url: 'http://localhost:8091/service/user/login',
		method: 'POST',
		crossOrigin: true,
		type: 'json',
		data: {
			user.name, user.password
		}
	}))
	.then(function(response){
		let login_cookie = reponse.login_token;
		LoginActions.loginUser(login_cookie);
	});
  }

  logout() {
    AuthActions.logout();
  }

  signup(user) {
    AuthActions.signup();
  }
}

export default new AuthService()
