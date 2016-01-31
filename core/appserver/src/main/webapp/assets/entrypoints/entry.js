let React = require('react');
let ReactDom = require('react-dom')
let App = require('../app/app.js');
require('bootstrap-loader');

ReactDom.render(<App/>, document.getElementById('app'));