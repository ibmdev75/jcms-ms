(function(a){if(typeof exports=="object"&&typeof module=="object"){a(require("../../lib/codemirror"),require("../htmlmixed/htmlmixed"),require("../smarty/smarty"))}else{if(typeof define=="function"&&define.amd){define(["../../lib/codemirror","../htmlmixed/htmlmixed","../smarty/smarty"],a)}else{a(CodeMirror)}}})(function(a){a.defineMode("smartymixed",function(c){var f,e,g,d,h=a.getMode(c,"htmlmixed"),b=a.getMode(c,"smarty"),f={rightDelimiter:"}",leftDelimiter:"{"};if(c.hasOwnProperty("leftDelimiter")){f.leftDelimiter=c.leftDelimiter}if(c.hasOwnProperty("rightDelimiter")){f.rightDelimiter=c.rightDelimiter}e={smartyComment:new RegExp("^"+f.leftDelimiter+"\\*"),literalOpen:new RegExp(f.leftDelimiter+"literal"+f.rightDelimiter),literalClose:new RegExp(f.leftDelimiter+"/literal"+f.rightDelimiter),hasLeftDelimeter:new RegExp(".*"+f.leftDelimiter),htmlHasLeftDelimeter:new RegExp("[^<>]*"+f.leftDelimiter)};g={chain:function(j,i,k){i.tokenize=k;return k(j,i)},cleanChain:function(j,i,k){i.tokenize=null;i.localState=null;i.localMode=null;return(typeof k=="string")?(k?k:null):k(j,i)},maybeBackup:function(o,j,k){var n=o.current();var l=n.search(j),i;if(l>-1){o.backUp(n.length-l)}else{if(i=n.match(/<\/?$/)){o.backUp(n.length);if(!o.match(j,false)){o.match(n[0])}}}return k}};d={html:function(j,i){if(!i.inLiteral&&j.match(e.htmlHasLeftDelimeter,false)&&i.htmlMixedState.htmlState.tagName===null){i.tokenize=d.smarty;i.localMode=b;i.localState=b.startState(h.indent(i.htmlMixedState,""));return g.maybeBackup(j,f.leftDelimiter,b.token(j,i.localState))}else{if(!i.inLiteral&&j.match(f.leftDelimiter,false)){i.tokenize=d.smarty;i.localMode=b;i.localState=b.startState(h.indent(i.htmlMixedState,""));return g.maybeBackup(j,f.leftDelimiter,b.token(j,i.localState))}}return h.token(j,i.htmlMixedState)},smarty:function(j,i){if(j.match(f.leftDelimiter,false)){if(j.match(e.smartyComment,false)){return g.chain(j,i,d.inBlock("comment","*"+f.rightDelimiter))}}else{if(j.match(f.rightDelimiter,false)){j.eat(f.rightDelimiter);i.tokenize=d.html;i.localMode=h;i.localState=i.htmlMixedState;return"tag"}}return g.maybeBackup(j,f.rightDelimiter,b.token(j,i.localState))},inBlock:function(j,i){return function(l,k){while(!l.eol()){if(l.match(i)){g.cleanChain(l,k,"");break}l.next()}return j}}};return{startState:function(){var i=h.startState();return{token:d.html,localMode:null,localState:null,htmlMixedState:i,tokenize:null,inLiteral:false}},copyState:function(k){var j=null,i=(k.tokenize||k.token);if(k.localState){j=a.copyState((i!=d.html?b:h),k.localState)}return{token:k.token,tokenize:k.tokenize,localMode:k.localMode,localState:j,htmlMixedState:a.copyState(h,k.htmlMixedState),inLiteral:k.inLiteral}},token:function(k,j){if(k.match(f.leftDelimiter,false)){if(!j.inLiteral&&k.match(e.literalOpen,true)){j.inLiteral=true;return"keyword"}else{if(j.inLiteral&&k.match(e.literalClose,true)){j.inLiteral=false;return"keyword"}}}if(j.inLiteral&&j.localState!=j.htmlMixedState){j.tokenize=d.html;j.localMode=h;j.localState=j.htmlMixedState}var i=(j.tokenize||j.token)(k,j);return i},indent:function(j,i){if(j.localMode==b||(j.inLiteral&&!j.localMode)||e.hasLeftDelimeter.test(i)){return a.Pass}return h.indent(j.htmlMixedState,i)},innerMode:function(i){return{state:i.localState||i.htmlMixedState,mode:i.localMode||h}}}},"htmlmixed","smarty");a.defineMIME("text/x-smarty","smartymixed")});