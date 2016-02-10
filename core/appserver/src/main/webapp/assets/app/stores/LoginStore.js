/**
 * @author yucheng
 * @since 1
 */

import {LOGIN_USER, LOGOUT_USER} from '../constants/LoginConstants';
import BaseStore from './BaseStore.js';

class LoginStore extends BaseStore {

  constructor() {
    super();
    this.subscribe(() => this._registerToActions.bind(this))
    this._user = null;
    this._login_token = null;
  }

  _registerToActions(action) {
    switch(action.actionType) {
      case LOGIN_USER:
        this._login_token = action.login_token;
        this._user = action.login_user;
        this.emitChange();
        break;
      case LOGOUT_USER:
        this._user = null;
        this.emitChange();
        break;
      default:
        break;
    };
  }

  get user() {
    return this._user;
  }

  get loginToken() {
    return this._login_token;
  }

  isLoggedIn() {
    return !!this._user;
  }
}

export default new LoginStore();