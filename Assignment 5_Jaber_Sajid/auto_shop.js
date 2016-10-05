// Define a car object using a constructor function
function Car(id, car_make, car_model, car_year, car_type, car_color, car_price, car_mileage) {
	this.stockid = id;
	this.make = car_make;
	this.model = car_model;
	this.year = car_year;
	this.type = car_type;
	this.color = car_color;
	this.price = car_price;
	this.mileage = car_mileage;
	this.display = function(){
		var this_str = "<td>" + this.stockid + "</td><td>" + this.make + "</td>";
		this_str += "<td>" + this.model + "</td><td>" + this.year + "</td><td>" + this.type + "</td>";
		this_str += "<td>" + this.color + "</td><td> $" + this.price + "</td>";
		this_str += "<td>" + this.mileage + "</td>";
		return this_str;
	};
}


// Declare an array of objects
var car_list = [];  // var car_list = new Array();

// Create an instance of the Car object and add it to the car_list array
car_list.push(new Car(1001, "Toyota", "Camry", 2011, "Sedan", "Gray", 17555, 55060));
car_list.push(new Car(1002, "Volvo", "s40", 2013, "Sedan", "Black", 15575, 20350));
car_list.push(new Car(1251, "Toyota", "Sienna", 2008, "Minivan", "Gray", 15775, 70000));
car_list.push(new Car(1321, "Porsche", "Panamera", 2012, "Hatchback", "Red", 104250, 10567));
car_list.push(new Car(1904, "Honda", "Accord", 2009, "Sedan", "White", 13370, 35000));
car_list.push(new Car(1855, "Toyota", "Highlander", 2008, "SUV", "Silver", 18555, 55060));
car_list.push(new Car(1543, "Ford", "Fusion", 2011, "Sedan", "Black", 13575, 90350));
car_list.push(new Car(1345, "Toyota", "Sienna", 2011, "Minivan", "Gray", 25775, 70000));
car_list.push(new Car(2133, "Dodge", "Caravan", 2012, "Minivan", "Red", 30250, 17567));
car_list.push(new Car(2999, "Lexus", "LFA", 2012, "coupe", "Red", 381370, 3500));
car_list.push(new Car(3001, "Ferrari", "Rubino", 2012, "coupe", "Red", 354370, 5500));
car_list.push(new Car(4002, "Audi", "R8", 2012, "convertible", "Black", 181370, 4500));

// Display car list
for (var i=0; i<car_list.length; i++){
	//create a new <tr> element: a table row
	var newTrElement = document.createElement('tr');    
        newTrElement.className = 'car-item';
	newTrElement.id = 'l-'+i;
        newTrElement.innerHTML = car_list[i].display();  //add car info and Add button to each new table row
	
       //attach new table row to the car-list table
       var table = document.getElementById('car-list');
       var row   = table.appendChild(newTrElement);
      var cell= row.insertCell();
        var btn = document.createElement('BUTTON');        
        var t = document.createTextNode("add");  
        btn.appendChild(t);    
        btn.value=i;
        btn.className= 'car-item';
        btn.id='addme';
      cell.appendChild(btn);
      }


 /* attach an event handler to all the Add buttons*/
 var elements = document.getElementsByClassName('car-item'); //returns an array
 for (var i=0; i<elements.length; i++){
	elements[i].onclick = addItem;
 }
 
 
 // define an array to hold the index of the car added to the shopping chart
 var cart = [];
 function addItem(){
 /* This  function defines an event handler that adds a car to shopping cart
 */
	// Read the array-index of the item. The keyword 'this' refers to the HTML element
	// the event handler is attached to (button).
	var index = this.value; // return the value of the value attribute in each "add" button
	
	// invoke the addNewItemtoCart() to display selected product identified by it's array-index
	 addNewItemtoCart(car_list[index]);
	 cart.push(index); 
 }

 function addNewItemtoCart(item){
 /* This function creates and adds a new table row to an existing table
 */
	//create a new <tr> element: a table row
	var newTrElement = document.createElement('tr');
	
	// create a <td> element using item.make as content
        var newTdElement = createNewTdElement(item.make);
	// append it to the new tr element
        newTrElement.appendChild(newTdElement);
	// create a <td> element using item.model as content
        var newTdElement = createNewTdElement(item.model);
	// append it to the new tr element
        newTrElement.appendChild(newTdElement);
	// create a <td> element using item.price as content
	var newTdElement = createNewTdElement(item.price);
	// append it to the new tr element
        newTrElement.appendChild(newTdElement);
	//append new <tr> element to the shopping cart
	document.getElementById('mycart').appendChild(newTrElement);
        }
 
 function createNewTdElement(cell_content){
 /* This function creates and returns a new table cell using  the following steps:
	1. create a new text node using createTextNode() method
	2. create a new 'td' element using createElement() method
	3. append the newly created text node to the new 'td' element
	4. return the newly created 'td' element
 */
	// create a text node
	var newTextNode = document.createTextNode(cell_content);
	// create a new td element
	var newTdElement = document.createElement('td');
	// append text node to the new td element
	newTdElement.appendChild(newTextNode);
	return newTdElement;
 }
 
 /* add script code below to attach an event handler to the display minivan button*/
var element = document.getElementById('p2'); //returns an array
 element.onclick=displayMinivan;
 
 /* define displayMinivan function */
function displayMinivan()
{
for (var i=0; i<car_list.length; i++){
	//create a new <tr> element: a table row
	if(car_list[i].type === 'Minivan'){
        var newTrElement = document.createElement('tr');    
        newTrElement.className = 'minivan-list';
	newTrElement.id = 'l-'+i;
        newTrElement.innerHTML = car_list[i].display();  //add car info and Add button to each new table row
	
       //attach new table row to the car-list table
       var table = document.getElementById('minivan-list');
       var row   = table.appendChild(newTrElement);
  }
}
}
 
 /*add script code below to attach an event handler to the display invoice button*/
var element = document.getElementById('p4'); //returns an array
 element.onclick=displayInvoice;
 
 
/* define displayInvoice function */
 function displayInvoice()
 {
     if(cart.length<=0){
         alert("Your cart is empty!”");
     }
     else{
	document.getElementById('total-items').innerHTML=(cart.length);
        var subtotal=0;
        for (var i=0;i<cart.length;i++){
            var index=cart[i];
            subtotal=subtotal+car_list[index].price;
        }
        document.getElementById('sub-total').innerHTML=subtotal;
        var taxes=subtotal*0.06;
        document.getElementById('taxes').innerHTML=taxes;
        var reg=subtotal*0.05;
        document.getElementById('registration').innerHTML=reg;
        var total=subtotal+taxes+reg;
        document.getElementById('total').innerHTML=total;
 }
 }