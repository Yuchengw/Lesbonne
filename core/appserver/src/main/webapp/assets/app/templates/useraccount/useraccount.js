import React from'react';
import ReactDom from'react-dom';
import Header from'../common/header.js';
import AuthenticatedComponent from '../../global/components/AuthenticatedComponent.js';
import { Link } from 'react-router';

require('./useraccount.scss');

class UserAccount extends React.Component {
	constructor(props, context) {
		super(props, context);
	}

	render() {
		let accountOptions = "";
		if (this.props.userLoggedIn) {
			let firstname = this.props.user.split(" ")[0];
			accountOptions = <section id='accountoptions'>
								<div className='imageprofile col-md-4'>
									<img className="profileimage img-circle" src="http://placehold.it/20x20"/>
									<h3>Hello { firstname }!</h3>
									<Link className='link' to='/editprofile'>Edit</Link>
								</div>
								<div className='options col-md-8'>
									<div className='Account'>
										<h3>Account</h3>
										<ul className='col-md-6'>
											<li><Link className='link' to='/editprofile'>Edit Profile</Link></li>
											<li><Link className='link' to='/changepassword'>Change Password</Link></li>
											<li><Link className='link' to='/notificationpreference'>Notification Preferences</Link></li>
										</ul>
										<ul className='col-md-6'>
											<li><Link className='link' to='/managepayment'>Manage Payment Methods</Link></li>
											<li><Link className='link' to='/manageaddress'>Manage Address Book</Link></li>
											<li><Link className='link' to='/foodpreference'>Food Preferences</Link></li>
										</ul>
									</div>
									<div className='Orders'>
										<h3>Orders</h3>
										<ul className='col-md-6'>
											<li><Link className='link' to='/orderhistory'>Order History</Link></li>
											<li><Link className='link' to='/reviewhistory'>Review History</Link></li>
										</ul>
										<ul className='col-md-6'>
											<li><Link className='link' to='/writereview'>Write Reviews</Link></li>
										</ul>
									</div>
									<div className='Referral'>
										<h3>Referral</h3>
										<ul className='col-md-6'>
											<li><Link className='link' to='/referralhistory'>Referral History</Link></li>
										</ul>
										<ul className='col-md-6'>
											<li><Link className='link' to='invitefriends'>Invite More Friends</Link></li>
										</ul>
									</div>
								</div>
							</section>
		}
		return (
			<div className='container'>
			<Header />
				<section id='accountImageInfo'>
					<div className="userAccountImage">
						<img src="/as/app/templates/useraccount/images/useraccountimage.png"/>
					</div>
				</section>
				{ accountOptions }
			</div>
		);
	}
}

UserAccount.contextTypes = {
	router: React.PropTypes.func.isRequired
}

export default AuthenticatedComponent(UserAccount);