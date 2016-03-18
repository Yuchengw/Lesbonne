/**
 * @author yucheng
 * @since 1
 * */

import React from'react';
import ReactDOM from'react-dom';
import Header from'../common/header.js';
import AuthenticatedComponent from '../../global/components/AuthenticatedComponent.js';
import Modal from 'react-bootstrap/lib/Modal';
import EditProfile from './components/editprofile.js';
import EditPayment from './components/editpayment.js';

import { Link } from 'react-router';

require('./useraccount.scss');

class UserAccount extends React.Component {
	constructor(props, context) {
		super(props, context);
		this.state = {
			showEditProfile: false,
			showEditPayment: false
		};
	}

    showEditProfileModal() {
        this.setState({showEditProfile: true});
    }

    showEditPayment() {
    	this.setState({showEditPayment: true});
    }
    
    hideModal() {
        this.setState({
	        	showEditProfile: false,
	        	showEditPayment: false
        	});
    }

	render() {
		let accountOptions = "";
		if (this.props.userLoggedIn) {
			let firstname = this.props.user.split(" ")[0];
			accountOptions = <section id='accountoptions'>
								<div className='imageprofile col-md-4'>
									<img className="profileimage img-circle" src="http://placehold.it/20x20"/>
									<h3>Hello { firstname }!</h3>
									<a className='link' onClick={this.showEditProfileModal.bind(this)}>Edit</a>
									<Modal
							          {...this.props}
							          show={this.state.showEditProfile}
							          onHide={this.hideModal.bind(this)}
							          dialogClassName='editprofilemodal' bsSize='large'>
							          <Modal.Body className='editprofilemodalbody'>
							              <EditProfile />
							          </Modal.Body>
							          <Modal.Footer className='editprofilemodalfooter'>
							            <a className='editprofileclose' onClick={this.hideModal.bind(this)}>Close</a>
							          </Modal.Footer>
							        </Modal>
								</div>
								<div className='options col-md-8'>
									<div className='Account'>
										<h3>Account</h3>
										<ul className='col-md-6'>
											<li><a className='link' onClick={this.showEditProfileModal.bind(this)}>Edit Profile</a></li>
											<li><Link className='link' to='/changepassword'>Change Password</Link></li>
											<li><Link className='link' to='/notificationpreference'>Notification Preferences</Link></li>
										</ul>
										<ul className='col-md-6'>
											<li><a className='link' onClick={this.showEditPayment.bind(this)}>Manage Payment Methods</a>
												<Modal
										          {...this.props}
										          show={this.state.showEditPayment}
										          onHide={this.hideModal.bind(this)}
										          dialogClassName="custom-modal">
										          <Modal.Body>
										              <EditPayment />
										          </Modal.Body>
										          <Modal.Footer>
										            <a className='editprofileclose' onClick={this.hideModal.bind(this)}>Close</a>
										          </Modal.Footer>
										        </Modal>
											</li>
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