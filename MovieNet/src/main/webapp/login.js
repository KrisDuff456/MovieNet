"use strict";
function loginvisibility(){
	let login = document.getElementById("loginArea");
	let showVisibility = document.getElementById("showLogin");
	
	let vis = login.style;
	
	if(vis.display =='' || vis.display=='none'){
		vis.display = 'block';
	}else{
		vis.display = 'none';
}
console.log("is it open" + vis);
}

