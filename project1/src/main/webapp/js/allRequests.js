window.onload = function() {
    allRequests();
}

let requests = [];

function allRequests() {
	fetch("http://localhost:8084/project1/allRequests").then(function(response1){
		return response1.json();
	}).then(function(data){
		if (data.session === null) {
			window.location = "http://localhost:8084/project1/main";
		}
		else {
            let body = document.getElementById("requesting");
            for (let i = 0; i < data.length; i++) {
               
                if (data[i].status == 3 || 2 ) {
                    
        
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
        
                    let status = document.createElement("td");
                    if (data[i].status == 3) {
                        status.innerHTML = "Declined";
                    }
                    else {
                        status.innerHTML = "Approved";
                    }
        
        
                    
                    newTr.appendChild(newTh);
                    newTr.appendChild(reqType);
                    newTr.appendChild(description);
                    newTr.appendChild(status);
                  
        
                    body.appendChild(newTr);
        
                }
            }

          
		}
    });	


}

