window.CodeMirror={};(function(){function a(e){return e.split(/\r?\n|\r/)}function b(e){this.pos=this.start=0;this.string=e;this.lineStart=0}b.prototype={eol:function(){return this.pos>=this.string.length},sol:function(){return this.pos==0},peek:function(){return this.string.charAt(this.pos)||null},next:function(){if(this.pos<this.string.length){return this.string.charAt(this.pos++)}},eat:function(e){var g=this.string.charAt(this.pos);if(typeof e=="string"){var f=g==e}else{var f=g&&(e.test?e.test(g):e(g))}if(f){++this.pos;return g}},eatWhile:function(e){var f=this.pos;while(this.eat(e)){}return this.pos>f},eatSpace:function(){var e=this.pos;while(/[\s\u00a0]/.test(this.string.charAt(this.pos))){++this.pos}return this.pos>e},skipToEnd:function(){this.pos=this.string.length},skipTo:function(e){var f=this.string.indexOf(e,this.pos);if(f>-1){this.pos=f;return true}},backUp:function(e){this.pos-=e},column:function(){return this.start-this.lineStart},indentation:function(){return 0},match:function(i,f,e){if(typeof i=="string"){var j=function(k){return e?k.toLowerCase():k};var h=this.string.substr(this.pos,i.length);if(j(h)==j(i)){if(f!==false){this.pos+=i.length}return true}}else{var g=this.string.slice(this.pos).match(i);if(g&&g.index>0){return null}if(g&&f!==false){this.pos+=g[0].length}return g}},current:function(){return this.string.slice(this.start,this.pos)},hideFirstChars:function(f,e){this.lineStart+=f;try{return e()}finally{this.lineStart-=f}}};CodeMirror.StringStream=b;CodeMirror.startState=function(g,f,e){return g.startState?g.startState(f,e):true};var c=CodeMirror.modes={},d=CodeMirror.mimeModes={};CodeMirror.defineMode=function(e,f){c[e]=f};CodeMirror.defineMIME=function(f,e){d[f]=e};CodeMirror.resolveMode=function(e){if(typeof e=="string"&&d.hasOwnProperty(e)){e=d[e]}else{if(e&&typeof e.name=="string"&&d.hasOwnProperty(e.name)){e=d[e.name]}}if(typeof e=="string"){return{name:e}}else{return e||{name:"null"}}};CodeMirror.getMode=function(f,e){e=CodeMirror.resolveMode(e);var g=c[e.name];if(!g){throw new Error("Unknown mode: "+e)}return g(f,e)};CodeMirror.registerHelper=CodeMirror.registerGlobalHelper=Math.min;CodeMirror.defineMode("null",function(){return{token:function(e){e.skipToEnd()}}});CodeMirror.defineMIME("text/plain","null");CodeMirror.runMode=function(n,k,r,t){var m=CodeMirror.getMode({indentUnit:2},k);if(r.nodeType==1){var o=(t&&t.tabSize)||4;var j=r,h=0;j.innerHTML="";r=function(z,w){if(z=="\n"){j.appendChild(document.createElement("br"));h=0;return}var x="";for(var A=0;;){var e=z.indexOf("\t",A);if(e==-1){x+=z.slice(A);h+=z.length-A;break}else{h+=e-A;x+=z.slice(A,e);var v=o-h%o;h+=v;for(var u=0;u<v;++u){x+=" "}A=e+1}}if(w){var y=j.appendChild(document.createElement("span"));y.className="cm-"+w.replace(/ +/g," cm-");y.appendChild(document.createTextNode(x))}else{j.appendChild(document.createTextNode(x))}}}var s=a(n),g=(t&&t.state)||CodeMirror.startState(m);for(var l=0,p=s.length;l<p;++l){if(l){r("\n")}var q=new CodeMirror.StringStream(s[l]);while(!q.eol()){var f=m.token(q,g);r(q.current(),f,l,q.start,g);q.start=q.pos}}}})();