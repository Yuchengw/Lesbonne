/**
 * @author yucheng
 * @since 1
 */

import React from 'react';
import ReactDom from 'react-dom';

class EditProfile extends React.Component {
	constructor(props, context) {
		super(props);
	}
	
	render() {
		return (
				<section id='editprofile'>
					<div className='col-md-5'>
						<img src='/as/app/templates/useraccount/images/editprofileimage.png'/>
					</div>
					<div className='col-md-7'>
						<h3>Edit Profile</h3>
						<h5>Update your Name, Phone Number, Email</h5>
						<img className="img-circle" src="http://placehold.it/10x10"/>
						<a>Upload Image...</a>
						<div className="form-group">
				            <div className="col-md-12">
				              <input type="text" className="form-control" id="username" ref="username" placeholder="Your Full Name">
				              </input>
				            </div>
				        </div>
				        <div className="form-group">
				            <div className="col-md-12">
				              <input type="email" className="form-control" id='email' ref='email' placeholder="Email">
				              </input>
				            </div>
				        </div>
				        <div className="form-group">
				            <div className="col-md-12">
				              <input type="password" className="form-control" id='password' ref='password' placeholder="Password">
				              </input>
				            </div>
				        </div>
					</div>
		        </section>
		);
	}
	
}

export default EditProfile;
