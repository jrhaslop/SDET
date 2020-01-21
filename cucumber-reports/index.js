var reporter = require('cucumber-html-reporter');
var moment = require('moment');
var date = moment().format("YYYYMMDD-HH_mm_ss");
var fs = require('fs')
var path = require('path');
var metadata = require('./metadata_reader.js')

var filePath = path.join(__dirname, '../..').
			concat('\\com.jonathanhaslop.sdet\\Reports\\temp.txt');

metadata.getFile(filePath, function() {
	var options = {
		theme : 'bootstrap', // Available: ['bootstrap', 'hierarchy',
								// 'foundation', 'simple'] Type: String
		jsonFile : path.join(__dirname, '../..')
			.concat('\\com.jonathanhaslop.sdet\\Reports\\cucumber.json'),output : path.join(__dirname, '../..')
			.concat('\\com.jonathanhaslop.sdet\\Reports\\').concat(date)
			.concat('\\com.jonathanhaslop.sdet\\cucumber_report.html'),
			brandTitle : 'SDET TEST',
			reportSuiteAsScenarios : true,
			launchReport : true,
			storeScreenshots : true,
			// screenshotsDirectory: 'Reports/screenshot/', // to send screenshots to another path
		
		metadata : {
			"App Version" : 			metadata.appVersion(),
			"Test Environment" : 		metadata.ambiente(),
			"Test Environment url" : 	metadata.urlAmbiente(),
			"Browser" : 				metadata.browser(),
			"Platform" : 				metadata.sistemaOperativo(),
			"Date" : 					moment().format("YYYY-MM-DD"),
			"Time" : 					moment().format("HH:mm:ss"),
			"Parallel" : 				"Scenarios",
			"Executed" : 				"Local"
		}
	};
	reporter.generate(options);
});