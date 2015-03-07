(function(a){if(typeof exports=="object"&&typeof module=="object"){a(require("../../lib/codemirror"))}else{if(typeof define=="function"&&define.amd){define(["../../lib/codemirror"],a)}else{a(CodeMirror)}}})(function(a){a.defineMode("r",function(e){function b(q){var p=q.split(" "),o={};for(var n=0;n<p.length;++n){o[p[n]]=true}return o}var i=b("NULL NA Inf NaN NA_integer_ NA_real_ NA_complex_ NA_character_");var c=b("list quote bquote eval return call parse deparse");var h=b("if else repeat while function for in next break");var g=b("if else repeat while function for");var d=/[+\-*\/^<>=!&|~$:]/;var k;function f(q,o){k=null;var n=q.next();if(n=="#"){q.skipToEnd();return"comment"}else{if(n=="0"&&q.eat("x")){q.eatWhile(/[\da-f]/i);return"number"}else{if(n=="."&&q.eat(/\d/)){q.match(/\d*(?:e[+\-]?\d+)?/);return"number"}else{if(/\d/.test(n)){q.match(/\d*(?:\.\d+)?(?:e[+\-]\d+)?L?/);return"number"}else{if(n=="'"||n=='"'){o.tokenize=l(n);return"string"}else{if(n=="."&&q.match(/.[.\d]+/)){return"keyword"}else{if(/[\w\.]/.test(n)&&n!="_"){q.eatWhile(/[\w\.]/);var p=q.current();if(i.propertyIsEnumerable(p)){return"atom"}if(h.propertyIsEnumerable(p)){if(g.propertyIsEnumerable(p)&&!q.match(/\s*if(\s+|$)/,false)){k="block"}return"keyword"}if(c.propertyIsEnumerable(p)){return"builtin"}return"variable"}else{if(n=="%"){if(q.skipTo("%")){q.next()}return"variable-2"}else{if(n=="<"&&q.eat("-")){return"arrow"}else{if(n=="="&&o.ctx.argList){return"arg-is"}else{if(d.test(n)){if(n=="$"){return"dollar"}q.eatWhile(d);return"operator"}else{if(/[\(\){}\[\];]/.test(n)){k=n;if(n==";"){return"semi"}return null}else{return null}}}}}}}}}}}}}function l(n){return function(r,q){if(r.eat("\\")){var p=r.next();if(p=="x"){r.match(/^[a-f0-9]{2}/i)}else{if((p=="u"||p=="U")&&r.eat("{")&&r.skipTo("}")){r.next()}else{if(p=="u"){r.match(/^[a-f0-9]{4}/i)}else{if(p=="U"){r.match(/^[a-f0-9]{8}/i)}else{if(/[0-7]/.test(p)){r.match(/^[0-7]{1,2}/)}}}}}return"string-2"}else{var o;while((o=r.next())!=null){if(o==n){q.tokenize=f;break}if(o=="\\"){r.backUp(1);break}}return"string"}}}function j(o,n,p){o.ctx={type:n,indent:o.indent,align:null,column:p.column(),prev:o.ctx}}function m(n){n.indent=n.ctx.indent;n.ctx=n.ctx.prev}return{startState:function(){return{tokenize:f,ctx:{type:"top",indent:-e.indentUnit,align:false},indent:0,afterIdent:false}},token:function(q,p){if(q.sol()){if(p.ctx.align==null){p.ctx.align=false}p.indent=q.indentation()}if(q.eatSpace()){return null}var o=p.tokenize(q,p);if(o!="comment"&&p.ctx.align==null){p.ctx.align=true}var n=p.ctx.type;if((k==";"||k=="{"||k=="}")&&n=="block"){m(p)}if(k=="{"){j(p,"}",q)}else{if(k=="("){j(p,")",q);if(p.afterIdent){p.ctx.argList=true}}else{if(k=="["){j(p,"]",q)}else{if(k=="block"){j(p,"block",q)}else{if(k==n){m(p)}}}}}p.afterIdent=o=="variable"||o=="keyword";return o},indent:function(r,o){if(r.tokenize!=f){return 0}var q=o&&o.charAt(0),n=r.ctx,p=q==n.type;if(n.type=="block"){return n.indent+(q=="{"?0:e.indentUnit)}else{if(n.align){return n.column+(p?0:1)}else{return n.indent+(p?0:e.indentUnit)}}}}});a.defineMIME("text/x-rsrc","r")});