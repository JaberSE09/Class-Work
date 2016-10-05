"use strict";
var $ = function(id) { return document.getElementById(id); };

var processEntries = function() {
	var isValid = true;
	// get values for user entries   
    var email = $("email_address").value;
    var phone = $("phone").value;
    var country = $("country").value;
    var terms = $("terms").checked;
    
	// check user entries for validity
    if (email == "") {
        $("email_address").nextElementSibling.firstChild.nodeValue = "This field is required.";
		isValid = false;
    }
	else {
		$("email_address").nextElementSibling.firstChild.nodeValue = "";	
	}
	if (phone == "") {
        $("phone").nextElementSibling.firstChild.nodeValue = "This field is required.";
		isValid = false;
    }
	else {
		$("phone").nextElementSibling.firstChild.nodeValue = "";
	}
    if (country == "") {
        $("country").nextElementSibling.firstChild.nodeValue = "Please select a country.";
		isValid = false;
    }
	else {
		$("country").nextElementSibling.firstChild.nodeValue = "";	
	}
	if (terms == false) {
        $("terms").nextElementSibling.firstChild.nodeValue = "This box must be checked.";
		isValid = false;
    }
	else {
		$("terms").nextElementSibling.firstChild.nodeValue = "";	
	}
    if(isValid)
	{
		$("registration_form").submit();
	}
        

};

  var options, mail, label, text, hide;           	// Declare variables
   options = document.getElementsByName('contact');		// Get the radio buttons
   mail = $('mail'); 
   label = $('label');     // the mail radio button and its label
   text = $('mailingAddress');
   label.className = 'hide';  // Hide label for that mailing address textarea
   text.className = 'hide';  // Hide mailing address textarea

  for (var i = 0; i < options.length; i++) 			// Loop through radios
  {         
	if (options[i].addEventListener)    				// Add event listener        
		options[i].addEventListener('click', radioChanged); // If event listener supported                               
	else                                      			// Otherwise
		options[i].attachEvent('onclick', radioChanged);    // IE fallback: onclick
  }

  function radioChanged() 
  {
    if (mail.checked)  			// Is mail button checked?
		hide ='';
    else 
		hide='hide';                
    
	label.className = hide;     // Text input visibility
	text.className = hide; 
	
    if (hide)                       // If text input hidden
      text.value = '';         // Empty its contents
  }

var resetForm = function() {
    $("registration_form").reset();
	label.className = 'hide';  // Hide label for that mailing address textarea
    text.className = 'hide';  // Hide mailing address textarea
	$("email_address").nextElementSibling.firstChild.nodeValue = "*";
	$("phone").nextElementSibling.firstChild.nodeValue = "*";	
	$("country").nextElementSibling.firstChild.nodeValue = "*";	
	$("terms").nextElementSibling.firstChild.nodeValue = "*";
    $("email_address").focus();
	
	//remove saved data from local storage as well
         localStorage.removeItem('contact');
         localStorage.removeItem('comments');
         localStorage.removeItem('text');
         
};
//check whether there is any data item in web page has been stored in localStorage or not 
if(!localStorage.getItem('email')) { //if did not have anything in the localStorage, 
  populateStorage(); //then write data into local storage
} else {  //if there is any data item has been stored 
  retrieveData();  //then retrieve data from local storage
}

//Add JavaScript code to access local storage
function populateStorage() { // function used to save data items into local storage

	localStorage.setItem('email', $('email_address').value);
	localStorage.setItem('phone', $('phone').value);
	localStorage.setItem('country', $('country').value);
        localStorage.setItem('terms', $('terms').value);
        localStorage.setItem('comments', $('comments').value);
        localStorage.setItem('text', $('mailingAddress').value);
        
    if ($('mail').checked){
  localStorage.setItem('contact', $('mail').value);
    }
    else if ($('email').checked){
  localStorage.setItem('contact', $('email').value);
    }
 else if ($('phone2').checked){
  localStorage.setItem('contact', $('phone2').value);
}
 else if ($('none').checked)
 {
  localStorage.setItem('contact', $('none').value);
 }
 else{
  localStorage.setItem('contact', ' ');
}
}
function   retrieveData() {  // function used to retrieve data and put them back to the web page
  var currentEmail = localStorage.getItem('email');
  var phone = localStorage.getItem('phone');
  var currentTerms = localStorage.getItem('terms');
  var currentCountry = localStorage.getItem('country');
  var currentComment = localStorage.getItem('comments');
  var currentText = localStorage.getItem('text');
  
  $('email_address').value = currentEmail;
  $('phone').value = phone;
  $('country').value = currentCountry;
  $('terms').value = currentTerms;
  $('comments').value = currentComment;
  $('mailingAddress').value = currentText;
  
  var radios = document.getElementsByName("contact"); // list of radio buttons
var val = localStorage.getItem('contact'); // local storage value
for(var i=0;i<radios.length;i++){
  if(radios[i].value == val){
      radios[i].checked = true; // marking the required radio as checked
  }
}
}


// when each time use changes input, then the change event will be fired, 
//and populateStorage will be the event handler
$('email_address').onchange =  populateStorage;
$('phone').onchange = populateStorage;
$('country').onchange = populateStorage;
$('terms').onchange = populateStorage;
$('comments').onchange = populateStorage;
$('mailingAddress').onchange = populateStorage;
radioChanged();
 
window.onload = function() {
    $("register").onclick = processEntries;
    $("reset_form").onclick = resetForm;    
    $("email_address").focus();
};
