/**
 * @author yucheng
 * @since 1
 */

import AuthService from '../global_services/AuthService';
import RouterContainer from '../global_services/RouterContainer';

export default {

  login: (user) => {
    console.log("login");
  },

  loginSucceeded: () => {
    RouterContainer.get().transitionTo('/');
    console.log("loginSucceeded");
  },

  loginFailed: () => {
    console.log("loginFailed");
  },

  logout: () => {
    console.log("logout");
  },

  logoutSucceeded: () => {
    RouterContainer.get().transitionTo('/login', {});
    console.log("logoutSucceeded");
  },

  logoutFailed: () => {
    console.log("logoutFailed");
  },

  signup: () => {
    console.log("signup");
  },

  signupSucceeded: () => {
    RouterContainer.get().transitionTo('/');
    console.log("signupSucceeded");
  },

  signupFailed: () => {
    RouterContainer.get().transitionTo('/signup', {});
    console.log("signupFailed");
  }

}
