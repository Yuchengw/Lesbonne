/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDom from 'react-dom';
import DropdownButton from 'react-bootstrap/lib/DropdownButton';
import MenuItem from 'react-bootstrap/lib/MenuItem';

export default class Footer extends React.Component {
	constructor(props) {
		super(props);
	}
	
	render() {
		return(
			<section id="homepage-footer">
				<div className="col-md-1">
					<a>About</a>
				</div>
				<div className="col-md-2">
					<a>How it works</a>
				</div>
				<div className="col-md-1">
					<a>Be a Host</a>
				</div>
				<div className="col-md-1">
					<a>Press</a>
				</div>
				<div className="col-md-2">
					<a>Terms of Service</a>
				</div>
				<div className="col-md-2">
					<a>Privacy Policy</a>
				</div>
				<div className="col-md-1">
					<a>Help</a>
				</div>
				<div className="col-md-2">
					<div className="language">
						<DropdownButton title="English">
							<MenuItem eventKey="1">Chinese</MenuItem>
							<MenuItem eventKey="2">Spanish</MenuItem>
						</DropdownButton>
					</div>
				</div>
			</section>
		);
	}
}