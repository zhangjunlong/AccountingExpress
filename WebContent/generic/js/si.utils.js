/**
 * SI Utilities
 * 
 * @author Zhang Junlong
 * @requires JQuery
 * 
 * Copyright 2012, Smart Interactive Microsystems
 */
var si = si ? si : {};
si.utils = si.utils ? si.utils : {};

si.utils.user = si.utils.user ? si.utils.user :  {
	id : null,
	uname : null,
	name : null,
};

si.utils.url =  si.utils.url ? si.utils.url : {
	ajaxCache : false,

	getParameter : function(paramName) {
		var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	},

	round : function(number, bit) {
		return Math.round(number * Math.pow(10, bit)) / Math.pow(10, bit);
	},

	targetCompute : function(actual, target, bit) {
		return distance = this.round(target - actual, bit);
	}
};