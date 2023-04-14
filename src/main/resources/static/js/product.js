document.addEventListener("DOMContentLoaded", function(event){
	
	var submit = document.getElementById("submit");

	submit.addEventListener("click", function(){
		submit.setAttribute("disabled","disabled");
		var name = document.getElementById("name");
		var file = document.getElementById("image");
		var price = document.getElementById("price");
		var description = document.getElementById("description");
		var instock = document.getElementById("instock");
		var manufacturer = document.getElementById("manufacturer");
		var category = document.getElementById("category");
		var condition = document.getElementById("condition");
		
		var form = document.getElementById("form");

		let data = new FormData(form);

		data.append("name",name);
		data.append("price",price);
		data.append("description",description);
		data.append("instock",instock);
		data.append("manufacturer",manufacturer);
		data.append("category",category);
		data.append("condition",condition);

		if(name === "" || file === "" || price === "" || description === "", instock === "", manufacturer === "", category === "", condition === "") {
			submit.removeAttribute("disabled");
			name.style.borderColor = "red";
			image.style.borderColor = "red";
			price.style.borderColor = "red";
			description.style.borderColor = "red";
		}else{
			name.style.borderColor = "";
			image.style.borderColor = "";
			price.style.borderColor = "";
			description.style.borderColor = "";

			const xhr = new XMLHttpRequest();
			xhr.open('POST', form.getAttribute("action"),true);
			xhr.send(data);
		}

	})
});