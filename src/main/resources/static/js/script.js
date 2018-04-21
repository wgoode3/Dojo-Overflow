"use strict";
		
function postData(url, data) {
	// Default options are marked with *
	return fetch(url, {
		body: JSON.stringify(data), // must match 'Content-Type' header
		cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
		credentials: 'same-origin', // include, same-origin, *omit
		headers: {
			'user-agent': 'Mozilla/4.0 MDN Example',
			'content-type': 'application/json'
		},
		method: 'POST', // *GET, POST, PUT, DELETE, etc.
		mode: 'cors', // no-cors, cors, *same-origin
		redirect: 'follow', // *manual, follow, error
		referrer: 'no-referrer', // *client, no-referrer
	})
	.then(response => response.json()) // parses response to JSON
}
	
let tags = 1;
let thing = "tags0";
const form = document.querySelector("form");
		
function listener(e){
	if(e.target.value.length > 1){
		let p = document.createElement("p");
		let t = document.createElement("textarea");
		t.setAttribute("rows", 1);
		t.setAttribute("cols", 60);
		t.setAttribute("name", "tags" + tags);
		p.appendChild(t);
		form.children[tags].insertAdjacentElement("afterEnd", p);
		let ele = document.querySelector("textarea[name=" + thing + "]");
		ele.removeEventListener("input", listener);
		thing = "tags" + tags++;
		newTag(document.querySelector("textarea[name=" + thing + "]"));
	}
}
		
function newTag(ele){
	ele.addEventListener("input", listener);
}
		
newTag(document.querySelector("textarea[name='tags0']"));
		
form.addEventListener("submit", function(e){
	e.preventDefault();
	let data = {"question": ""};
	for(let x of e.path[0]){
		if(x.name && x.value){				
			data[x.name] = x.value;
		}
	}
	postData('/test', data)
	.then(res => {
		if(res.valid){
			window.location = "/";
		}else{
			console.log("There was an error!")
			document.querySelector("[data-errors='hide']").style.display = "inline-block";
		}
	})
	.catch(error => console.error(error))
	return;
});