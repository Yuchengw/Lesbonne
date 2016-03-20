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
	
	updateprofile() {
		
	}
	
	render() {
		return (
				<section id='editprofile'>
					<div className='col-md-5'>
						<img className='leftimage' src='/as/app/templates/useraccount/images/editprofileimage.png'/>
					</div>
					<div className='col-md-7'>
						<h2>Edit Profile</h2>
						<h4>Update your Name, Phone Number, Email</h4>
						<img className='profileimage img-circle' src="http://placehold.it/10x10"/>
						<a className='profileuploadimage'>Upload Image...</a>
						<div className='editprofileform'>
							<div className="form-group">
					            <div className="col-md-12">
					              <label htmlFor='username'>Name</label>
					              <input type="text" className="form-control" id="username" ref="username" placeholder="Your Full Name">
					              </input>
					            </div>
					        </div>
					        <div className="form-group">
					            <div className="col-md-12">
					            	<label htmlFor="phonenumber">Phone Number</label>
					              <input type="text" className="form-control" id='email' ref='phonenumber' placeholder="Phone Number">
					              </input>
					            </div>
					        </div>
					        <div className="form-group">
					            <div className="col-md-12">
					              <label htmlFor='email'>Email</label>
					              <input type="email" className="form-control" id='password' ref='email' placeholder="Email">
					              </input>
					            </div>
					        </div>
				            <div className="form-group">
				              <div className="col-md-12">
				                <input type="submit" onClick={this.updateprofile.bind(this)} className="editprofilebutton btn btn-primary btn-lg btn-block" value="Confirm Profile">
				                </input>
				              </div>
				            </div>
				        </div>
					</div>
		        </section>
		);
	}
	
}

export default EditProfile;
