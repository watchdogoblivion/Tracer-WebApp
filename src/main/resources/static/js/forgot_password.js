function disableEnter() {
	window.addEventListener('keydown', function(e) {
		if (e.keyIdentifier == 'U+000A' || e.keyIdentifier == 'Enter'
				|| e.keyCode == 13) {
			if (e.target.nodeName == 'INPUT' && e.target.type == 'text') {
				e.preventDefault();
				return false;
			}
		}
	}, true);
}

function emailExists(array) {
	var email = document.form1.email.value;
	var check = false;
	for ( var index in array) {
		if (email == array[index]) {
			check = true;
		}
	}
	if (check == false){
		document.querySelector('#email_warning').textContent = "Email does not exist";
		return false;
	} else {
		document.querySelector('#email_warning').textContent = "";
		return true;
	}
}

function validateForm(array){
	if(emailExists(array)){
		return true;
	}
	return false;
}
