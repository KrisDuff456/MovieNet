'use strict';

var data = "{}";

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
  if (this.readyState === this.DONE) {
    console.log(this.responseText);
  }
});

xhr.open("GET", "https://api.themoviedb.org/3/movie/299536/images?language=en-US&api_key=f1e80be9e1b8e062b446bd8b1f080b8d");

xhr.send(data);
