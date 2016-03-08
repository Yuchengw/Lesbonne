/**
 * @author yucheng
 * @since 1
 */

import {LOGIN_USER, LOGOUT_USER} from './LoginConstants';
import BaseStore from '../../../global/store/BaseStore.js';

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

  getUser() {
    return this._user;
  }

  getloginToken() {
    return this._login_token;
  }

  isLoggedIn() {
    return !!this._user;
  }
}

export default new LoginStore();