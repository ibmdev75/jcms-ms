(function(a){if(typeof exports=="object"&&typeof module=="object"){a(require("../../lib/codemirror"))}else{if(typeof define=="function"&&define.amd){define(["../../lib/codemirror"],a)}else{a(CodeMirror)}}})(function(a){a.defineMode("sparql",function(c){var f=c.indentUnit;var k;function h(m){return new RegExp("^(?:"+m.join("|")+")$","i")}var b=h(["str","lang","langmatches","datatype","bound","sameterm","isiri","isuri","isblank","isliteral","a"]);var e=h(["base","prefix","select","distinct","reduced","construct","describe","ask","from","named","where","order","limit","offset","filter","optional","graph","by","asc","desc","as","having","undef","values","group","minus","in","not","service","silent","using","insert","delete","union","data","copy","to","move","add","create","drop","clear","load"]);var g=/[*+\-<>=&|]/;function d(p,n){var m=p.next();k=null;if(m=="$"||m=="?"){p.match(/^[\w\d]*/);return"variable-2"}else{if(m=="<"&&!p.match(/^[\s\u00a0=]/,false)){p.match(/^[^\s\u00a0>]*>?/);return"atom"}else{if(m=='"'||m=="'"){n.tokenize=l(m);return n.tokenize(p,n)}else{if(/[{}\(\),\.;\[\]]/.test(m)){k=m;return null}else{if(m=="#"){p.skipToEnd();return"comment"}else{if(g.test(m)){p.eatWhile(g);return null}else{if(m==":"){p.eatWhile(/[\w\d\._\-]/);return"atom"}else{p.eatWhile(/[_\w\d]/);if(p.eat(":")){p.eatWhile(/[\w\d_\-]/);return"atom"}var o=p.current();if(b.test(o)){return null}else{if(e.test(o)){return"keyword"}else{return"variable"}}}}}}}}}}function l(m){return function(q,o){var p=false,n;while((n=q.next())!=null){if(n==m&&!p){o.tokenize=d;break}p=!p&&n=="\\"}return"string"}}function i(o,n,m){o.context={prev:o.context,indent:o.indent,col:m,type:n}}function j(m){m.indent=m.context.indent;m.context=m.context.prev}return{startState:function(){return{tokenize:d,context:null,indent:0,col:0}},token:function(o,n){if(o.sol()){if(n.context&&n.context.align==null){n.context.align=false}n.indent=o.indentation()}if(o.eatSpace()){return null}var m=n.tokenize(o,n);if(m!="comment"&&n.context&&n.context.align==null&&n.context.type!="pattern"){n.context.align=true}if(k=="("){i(n,")",o.column())}else{if(k=="["){i(n,"]",o.column())}else{if(k=="{"){i(n,"}",o.column())}else{if(/[\]\}\)]/.test(k)){while(n.context&&n.context.type=="pattern"){j(n)}if(n.context&&k==n.context.type){j(n)}}else{if(k=="."&&n.context&&n.context.type=="pattern"){j(n)}else{if(/atom|string|variable/.test(m)&&n.context){if(/[\}\]]/.test(n.context.type)){i(n,"pattern",o.column())}else{if(n.context.type=="pattern"&&!n.context.align){n.context.align=true;n.context.col=o.column()}}}}}}}}return m},indent:function(q,m){var p=m&&m.charAt(0);var o=q.context;if(/[\]\}]/.test(p)){while(o&&o.type=="pattern"){o=o.prev}}var n=o&&p==o.type;if(!o){return 0}else{if(o.type=="pattern"){return o.col}else{if(o.align){return o.col+(n?0:1)}else{return o.indent+(n?0:f)}}}}}});a.defineMIME("application/x-sparql-query","sparql")});