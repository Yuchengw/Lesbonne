/**
 * @author yucheng
 * @since 1
 */
import React from 'react';
import ReactDOM from 'react-dom';
import SearchBox from './searchbox.js';

export default class SearchContainer extends React.Component {
	render() {
		return (
		    <section className="homepage-search">
		      <div className="container">
		        <SearchBox />
		        <div className="row">
		        <div className="col-md-12 col-md-offset-1">
		        <div className="homepage-showcase">
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">
		                My favorite Shrimp Pasta Fillet Bake with
		              </span>
		              <span className="price">10</span>
		            </div>
		            <img src="/as/scss/images/showcase-1.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-1.png"/>
		              <div className="profile-name">
		                <span className="name">Bobby Coleman</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">
		                All Organic Sarah Salad
		              </span>
		              <span className="price">8</span>
		            </div>
		            <img src="/as/scss/images/showcase-2.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-2.png"/>
		              <div className="profile-name">
		                <span className="name">Kate Lisowska</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">Mushroom Salmon Pasta</span>
		              <span className="price">8</span>
		            </div>
		            <img src="/as/scss/images/showcase-3.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-3.png"/>
		              <div className="profile-name">
		                <span className="name">Julia Burke</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">Golden Mushroom Corn Soup</span>
		              <span className="price">6</span>
		            </div>
		            <img src="/as/scss/images/showcase-4.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-4.png"/>
		              <div className="profile-name">
		                <span className="name">Megan George</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">My favorite Shrimp Pasta</span>
		              <span className="price">6</span>
		            </div>
		            <img src="/as/scss/images/showcase-5.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-5.png"/>
		              <div className="profile-name">
		                <span className="name">Alexander Walters</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">Curry Bean Sprout Noodle</span>
		              <span className="price">12</span>
		            </div>
		            <img src="/as/scss/images/showcase-6.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-6.png"/>
		              <div className="profile-name">
		                <span className="name">Jason Lee</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">Japanese Tonkosu Ramen</span>
		              <span className="price">6</span>
		            </div>
		            <img src="/as/scss/images/showcase-7.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-7.png"/>
		              <div className="profile-name">
		                <span className="name">Megan George</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">Party Chicken Burger</span>
		              <span className="price">7.5</span>
		            </div>
		            <img src="/as/scss/images/showcase-8.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-8.png"/>
		              <div className="profile-name">
		                <span className="name">Alexander Walters</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		          <div className="showcase-item">
		            <div className="showcase-header">
		              <span className="dish-name">Handmade Sashimi</span>
		              <span className="price">15</span>
		            </div>
		            <img src="/as/scss/images/showcase-9.png" />
		            <div className="showcase-bottom">
		              <img className="profile-img" src="/as/scss/images/profile-9.png"/>
		              <div className="profile-name">
		                <span className="name">Ashwin Bhatttacharjee</span>
		                <br/>
		                <span className="area">SOMA, San Francisco</span>
		              </div>
		              <div className="like">
		                <span>763</span>
		              </div>
		            </div>
		          </div>
		        </div>
		        </div>
		        </div>
		        <div className="row">
		        <div className="col-md-12 col-md-offset-4">
		        <div className="explore">
	          		<a className="btn btn-success btn-lg">Explore 99+ HOME FOOD NEAR YOU</a>
	          	</div>
	          	</div>
	          	</div>
		      </div>		      
		    </section>
		);
	}
}
