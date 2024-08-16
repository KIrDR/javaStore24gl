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
