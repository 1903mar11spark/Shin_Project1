

window.onload = function() {
	getingUser();
	getRequests();
}

function getingUser() {
	//send GET request to SessionServlet to obtain session information
	fetch("http://localhost:8084/project1/holder").then(function(response) {
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			window.location = "http://localhost:8084/project1/main";
		} 
		else {
			console.log(data);
			let message = document.getElementById("welcome");
			switch (data.userTypeId) {
			
			case 1: message.innerHTML = "Welcome Grunt Number " + data.usrId;
				break;
			case 2: message.innerHTML = "Welcome Admin " + data.firstName;
				break;
			case 3: message.innerHTML = "Welcome Master " + data.firstName;
				break;
				default: message.innerHTML = "Hello Random Stranger";
			}
		console.log(data);
		console.log(data.firstName);
		console.log(data.lastName);
		}
	});
}

function getRequests() {
	fetch("http://localhost:8084/project1/holdingRe").then(function(response) {
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			window.location = "http://localhost:8084/project1/main";
		} 
		else {
			console.log(data);

		}
	});
}