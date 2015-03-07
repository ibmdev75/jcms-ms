var Wiki2HTML=function(l){if(!l){return""}var d=l;function g(n,o){d=d.replace(n,o)}var k=0;var j=1;var c=2;function f(){var x=/^((   )+)(\#|\*|\d+|(([^\s:]+):)) (.+?)(\n|$)/gim;var w=0;var E="";var q=0;var r=k;var p=[];while((m=x.exec(d))!=null){var v=d.substr(w,(m.index-w));w=x.lastIndex;if(q>0&&v&&v.trim().length>0){E+="</li>\n";for(var A=0;A<q;A++){var o=p.pop();E+=o}q=0}var t=m[0];var u=m[1];var s=m[3];var y=m[6];if(u.length%3!=0){continue}var n=u.length/3;var C=n-q;var B=s.charAt(0)==="#";if(B&&C==0){E+="<br />\n";E+=y;continue}if(C>0){E+=v;for(var A=0;A<C;A++){var D=s.charAt(0);if(D>="0"&&D<="9"){if(n>1){E+="<ol>\n";p.push("</ol>\n</li>\n")}else{E+="</p>\n<ol>\n";p.push("</ol>\n<p>\n")}r=j}else{if(D=="*"){if(n>1){E+="<ul>\n";p.push("</ul>\n</li>\n")}else{E+="</p>\n<ul>\n";p.push("</ul>\n<p>\n")}r=k}else{E+="<dl>\n";p.push("</dl>\n<p>\n");r=c}}}}else{if(C<0){if(r!=c){E+="</li>\n"}E+=v;for(var A=0;A<-C;A++){var o=p.pop();E+=o}}else{if(r!=c){E+="</li>\n"}E+=v}}if(r==c){E+="<dt>"+d.group(5)+"</dt>\n<dd>"+y+"</dd>\n"}else{E+="<li>"+y}q=n}if(q>0&&r!=c){E+="</li>\n"}for(var A=0;A<q;A++){var o=p.pop();E+=o}var z=d.substr(w,(d.length-w));E+=z;d=E}function e(){var x=new RegExp("^s*([|\xa7](.+)[|\xa7])s*$","gim");var u=0;var p="";var s=false;while((m=x.exec(d))!=null){var A=d.substr(u,(m.index-u));var q=m[0];u=x.lastIndex;if(s&&!A&&A.trim().length>0){p+="</table>\n<p>\n";s=false}if(!s){p+=A;p+='</p>\n<table border="0" cellspacing="1">\n';s=true}p+="  <tr>\n";var y=q.split(/([|\xa7])/);var n=null;for(var o=1;o<y.length;o++){var v=y[o];if(!n){n=v}else{if(o==y.length-1){break}var z=(n==="\xa7")?"th":"td";var w=v.length;var r;if(w>=2&&v.charAt(w-1)==" "&&v.charAt(w-2)!=" "){r="right"}else{if(w>=2&&v.charAt(1)==" "){r="center"}else{r="left"}}p+="    <"+z+' align="'+r+'">'+v.trim()+"</"+z+">\n";n=null}}p+="  </tr>\n"}if(s){p+="</table>\n<p>\n"}var t=d.substr(u,(d.length-u));p+=t;d=p}var a="@@@VERBATIM@@@";var b=[];function i(){var r=/\[verbatim\]([\s\S]*?)\[\/verbatim\]/gim;var n=0;var s="";while((m=r.exec(d))!=null){var p=d.substr(n,(m.index-n));var q=m[1];n=r.lastIndex;s+=p;s+=a;b.push(q)}var o=d.substr(n,(d.length-n));s+=o;d=s}function h(){var q=/@@@VERBATIM@@@/gim;var r=0;var n=0;var s="";while((m=q.exec(d))!=null){var p=d.substr(n,(m.index-n));n=q.lastIndex;s+=p;s+="</p>\n<pre>"+b[r]+"</pre>\n<p>\n";r++}var o=d.substr(n,(d.length-n));s+=o;d=s}g(/\r\n/gi,"\n");g(/>/gi,"&gt;");g(/</gi,"&lt;");i();f();g(/(^|[\s\(])__([^_]*?)__/gi,"$1<strong><em>$2</em></strong>");g(/(^|[\s\(])_([^_]*?)_/gi,"$1<em>$2</em>");g(/(^|[\s\(])\*([^\*]*?)\*/gi,"$1<strong>$2</strong>");g(/(^|[\s\(])==([^=]*?)==/gi,"$1<code><strong>$2</strong></code>");g(/(^|[\s\(])=([^=]*?)=/gi,"$1<code>$2</code>");g(/^\s*\n/gim,"\n</p>\n<p>\n");g(/#\s*\n/gi,"<br/>\n");g(/^-------\n/gim,"</p>\n<hr/>\n<p>\n");g(/^---\+\+\s+(.*)$/gim,"</p>\n<h1>$1</h1>\n<p>\n");g(/^---\+\+\+\s+(.*)$/gim,"</p>\n<h2>$1</h2>\n<p>\n");g(/^---\+\+\+\+\s+(.*)$/gim,"</p>\n<h3>$1</h3>\n<p>\n");g(/\[\[(([^\s\[\]]+?)\.(gif|jpg|png))\]\[(\d*)\s*x\s*(\d*)\]\]/gi,'<img src="$1?w=$4&h=$5" alt="$2" width="$4" height="$5" />');g(/\[\[(([^\s\[\]]+?)\.(gif|jpg|png))\]\]/gi,'<img src="$1" alt="$2" />');g(/\[\[(([^\]@]+?)@([^\]]+?))\]\]/gi,'<a href="mailto:$1">$1</a>');g(/\[\[(([^\]@]+?)@([^\]]+?))\]\[([^\]]+?)\]\]/gi,'<a href="mailto:$1">$4</a>');g(/\[\[([^\]]+?)\]\]/gi,'<a href="$1">$1</a>');g(/\[\[([^\]]+?)\]\[([^\]]+?)\]\]/gi,'<a href="$1">$2</a>');g(/\[quote\]([\s\S]*?)\[\/quote\]/,"</p>\n<blockquote>\n$1</blockquote>\n<p>\n");e();h();d='<p class="first">\n'+d+"</p>\n";g(/<p>[\n\s]*<\/p>\n/gim,"");g(/^<p( class=\"first\")?>\s*<\/p>\n/gi,"");g(/<p>\n\s*<\/p>\n$/gi,"");g(/(<p[^>]*>\s*)+(<p[^>]*>)/gi,"$2");return d};