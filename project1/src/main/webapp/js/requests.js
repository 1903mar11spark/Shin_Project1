window.onload = function() {
    allUsers();
    allRequests();
    getingUser();
    myEmployees();
    
    let derping = document.getElementById("derping")
    derping.addEventListener("click",button);   
    
};


let users = [];
let requests = [];
let man = [];
let emp = [];
let me;

function button() {
    let workerId = document.getElementById("selectedEmployee").value;

    doIt(workerId);
}

function doIt (id) {
	console.log("Work!");
    let body = document.getElementById("requestBody");
    for (let i = 0; i < requests.length; i++) {
        if (id == requests[i].useId && requests[i].status == 1 ) {

            let newTr = document.createElement("tr");
		
            let newTh = document.createElement("th");
            newTh.setAttribute('scope', 'row');
            newTh.innerHTML = requests[i].reId
            let reqType = document.createElement("td");
            switch (requests[i].typeId) {
                case 1: reqType.innerHTML = "Traveling Expense";
                break;
                case 2: reqType.innerHTML = "Payment/Purchase/Misc.";
                break;
                case 3: reqType.innerHTML = "Medical";
                break;
                default: reqType.innerHTML = "HowWhatWhere???"
            }
            let status = document.createElement("td");
            status.innerHTML = "Pending";

            let description = document.createElement("td");
            description.innerHTML = requests[i].text;

            let radio = document.createElement("input");
            radio.setAttribute("class", "form-check-input");
            radio.setAttribute("type", "radio");
            radio.setAttribute("name", "reNumber");
            radio.setAttribute("value", requests[i].reId);
            
            newTr.appendChild(newTh);
            newTr.appendChild(reqType);
            newTr.appendChild(status);
            newTr.appendChild(description);
            newTr.appendChild(radio);

            body.appendChild(newTr);

        }
    }
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
            me = data.usrId;
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
            for (let i = 0; i < data.length; i++) {
                users.push(data[i]);

                switch(data[i].userTypeId) {
                    case 1 || 2: emp.push(data[i]);
                        break;
                    default: man.push(data[i]);
                }
            }
            allEmpAndMan();
		}
	});

	
}

function allRequests() {
	fetch("http://localhost:8084/project1/allRequests").then(function(response1){
		return response1.json();
	}).then(function(data2){
		if (data2.session === null) {
			window.location = "http://localhost:8084/project1/main";
		}
		else {

            for (let i = 0; i < data2.length; i++) {
                requests.push(data2[i]);
            }
          
		}
	});	
}

function allEmpAndMan() { 

    for (let i = 0 ; i < emp.length; i++) {
        if  (emp[i].managerId === 0) {
            let table1 = document.getElementById("employeeBody");
            let newTrw = document.createElement("tr");
    
            let newThd = document.createElement("th");
            newThd.setAttribute('scope', 'row');
            newThd.innerHTML = emp[i].usrId;
            
            let name1 = document.createElement("td");
            name1.innerHTML = emp[i].firstName + " " +  emp[i].lastName;
            
            
            
            let email1 = document.createElement("td");
            email1.innerHTML = emp[i].email;
            
            let manager1 = document.createElement("td");
            manager1.innerHTML = "No Manager Yet Assigned";
            
            newTrw.appendChild(newThd);
            newTrw.appendChild(name1);
            newTrw.appendChild(email1);
            newTrw.appendChild(manager1);
            table1.appendChild(newTrw);
        }
        for(let j = 0; j < man.length; j++){
            if(emp[i].managerId === man[j].usrId) {
                let table = document.getElementById("employeeBody");
                let newTr = document.createElement("tr");
		
				let newTh = document.createElement("th");
				newTh.setAttribute('scope', 'row');
                newTh.innerHTML = emp[i].usrId;
                
                let name = document.createElement("td");
                name.innerHTML = emp[i].firstName + " " +  emp[i].lastName;
				
				
				
				let email = document.createElement("td");
                email.innerHTML = emp[i].email;
                
                let manager = document.createElement("td");
				manager.innerHTML = man[j].firstName + " " + man[j].lastName;
				
				newTr.appendChild(newTh);
				newTr.appendChild(name);
                newTr.appendChild(email);
                newTr.appendChild(manager);
                table.appendChild(newTr);

            }
           
                
        }
        
    }
    myEmployees();
} 

function myEmployees() {
    
    let place = document.getElementById("selectedEmployee");
    for(let j = 0 ; j < users.length; j++) {

        if(me == users[j].managerId ) {
            let option = document.createElement("option");
            option.setAttribute("value", users[j].usrId );
            option.innerHTML = users[j].firstName + " " +users[j].lastName;

            place.appendChild(option);

        }
    }

}
