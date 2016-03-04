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
					<div className="media">
						<img src="/app/templates/homepage/images/techcrunch.png"/>
					</div>
					<div className="media">
						<img src="/app/templates/homepage/images/techcrunch.png"/>
					</div>
					<div className="media">
						<img src="/app/templates/homepage/images/techcrunch.png"/>	
					</div>
					<div className="media">
						<img src="/app/templates/homepage/images/techcrunch.png"/>
					</div>
				</div>
			</section>
		);
	}
}