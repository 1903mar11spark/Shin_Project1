

window.onload = function() {
	allRequests();
	allUsers();
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
			let admins = document.getElementById("dropDown");
			switch (data.userTypeId) {
			
			case 1: message.innerHTML = "Welcome Grunt Number " + data.usrId;
				break;
			case 2: message.innerHTML = "Welcome Admin " + data.firstName;
					let newDropDown1 = document.createElement("a");
					newDropDown1.setAttribute('href', '');
					newDropDown1.innerHTML = "All Employee Pending"; 
					let newDropDown2 = document.createElement("a");
					newDropDown2.setAttribute('href', '');
					newDropDown2.innerHTML = "Employee Requests"; 
					let newDropDown3 = document.createElement("a");
					newDropDown3.setAttribute('href', '');
					newDropDown3.innerHTML = "All Resolved"; 
					let newDropDown4 = document.createElement("a");
					newDropDown4.setAttribute('href', 'employees');
					newDropDown4.innerHTML = "Employees"; 

					admins.appendChild(newDropDown1);
					admins.appendChild(newDropDown2);
					admins.appendChild(newDropDown3);
					admins.appendChild(newDropDown4);

				break;
			case 3: message.innerHTML = "Welcome Master " + data.firstName;
					let newDropDown11 = document.createElement("a");
					newDropDown11.setAttribute('href', '');
					newDropDown11.innerHTML = "All Employee Pending"; 
					let newDropDown21 = document.createElement("a");
					newDropDown21.setAttribute('href', '');
					newDropDown21.innerHTML = "Employee Requests"; 
					let newDropDown31 = document.createElement("a");
					newDropDown31.setAttribute('href', '');
					newDropDown31.innerHTML = "All Resolved"; 
					let newDropDown41 = document.createElement("a");
					newDropDown41.setAttribute('href', './employees');
					newDropDown41.innerHTML = "Employees"; 

					admins.appendChild(newDropDown11);
					admins.appendChild(newDropDown21);
					admins.appendChild(newDropDown31);
					admins.appendChild(newDropDown41);
				break;
				default: message.innerHTML = "Hello Random Stranger";
			}

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
					case 2 || 3: let n = document.getElementById("resolvedBody");
							n.appendChild(newTr);
					break;
				}
			}

		}
	});
}

function allUsers() {
	fetch("http://localhost:8084/project1/allUsers").then(function(response){
		return response.json();
	}).then(function(data){
		if (data.session === null) {
			window.location = "http://localhost:8084/project1/main";
		}
		else {
			console.log(data);
		}
	});

	
}

function allRequests() {
	fetch("http://localhost:8084/project1/allRequests").then(function(response){
		return response.json();
	}).then(function(data){
		if (data.session === null) {
			window.location = "http://localhost:8084/project1/main";
		}
		else {
			console.log(data);
		}
	});

	
}
