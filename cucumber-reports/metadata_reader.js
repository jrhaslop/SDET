var fs = require('fs')
var path = require('path');
var appVersion = "";
var testEnvironment = "";
var urlAmbiente = "";
var browserVersion = "";
var plattform = "";
var feature = "";

var filePath = path.join(__dirname, '../..').concat('\\Reports\\temp.txt');
var array;

exports.getFile = function(filePath, success) {

	fs.readFile(filePath, 'utf8', function(err, data) {
		if (err)
			throw err;
		array = data.split("\n");

		appVersion = array[0];
		testEnvironment = array[1];
		urlAmbiente = array[2];
		browserVersion = array[3];
		plattform = array[4];
		feature = array[5];
		if (success)
			success();
	});

}

exports.urlAmbiente = function() {
	return urlAmbiente;
};

exports.ambiente = function() {
	return testEnvironment;
};

exports.browser = function() {
	return browserVersion;
};

exports.appVersion = function() {
	return appVersion;
};

exports.sistemaOperativo = function() {
	return plattform;
};

exports.feature = function() {
	return feature;
};