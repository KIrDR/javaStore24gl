const originalValues = {};

function toggleEdit() {
   const isEditing = document.getElementById('editButton').textContent === 'OK';
   const inputs = document.querySelectorAll('input[type="text"], select');

   if (!isEditing) {
       inputs.forEach((input) => {
           if (input.id !== 'customer_num') {
               originalValues[input.id] = input.value;
               input.disabled = false;
           }
       });
       document.getElementById('editButton').textContent = 'OK';
       document.getElementById('exportButton').textContent = 'Cancel';
   } else {
       const formData = {};
       inputs.forEach((input) => {
           formData[input.name] = input.value;
       });

       fetch('/editCustomer', {
           method: 'POST',
           headers: {
               'Content-Type': 'application/json'
           },
           body: JSON.stringify(formData)
       }).then(response => {
           if (response.ok) {
               console.log('Data saved successfully');
               location.reload(); 
           } else {
               console.error('Failed to save data');
               response.text().then(text => console.error(text));
           }
       }).catch(error => {
           console.error('Error:', error);
       });

       document.getElementById('editButton').textContent = 'Edit';
       document.getElementById('exportButton').textContent = 'Export';
   }
}

function addCustomer() { 
    
   const inputs = document.querySelectorAll('input[type="text"], select');
   const formData = {};
   inputs.forEach((input) => {
    formData[input.name] = input.value;
});

fetch('/addCustomer', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(formData)
}).then(response => {
    if (response.ok) {
        console.log('Data saved successfully');
        location.reload(); 
    } else {
        console.error('Failed to save data');
        response.text().then(text => console.error(text));
    }
}).catch(error => {
    console.error('Error:', error);
});
}



function findCustomer() {
    var colname = document.getElementById("colname").value;
    var operator = document.getElementById("operator").value;
    var value = document.getElementById("value").value;

    let sqlCondition = "";

    switch(operator) {
        case "Contains":
            sqlCondition = colname + " LIKE '%" + value + "%'";
            break;
        case "Not contains":
            sqlCondition = colname + " NOT LIKE '%" + value + "%'";
            break;
        case "Begins with":
            sqlCondition = colname + " LIKE '" + value + "%'";
            break;
        case "Ends with":
            sqlCondition = colname + " LIKE '%" + value + "'";
            break;
        case "Is equal to":
            sqlCondition = colname + " = '" + value + "'";
            break;
        default:
            alert("Please select a valid operator.");
            return;
    }

    const url = new URL(window.location.origin + "/customers");
    url.searchParams.append("condition", sqlCondition);

    window.location.href = url.href;
}




document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll(".stockNum").forEach(function(td) {
        let stockNum = td.textContent.trim();
        stockNum = stockNum.padStart(4, '0');
        td.textContent = stockNum;
    });
});

    var item = 2 ; 

    var selectedItemNumber = item.trim().padStart(4,'0'); 
