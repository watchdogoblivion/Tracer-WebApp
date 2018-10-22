function re() {
	window.location.replace("http://stackoverflow.com");
}

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

function validateFirstname() {
	var firstname = document.form1.firstname.value;
	var re = /^[A-Za-z-']{1,32}$/;
	if (!re.test(firstname)) {
		document.querySelector('#firstname_warning').textContent = "Invalid first name, please use Letters, dashes, and apostrophes.";
		return true;
	} else {
		document.querySelector('#firstname_warning').textContent = "";
		return true;
	}
}

function validateLastname() {
	var lastname = document.form1.lastname.value;
	var re = /^[A-Za-z-']{1,32}$/;
	if (!re.test(lastname)) {
		document.querySelector('#lastname_warning').textContent = "Invalid last name, please use Letters, dashes, and apostrophes.";
		return true;
	} else {
		document.querySelector('#lastname_warning').textContent = "";
		return true;
	}
}

function validateUsername(array) {
	var username = document.form1.username.value;
	var re = /^[A-Za-z0-9]{3,20}$/;
	if (!re.test(username)) {
		document.querySelector('#username_warning').textContent = "Invalid username, please use letters and numbers";
		return true;
	}
	for ( var index in array) {
		if (document.form1.username.value == array[index]) {
			document.querySelector('#username_warning').textContent = "Username "
					+ array[index] + " already exists";
			return true;
		}
	}
	document.querySelector('#username_warning').textContent = "";
	return true;
}

function validateEmail() {
	var email = document.form1.email.value;
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (!re.test(email)) {
		document.querySelector('#email_warning').textContent = "Invalid email address";
		return true;
	} else {
		document.querySelector('#email_warning').textContent = "";
		return true;
	}
}

function validatePassword() {
	// at least one number, one lowercase and one uppercase letter
	// at least six characters
	var password = document.form1.password.value;
	var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
	var newline = "\r\n";
	if (!re.test(password)) {
		document.querySelector('#password_warning').textContent = "Required" + newline + "At least one number, one lowercase and one uppercase letter." 
			+ newline + "At least six characters.";
		password = "";
		return true;
	} else {
		document.querySelector('#password_warning').textContent = "";
		password = "";
		return true;
	}
}

function validatePasswordEquality() {
	var password = document.form1.password.value;
	var psw_repeat = document.form1.psw_repeat.value;
	if (password !== psw_repeat) {
		document.querySelector('#psw_repeat_warning').textContent = "Passwords do not match";
		password = ""; psw_repeat = "";
		return true;
	} else {
		document.querySelector('#psw_repeat_warning').textContent = "";
		password = ""; psw_repeat = "";
		return true;
	}
}

function validateForm(array){
	if(validateFirstname() && validateLastname() && validateUsername(array) && 
			validateEmail() && validatePassword() && validatePasswordEquality()){
		return true;
	}
	return false;
}