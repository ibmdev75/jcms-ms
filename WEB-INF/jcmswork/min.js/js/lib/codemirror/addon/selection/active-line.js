(function(a){if(typeof exports=="object"&&typeof module=="object"){a(require("../../lib/codemirror"))}else{if(typeof define=="function"&&define.amd){define(["../../lib/codemirror"],a)}else{a(CodeMirror)}}})(function(c){var g="CodeMirror-activeline";var f="CodeMirror-activeline-background";c.defineOption("styleActiveLine",false,function(h,k,i){var j=i&&i!=c.Init;if(k&&!j){h.state.activeLines=[];e(h,h.listSelections());h.on("beforeSelectionChange",b)}else{if(!k&&j){h.off("beforeSelectionChange",b);d(h);delete h.state.activeLines}}});function d(h){for(var j=0;j<h.state.activeLines.length;j++){h.removeLineClass(h.state.activeLines[j],"wrap",g);h.removeLineClass(h.state.activeLines[j],"background",f)}}function a(j,h){if(j.length!=h.length){return false}for(var k=0;k<j.length;k++){if(j[k]!=h[k]){return false}}return true}function e(h,k){var m=[];for(var l=0;l<k.length;l++){var j=h.getLineHandleVisualStart(k[l].head.line);if(m[m.length-1]!=j){m.push(j)}}if(a(h.state.activeLines,m)){return}h.operation(function(){d(h);for(var n=0;n<m.length;n++){h.addLineClass(m[n],"wrap",g);h.addLineClass(m[n],"background",f)}h.state.activeLines=m})}function b(h,i){e(h,i.ranges)}});