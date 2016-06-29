function openPlaystoreApplication(){
	this.openPlaystoreApp = function(application_package_name){
		alert("About to call");
		cordova.exec(function(){},function(){},"playstore","openPlaystoreApp",[application_package_name]);
	}
}

if(!window.plugins) {
	window.plugins = {}
}


window.plugins.google = new openPlaystoreApplication();
