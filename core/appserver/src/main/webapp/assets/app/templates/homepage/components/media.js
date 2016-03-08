/**
 * @author yucheng
 * @since 1
 */

import React from 'react';
import ReactDom from 'react-dom';

export default class Media extends React.Component {
	render() {
		return(
			<section className="medias">
				<div className="container">
					<div className="col-md-3">
						<img src="/as/app/templates/homepage/images/techcrunch.png"/>
					</div>
					<div className="col-md-3">
						<img src="/as/app/templates/homepage/images/businessinsider.png"/>
					</div>
					<div className="col-md-3">
						<img src="/as/app/templates/homepage/images/producthunt.png"/>	
					</div>
					<div className="col-md-3">
						<img src="/as/app/templates/homepage/images/wired.png"/>
					</div>
				</div>
			</section>
		);
	}
}