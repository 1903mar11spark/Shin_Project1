window.onload = function() {
	gettingUserInfo();
}

function gettingUserInfo() {
    	//send GET request to SessionServlet to obtain session information
	fetch("http://localhost:8084/project1/holder").then(function(response) {
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			window.location = "http://localhost:8084/project1/main";
		} 
		else {
            let place = document.getElementById("assets");
            let usersName = document.createElement("li");
            let email = document.createElement("li");
            
            usersName.innerHTML = "Name: " + data.firstName + " " + data.lastName;
            email.innerHTML = "Email: " + data.email;

            place.appendChild(usersName);
            place.appendChild(email);

		}
	});
}