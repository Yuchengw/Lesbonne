/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDom from 'react-dom';

import Header from '../common/header.js'; 
import ProfileHome from './components/profilehome.js';

require('./userprofile.scss');

export default class UserProfile extends React.Component {
	render() {
		return  (
			<div className="container">
				<Header />
				<ProfileHome />
			</div>
		);
	}
}
