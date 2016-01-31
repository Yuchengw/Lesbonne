import ReactDom from 'react-dom';
import React from 'react';
import App from '../app/app.js';

require('bootstrap-loader');

ReactDom.render(<App/>, document.getElementById('app'));