/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import AuthenticatedComponent from '../../global_components/AuthenticatedComponent.js'

export default AuthenticatedComponent(class Dashboard extends React.Component {
  render() {
    return (<h1>Hello {this.props.user ? this.props.user.username : ''}, this is Dashboard page</h1>);
  }
});
