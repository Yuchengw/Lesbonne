import React from 'react';

var LesbonneSearch = {}

/**Twitter typeahead javascript**/
var SearchBox = React.createClass({
    mixins : [RouterMixin],
    search : function(keyword) {
        this.props.router.navigate("search/"+this.props.activeTab+"/"+keyword, {
            trigger : true
        });
    },
    onEnter: function(event) {
        //each time the user hits enter, send a search request
        if (event.keyCode===13 && event.target.value.length>0) {
            var keyword = event.target.value;
            this.search(keyword);
        }
    },
    onSelected: function(event, data) {
        var keyword = data.title;
        this.search(keyword);
    },
    initTypeAhead: function() {
        var el = $(this.refs.searchInput.getDOMNode());
        el.typeahead('destroy');
        if (this.props.activeTab==='question') {
            el.typeahead({
                    hint: true,
                    highlight: true,
                    minLength: 1
                },
                {
                    name: 'questions',
                    displayKey: 'title',
                    source: this.props.questions.ttAdapter()
                }).on('typeahead:selected', this.onSelected);
            this.refs.searchInput.getDOMNode().placeholder="Enter question here...";
        } else {
            el.typeahead({
                    hint: true,
                    highlight: true,
                    minLength: 1
                },
                {
                    name: 'companies',
                    displayKey: 'title',
                    source:  this.props.companies.ttAdapter(),
                    templates: {
                        suggestion: _.template('<span class="tt-suggestion-company"> <%= title %></span><img class="company-logo" src="assets/img/logo/<%= logo %>" alt="<%=title%>"></img>')
                    }
                }).on('typeahead:selected', this.onSelected);
            this.refs.searchInput.getDOMNode().placeholder="Enter company here...";
        }

        el.keypress(this.onEnter);

    },
    componentDidMount: function() {
        this.props.questions = new Bloodhound({
            datumTokenizer: function(d) {return Bloodhound.tokenizers.whitespace(d.title.replace(/[^\w\s]|_/g, " "));},
            queryTokenizer: Bloodhound.tokenizers.whitespace,
            prefetch: {
                ttl: 1,
                url: "/autocomplete/question",
                filter: function (list) {
                    return $.map(list, function (question) {
                        return {id:question.id, title:question.title, type: "question"};});
                }
            }
        });

        this.props.companies = new Bloodhound({
            datumTokenizer: function(d) {return Bloodhound.tokenizers.whitespace(d.title.replace(/[^\w\s]|_/g, " "));},
            queryTokenizer: Bloodhound.tokenizers.whitespace,
            prefetch: {
                ttl: 1,
                url: "/autocomplete/company",
                filter: function (list) {
                    return $.map(list, function (company) {
                        return {id:company.id, title:company.name, logo:company.logo_url, type: "company"};});
                }
            }
        });
        this.props.questions.initialize();
        this.props.companies.initialize();
        this.initTypeAhead();
    },
    componentDidUpdate : function() {
        this.initTypeAhead();
    },

    /*componentWillUnmount: function(){
        var el = $(this.refs.searchQuestionInput.getDOMNode());
        $(el).typeahead('destroy');
    },*/

    render: function(){
        return (
        <form className="search-form" role="form">
        <input ref="searchInput" id="search-input" type="text" className="form-control" placeholder=""/>
        </form>
        );
    }
});

//initialize google maps, center marker, and spider markers
SFMovie.initGoogleMaps = function(latitude, longitude) {
	SFMovie.map = new google.maps.Map(document.getElementById("map-canvas"), {
							center : new google.maps.LatLng(latitude,longitude),
	      					zoom: 16});

	SFMovie.centerMarker = new google.maps.Marker({
        			map:SFMovie.map,
        			draggable:false,
        			animation: google.maps.Animation.DROP,
        			title: "My Location",
        			position: new google.maps.LatLng(latitude,longitude),
        			icon: {
							url: 'img/pin.png',
    	    				size: new google.maps.Size(SFMovie.config.mediumCompressedImageSize, SFMovie.config.mediumCompressedImageSize),
    	    				scaledSize: new google.maps.Size(SFMovie.config.mediumCompressedImageSize, SFMovie.config.mediumCompressedImageSize)
					}
	});

	SFMovie.markers.push(SFMovie.centerMarker);

	SFMovie.geocoder = new google.maps.Geocoder();

	SFMovie.overlappingMarkerSpider = new OverlappingMarkerSpiderfier(SFMovie.map, {markersWontMove: true, markersWontHide: true});

	SFMovie.overlappingInfoWindow = new google.maps.InfoWindow();

	SFMovie.overlappingMarkerSpider.addListener('click', function(marker, event) {
		SFMovie.overlappingInfoWindow.setContent(marker.desc);
  		SFMovie.overlappingInfoWindow.open(SFMovie.map, marker);
	});

	SFMovie.overlappingMarkerSpider.addListener('spiderfy', function(markers) {
  		$.each(markers, function(index,marker){
  			marker.setIcon(SFMovie.singleLocationIcon);
  		});

  		SFMovie.overlappingInfoWindow.close();
	});

	SFMovie.overlappingMarkerSpider.addListener('unspiderfy', function(markers) {
  		$.each(markers, function(index,marker){
  			marker.setIcon(SFMovie.multiLocationIcon);
  		});
	});
};

SFMovie.createMarker = function(movie, isSingleLocation) {
	var position = new google.maps.LatLng(movie.latitude, movie.longitude);

	var icon = isSingleLocation ? SFMovie.singleLocationIcon : SFMovie.multiLocationIcon

	var marker = new google.maps.Marker({
        map:SFMovie.map,
        draggable:false,
        animation: google.maps.Animation.DROP,
        position: position,
        title: movie.title,
        icon: icon,
        desc:  _.template($('#movie-info-window-template').html(), movie)
     });

	return marker;
};

//init method to start the app
LesbonneSearch.initLesbonneSearch = function() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(SFMovie.initLocation);
    } else { 
        alert("Geolocation is not supported by this browser.");
    }
};

//callback after getting browser location
LesbonneSearch.initLocation = function(position) {
	SFMovie.initGoogleMaps(position.coords.latitude,position.coords.longitude);
    searchMovieView.render();
	nearbyMovieView.render({latitude: position.coords.latitude, longitude: position.coords.longitude});
};

LesbonneSearch.initLesbonneSearch()