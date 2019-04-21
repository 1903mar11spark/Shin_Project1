

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
			for (let i = 0 ; i < data.length; i ++) {
				let newTr = document.createElement("tr");
		
				let newTh = document.createElement("th");
				newTh.setAttribute('scope', 'row');
				newTh.innerHTML = data[i].reId
				let reqType = document.createElement("td");
				switch (data[i].typeId) {
					case 1: reqType.innerHTML = "Traveling Expense";
					break;
					case 2: reqType.innerHTML = "Payment/Purchase/Misc.";
					break;
					case 3: reqType.innerHTML = "Medical";
					break;
					default: reqType.innerHTML = "HowWhatWhere???"
				}
				
				let description = document.createElement("td");
				description.innerHTML = data[i].text;
				
				newTr.appendChild(newTh);
				newTr.appendChild(reqType);
				newTr.appendChild(description);

				switch (data[i].status) {
					case 1: let m = document.getElementById("pendingBody");
							m.appendChild(newTr);
					break;
					case 2: let n = document.getElementById("resolvedBody");
							n.appendChild(newTr);
					break;
				}
			}

		}
	});
}