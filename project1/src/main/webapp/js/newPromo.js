window.onload = function() {
    allUsers();
    getingUser();
};


let users = [];
let requests = [];
let man = [];
let emp = [];
let me;



function getingUser() {
    //send GET request to SessionServlet to obtain session information
    fetch("http://localhost:8084/project1/holder").then(function(response) {
        return response.json();
    }).then(function(data) {
        if (data.session === null) {
            window.location = "http://localhost:8084/project1/main";
        } 
        else {
            me = data.userTypeId;
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
                    case 1: emp.push(data[i]);
                        break;
                    case 2: man.push(data[i]); 
                         break;
                    case 3: man.push(data[i]); 
                    default:
                }
            }
            allEmpAndMan();
        }
	});

	
}

function allEmpAndMan() { 
    console.log(man);
    console.log(emp);
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
    switch (me) {
        case 2: newEmployees();
        break;
        case 3: promoteEmployees();
        break;
        default:
    }

} 

function promoteEmployees() {
    
    let place = document.getElementById("promoteEmployee");


        for(let j = 0 ; j < users.length; j++) {

            if(users[j].userTypeId == 1 ) {
                let option = document.createElement("option");
                option.setAttribute("value", users[j].usrId );
                option.innerHTML = users[j].firstName + " " +users[j].lastName;
    
                place.appendChild(option);
    
            }
        }
    
 

}

function newEmployees() {
    
    let place = document.getElementById("newEmployee");


        for(let j = 0 ; j < users.length; j++) {

            if(users[j].managerId === 0 && users[j].userTypeId < 3 ) {
                let option = document.createElement("option");
                option.setAttribute("value", users[j].usrId );
                option.innerHTML = users[j].firstName + " " +users[j].lastName;
    
                place.appendChild(option);
    
            }
        }
    

}
