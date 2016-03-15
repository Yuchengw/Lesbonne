/**
 * @author: yucheng
 * @since 1
 * */
import React from 'react';
import HomePage from './templates/homepage/homepage.js';
import ExploreFood from './templates/explorefood/explore.js';

require('../scss/app.scss');

export default class App extends React.Component {	
  render() {
    return (
    	<HomePage />
    );
  }
};
