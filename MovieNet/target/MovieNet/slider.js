"use strict";

 let sliderIndex = 0;
 showSlides();

function showSlides(){
	let i;
    let slides = document.getElementsByClassName("imageSlide");
    console.log("Check number of slides: " + slides);
	for (i=0; i < slides.length; i++){
		slides[i].style.display = "none";
	}
	sliderIndex++
	if(sliderIndex > slides.length){
		sliderIndex = 1;
	}
	slides[sliderIndex-1].style.display = "block";
	setTimeout(showSlides, 10000);
}