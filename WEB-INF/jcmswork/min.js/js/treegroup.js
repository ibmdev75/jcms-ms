var TreeGroup={toggle:function(b,a){b=$(b);a.toggle();if(a.style.display==""){b.addClassName("open")}else{b.removeClassName("open")}},init:function(){$$(".tree img").each(function(a){Event.observe(a,"click",function(){var b=a.parentNode;$A(b.childNodes).each(function(c){if(c.tagName!="UL"){return}$(c).toggle();if(c.style.display==""){a.src="images/jalios/icons/groupParentOpened.gif"}else{a.src="images/jalios/icons/groupParent.gif"}})})})}};