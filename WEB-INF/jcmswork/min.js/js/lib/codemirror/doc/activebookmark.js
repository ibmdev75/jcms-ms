document.createElement("section");document.createElement("article");(function(){if(!window.addEventListener){return}var b=false,d=null;function a(){if(!b){b=true;setTimeout(c,250)}}function c(){b=false;var h=document.getElementById("nav").getElementsByTagName("a"),k;for(var g=0;g<h.length;++g){var o=h[g],e;if(o.getAttribute("data-default")){if(k==null){k=g}}else{if(e=o.href.match(/#(.*)/)){var j=document.getElementById(e[1]);if(j&&j.getBoundingClientRect().top<50){k=g}}}}if(k!=null&&k!=d){d=k;var f=document.getElementById("nav").getElementsByTagName("li");for(var g=0;g<f.length;++g){f[g].className=""}for(var g=0;g<h.length;++g){if(k==g){h[g].className="active";for(var l=h[g];l;l=l.parentNode){if(l.nodeName=="LI"){l.className="active"}}}else{h[g].className=""}}}}window.addEventListener("scroll",a);window.addEventListener("load",a);window.addEventListener("hashchange",function(){setTimeout(function(){var j=document.location.hash,h=null,e;var g=document.getElementById("nav").getElementsByTagName("a");for(var f=0;f<g.length;f++){if((e=g[f].href.match(/(#.*)/))&&e[1]==j){h=f;break}}if(h!=null){for(var f=0;f<g.length;f++){g[f].className=f==h?"active":""}}},300)})})();