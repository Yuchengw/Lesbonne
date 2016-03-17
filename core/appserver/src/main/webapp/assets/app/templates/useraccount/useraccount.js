import React from'react';
import ReactDom from'react-dom';
import Header from'../common/header.js';

require('./useraccount.scss');

export default

class UserAccount extends React.Component {
	constructor(props) {
		super(props);
	}

	render() {
		return (
			<div className='container'>
			<Header />
				<section id='accountImageInfo'>
					<div className="userAccountImage">
						<img src="/as/app/templates/useraccount/images/useraccountimage.png"/>
					</div>
				</section>
				<section id='accountoptions'>
					<div className="imageprofile col-md-4">
					</div>
					<div className='options col-md-8'>
						<div className='Account'>
							<h3>Account</h3>
						</div>
						<div className='Orders'>
							<h3>Orders</h3>
						</div>
						<div className='Referral'>
							<h3>Referral</h3>
						</div>
					</div>
				</section>
			</div>
		);
	}
}