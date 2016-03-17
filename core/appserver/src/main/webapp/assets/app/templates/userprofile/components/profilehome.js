/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDom from 'react-dom';
import AuthenticatedComponent from '../../../global/components/AuthenticatedComponent.js'

export default AuthenticatedComponent(class ProfileHome extends React.Component {
	constructor(props) {
		super(props);
	}
	
	render() {
		return (
			<div className='container'>
				<section id='profilehome'>
					<div className='profileheader'>
						<h2>Finish Your Profile</h2>
					</div>
				</section>
				<section id='profilesocial'>
					<div className="profileSocial">
						
					</div>
				</section>
				<section id='profileinfo'>
					<form className="form-horizontal profileInfoForm" role="form">
			          <div className="form-group">
			            <div className="col-md-12">
			              <label htmlFor="username">Your Name</label>
			              <input type="text" className="form-control" id="username" ref="username">
			              </input>
			            </div>
			          </div>
			          <div className="form-group">
			            <div className="col-md-12">
			              <label htmlFor="userlocation">Location</label>
			              <input type="text" className="form-control" id='location' ref='email'>
			              </input>
			            </div>
			          </div>
			          <div className="form-group">
			            <div className="col-md-12">
			              <label htmlFor="shortbio">SHort Bio</Label>
			              <input type="text" className="form-control" id='shortBio' ref='shortBio'>
			              </input>
			            </div>
			          </div>
			        </form>
				</section>
			</div>
		);
	}	
});
