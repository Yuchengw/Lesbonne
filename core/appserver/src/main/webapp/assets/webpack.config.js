var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
	entry: 
	    getEntrySources(['./app/app.js']),
	output: {
//		publicPath: 'http://localhost:8081/',
    	path: path.resolve(__dirname, './build'),
    	filename: 'bundle.js',
	},
	externals: {
		'$': 'jQuery'
	},
	resolve: {
		root: [
		       path.resolve('../../../../node_modules'),
		       path.resolve('./')
		],
	},
	devtool: 'eval',
    module: {
        preLoaders: [
        ],
        loaders: [
            {   test: /bootstrap-sass\/assets\/javascripts\//, 
                  	loader: 'imports?jQuery=jquery' 
            },
            {
            	test: /\.js?$/,
                exclude: /(node_modules)/,
                loader: 'react-hot'
            },
            {
            	test: /\.js?$/,
                exclude: /(node_modules)/,
                loader: 'jsx'
            },
            {
            	test: /\.js?$/,
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                	presets: ['es2015','react']
                }
            },
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract('css!sass')
//                loaders: [
//                    'style',
//                    'css',
//                    'autoprefixer?browsers=last 3 versions',
//                    'sass?outputStyle=expanded'
//                ]
            },
            {
                test: /\.(jpe?g|png|gif|woff2?|svg)$/i,
                loaders: [
                    'url?limit=8192',
                    'img'
                ]
            },
            {  test: /\.(ttf|eot)$/, 
               loader: 'file' 
            }
        ]
    },
	plugins: [
	    new ExtractTextPlugin("./css/style.css")
	]
};

function getEntrySources(sources) {
    if (process.env.NODE_ENV !== 'production') {
    	sources.push('webpack/hot/only-dev-server');
    }
    return sources;
}
