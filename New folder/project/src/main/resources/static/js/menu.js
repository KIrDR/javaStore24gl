 function addMenuItem(text, href) {
        var menu = document.getElementById('menu');
        var newItem = document.createElement('a');
        newItem.href = href;
        newItem.textContent = text;
        menu.appendChild(newItem);
    }

    document.addEventListener('DOMContentLoaded', function() {

        var path = window.location.pathname;
        if (path.includes('/customers')) {
            addMenuItem('Customers', '/customers');
        }

    });